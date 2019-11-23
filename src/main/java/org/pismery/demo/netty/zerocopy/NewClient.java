package org.pismery.demo.netty.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NewClient {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(8081));
        socketChannel.configureBlocking(true);
        String filePath = "E:\\Video\\Netty\\1111.mp4";

        FileChannel fileChannel = new FileInputStream(filePath).getChannel();
        long startTime = System.currentTimeMillis();
        long fileSize = fileChannel.size();
        long remainSize = fileChannel.size();
        int readTotal = 0;
        while (readTotal < fileSize) {
            long transferSize = fileChannel.transferTo(readTotal, remainSize, socketChannel);
            readTotal += transferSize;
            remainSize -= transferSize;
        }

        System.out.println("New ---> Read Total: " + readTotal + "; Coast Time: " + (System.currentTimeMillis() - startTime));
        fileChannel.close();
    }
}
