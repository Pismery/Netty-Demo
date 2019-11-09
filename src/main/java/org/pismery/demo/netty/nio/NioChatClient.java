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
    private static Selector selector;

    /**
     * @startuml
     * Client -> Client: connectToServer
     *
     * Client -> Client: doConnected
     * activate Client
     *      Client -> Client: handle select key events
     *      activate Client
     *          Client -> Client: handle connectable Event
     *          activate Client
     *              loop
     *                  Client -> KeyboardInput: listenKeyboardInput
     *                  activate KeyboardInput
     *                      alt input a line
     *                          KeyboardInput -> Channel: send msg
     *                      end
     *                  deactivate KeyboardInput
     *              end
     *          deactivate Client
     *
     *          Client -> Client: handle readable event
     *          activate Client
     *              Client -> Client: read channel Msg
     *          deactivate Client
     *      deactivate Client
     * deactivate Client
     * @enduml
     */
    public static void main(String[] args) throws Exception {
        connectToServer();
        while (true) {
            doConnected();
        }
    }

    public static void connectToServer() throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8989));
    }

    private static void doConnected() throws IOException {
        selector.select();
        Set<SelectionKey> keySet = selector.selectedKeys();
        for (SelectionKey selectionKey : keySet) {
            if (selectionKey.isConnectable()) {
                handleConnectable(selectionKey);
            } else if (selectionKey.isReadable()) {
                handleReadable(selectionKey);
            }
        }
        keySet.clear();
    }

    private static void handleReadable(SelectionKey selectionKey) throws IOException {
        SocketChannel client = (SocketChannel) selectionKey.channel();
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        int read = client.read(readBuffer);
        if (read <= 0) {
            return;
        }

        readBuffer.flip();
        Charset charset = Charset.forName("utf-8");
        String msg = String.valueOf(charset.decode(readBuffer).array());
        System.out.println(msg);
    }

    private static void handleConnectable(SelectionKey selectionKey) throws IOException {
        SocketChannel client = (SocketChannel) selectionKey.channel();

        if (client.isConnectionPending()) {
            client.finishConnect();

            ByteBuffer writerBuffer = ByteBuffer.allocate(1024);
            writerBuffer.put((LocalDateTime.now() + ": 连接成功").getBytes());
            writerBuffer.flip();
            client.write(writerBuffer);

            listenKeyboardInput(client);

        }
        client.register(selector, SelectionKey.OP_READ);
    }

    private static void listenKeyboardInput(SocketChannel client) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(() -> {
            ByteBuffer writerBuffer = ByteBuffer.allocate(1024);
            while (true) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                try {
                    writerBuffer.clear();
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
}
