package org.pismery.demo.netty.zerocopy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NewServer {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(new InetSocketAddress(8081));

        ByteBuffer buffer = ByteBuffer.allocate(4096);
        System.out.println("Server startup...");
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(true);

            int readCount = 0;
            try {
                while (-1 != readCount) {
                    readCount = socketChannel.read(buffer);
                    buffer.rewind();
                }
            } catch (IOException e) {
//                e.printStackTrace();
            }

        }
    }
}
