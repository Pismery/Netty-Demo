package org.pismery.demo.netty.grpc.service;

import io.grpc.stub.StreamObserver;
import org.pismery.demo.netty.grpc.generate.GreeterServiceGrpc;
import org.pismery.demo.netty.grpc.generate.GrpcDemo;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

public class GreeterServiceImpl extends GreeterServiceGrpc.GreeterServiceImplBase {
    @Override
    public void sayHello(GrpcDemo.HelloRequest request, StreamObserver<GrpcDemo.HelloReply> responseObserver) {
        System.out.println("hello from client:" + request.getName());

        GrpcDemo.HelloReply helloReply = GrpcDemo.HelloReply.newBuilder()
                .setMessage("hello world from server!...")
                .build();
        responseObserver.onNext(helloReply);
        responseObserver.onCompleted();
    }

    @Override
    public void lotsOfReplies(GrpcDemo.HelloRequest request, StreamObserver<GrpcDemo.HelloReply> responseObserver) {
        System.out.println("lostOfReplies from client:" + request.getName());

        responseObserver.onNext(GrpcDemo.HelloReply.newBuilder().setMessage("hello world").build());
        responseObserver.onNext(GrpcDemo.HelloReply.newBuilder().setMessage("from server!...").build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<GrpcDemo.HelloRequest> lotsOfGreetings(StreamObserver<GrpcDemo.HelloReply> responseObserver) {
        System.out.println("lostOfGreetings from client: ");

        return new StreamObserver<GrpcDemo.HelloRequest>() {
            long startTime = System.nanoTime();

            @Override
            public void onNext(GrpcDemo.HelloRequest value) {
                System.out.println(value.getName());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                long seconds = NANOSECONDS.toSeconds(System.nanoTime() - startTime);
                responseObserver.onNext(GrpcDemo.HelloReply.newBuilder().setMessage("hello world from server!...").build());
                responseObserver.onCompleted();
                System.out.println("coastTime:" + seconds);
            }
        };
    }
}
