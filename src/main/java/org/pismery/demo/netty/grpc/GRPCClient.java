package org.pismery.demo.netty.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.pismery.demo.netty.grpc.generate.GreeterServiceGrpc;
import org.pismery.demo.netty.grpc.generate.GrpcDemo;

import java.util.concurrent.CountDownLatch;


public class GRPCClient {
    public static void main(String[] args) throws InterruptedException {

        final CountDownLatch finishLatch = new CountDownLatch(1);

        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress("localhost", 8087)
                .usePlaintext()
                .build();
        GreeterServiceGrpc.GreeterServiceBlockingStub blockingStub = GreeterServiceGrpc.newBlockingStub(managedChannel);
        GreeterServiceGrpc.GreeterServiceStub asynStub = GreeterServiceGrpc.newStub(managedChannel);

        GrpcDemo.HelloRequest helloRequest = GrpcDemo.HelloRequest.newBuilder()
                .setName("pismery")
                .build();


        callSayHello(blockingStub, helloRequest);
        callLotsOfReplies(blockingStub, helloRequest);
        callLotsOfGreetings(asynStub, helloRequest);

        finishLatch.await();
    }

    private static void callLotsOfGreetings(GreeterServiceGrpc.GreeterServiceStub stub, GrpcDemo.HelloRequest helloRequest) {
        System.out.println("lotsOfGreetings");
        StreamObserver<GrpcDemo.HelloRequest> observer = stub.lotsOfGreetings(new StreamObserver<GrpcDemo.HelloReply>() {
            @Override
            public void onNext(GrpcDemo.HelloReply reply) {
                System.out.println(reply.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println();
            }
        });
        observer.onNext(helloRequest);
        observer.onCompleted();
    }

    private static void callLotsOfReplies(GreeterServiceGrpc.GreeterServiceBlockingStub blockingStub, GrpcDemo.HelloRequest helloRequest) {
        System.out.println("lotsOfReplies");
        blockingStub.lotsOfReplies(helloRequest).forEachRemaining(reply -> {
            System.out.println(reply.getMessage());
        });
        System.out.println();
    }

    private static void callSayHello(GreeterServiceGrpc.GreeterServiceBlockingStub blockingStub, GrpcDemo.HelloRequest helloRequest) {
        System.out.println("sayHello");
        System.out.println(blockingStub.sayHello(helloRequest).getMessage());
        System.out.println();
    }
}
