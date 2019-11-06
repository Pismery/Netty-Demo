package org.pismery.demo.netty.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioChatClient {

    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8989));

        while (true) {
            selector.select();
            Set<SelectionKey> keySet = selector.selectedKeys();

            for (SelectionKey selectionKey : keySet) {
                if (selectionKey.isConnectable()) {
                    SocketChannel client = (SocketChannel) selectionKey.channel();

                    if (client.isConnectionPending()) {
                        client.finishConnect();

                        ByteBuffer writerBuffer = ByteBuffer.allocate(1024);
                        writerBuffer.put((LocalDateTime.now() + ": 连接成功").getBytes());
                        writerBuffer.flip();
                        client.write(writerBuffer);


                        ExecutorService service = Executors.newSingleThreadExecutor();
                        service.submit(() -> {
                            while (true) {
                                writerBuffer.clear();
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                                try {
                                    String line = br.readLine();
                                    writerBuffer.put(line.getBytes());
                                    writerBuffer.flip();
                                    client.write(writerBuffer);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                    }
                    client.register(selector, SelectionKey.OP_READ);
                    continue;
                }

                if (selectionKey.isReadable()) {
                    SocketChannel client = (SocketChannel) selectionKey.channel();
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    int read = client.read(readBuffer);
                    if (read <= 0) {
                        continue;
                    }


                    readBuffer.flip();
                    Charset charset = Charset.forName("utf-8");
                    String msg = String.valueOf(charset.decode(readBuffer).array());
                    System.out.println(new String(readBuffer.array(), 0, read));
                }
            }
            keySet.clear();
        }
    }
}
