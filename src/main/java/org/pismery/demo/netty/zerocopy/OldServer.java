package org.pismery.demo.netty.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * zero copy sequence
 * @startuml
 * participant UserSpace order 10
 * participant KernelSpace order 20
 * participant Hardware order 30
 *
 * UserSpace -> KernelSpace: sendfile()「system call」
 * KernelSpace -> Hardware: ask data
 * Hardware --> KernelSpace: sendData through DMA「Direct Memory Access」
 *
 * KernelSpace -> KernelSpace: copy date from kernel buffer to socket buffer
 *
 * KernelSpace -> Hardware: write data
 * Hardware --> KernelSpace: done
 * KernelSpace --> UserSpace: sendfile() return
 * @enduml
 *
 * 
 * normal copy sequence
 * @startuml
 * participant UserSpace order 10
 * participant KernelSpace order 20
 * participant Hardware order 30
 *
 * UserSpace -> KernelSpace: read()「system call」
 * KernelSpace -> Hardware: ask data
 * Hardware --> KernelSpace: sendData through DMA「Direct Memory Access」
 * KernelSpace --> UserSpace: copy data to user space
 *
 * UserSpace -> UserSpace: code logic continue
 *
 * UserSpace -> KernelSpace: write()「system call」copy data to kernel space.
 * KernelSpace -> Hardware: write data
 * Hardware --> KernelSpace: done
 * KernelSpace --> UserSpace: write() return.
 * @enduml
 */
public class OldServer {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server startup...");
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            byte[] bytes = new byte[4096];
            try {
                while (true) {
                    int readCount = dataInputStream.read(bytes, 0, bytes.length);
                    if (readCount == -1) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
