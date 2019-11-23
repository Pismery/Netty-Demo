package org.pismery.demo.netty.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;

public class OldClient {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost",8081);

        String filePath = "E:\\Video\\Netty\\1111.mp4";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[4096];
        int readTotal = 0;
        int readCount = 0;

        long startTime = System.currentTimeMillis();
        while (-1 != (readCount = fileInputStream.read(buffer, 0, buffer.length))) {
            readTotal += readCount;
            dataOutputStream.write(buffer);
        }

        System.out.println("Old ----> Read Total: " + readTotal + "; Coast Time: " + (System.currentTimeMillis() - startTime));

        dataOutputStream.close();
        fileInputStream.close();
        socket.close();
    }
}
