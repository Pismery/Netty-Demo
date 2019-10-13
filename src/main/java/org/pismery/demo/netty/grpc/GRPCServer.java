package org.pismery.demo.netty.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.pismery.demo.netty.grpc.service.GreeterServiceImpl;

import java.io.IOException;

public class GRPCServer {

    private Server server;

    private void start() throws IOException {
        server = ServerBuilder.forPort(8087).
                addService(new GreeterServiceImpl())
                .build();

        server.start();
        System.out.println("Server started on port:" + 8087);
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void awaitTermination() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        GRPCServer server = new GRPCServer();
        server.start();
        server.awaitTermination();
    }
}
