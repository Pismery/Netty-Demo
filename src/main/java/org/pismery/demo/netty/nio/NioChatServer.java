package org.pismery.demo.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class NioChatServer {

    private static Map<String, SocketChannel> channelMap = new HashMap<>();
    private static Selector selector;


    /**
     * @startuml
     * Server -> Server: startup
     *
     * Server -> Server: doServer
     * activate Server
     *      Server -> Server: handle select key events
     *      activate Server
     *          Server -> Server: handle acceptable event
     *          activate Server
     *              Server -> Server: add in channelMap
     *              activate Server
     *              deactivate Server
     *          deactivate Server
     *
     *          Server -> Server: handle readable event
     *          activate Server
     *              Server -> Server: read Msg from channel
     *              Server -> Channel: send Msg to channels
     *              alt client closed channel
     *                  Server -> Server: closeChannel
     *                  Server -> Server: remove channel from channelMap
     *              end
     *          deactivate Server
     *      deactivate Server
     * deactivate Server
     * @enduml
     */
    public static void main(String[] args) throws Exception {
        startUp();
        while (true) {
            doServer();
        }
    }

    public static void startUp() throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 8989));

        selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public static void doServer() throws IOException {
        selector.select();

        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        selectionKeys.forEach(NioChatServer::handleSelectKey);

        selectionKeys.clear();
    }

    private static void handleSelectKey(SelectionKey key) {
        try {
            if (key.isAcceptable()) {
                handleAcceptable(key);
            } else if (key.isReadable() && key.isValid()) {
                handleReadable(key);
            }
        } catch (IOException e) {

        }
    }

    private static void handleAcceptable(SelectionKey key) throws IOException {
        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        SocketChannel clientChannel = serverChannel.accept();
        clientChannel.configureBlocking(false);
        clientChannel.register(selector, SelectionKey.OP_READ);

        String keyStr = UUID.randomUUID().toString();
        System.out.println(clientChannel + ": " + keyStr);
        channelMap.put(keyStr, clientChannel);
    }

    private static void handleReadable(SelectionKey key) {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        String keyStr = getChannelKey(clientChannel);
        try {
            clientChannel.configureBlocking(false);

            String msg = readMsg(clientChannel);
            System.out.println(keyStr + ": " + msg);

            sendMsg(keyStr + ": " + msg);
        } catch (IOException e) {
            try {
                clientChannel.close();
                clientChannel.socket().close();
                key.cancel();
                channelMap.remove(keyStr);
                System.out.println(keyStr + ": 断开连接");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    private static String readMsg(SocketChannel clientChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = clientChannel.read(buffer);
        if (read <= 0) {
            return null;
        }
        buffer.flip();

        Charset charset = Charset.forName("utf-8");
        return String.valueOf(charset.decode(buffer).array());
    }

    private static void sendMsg(String msg) throws IOException {
        for (Map.Entry<String, SocketChannel> m : channelMap.entrySet()) {
            SocketChannel client = m.getValue();

            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
            writeBuffer.put((msg).getBytes());
            writeBuffer.flip();

            client.write(writeBuffer);
        }
    }

    private static String getChannelKey(SocketChannel clientChannel) {
        String keyStr = "";
        for (Map.Entry<String, SocketChannel> m : channelMap.entrySet()) {
            if (m.getValue().equals(clientChannel)) {
                keyStr = m.getKey();
            }
        }
        return keyStr;
    }

}
