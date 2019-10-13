package org.pismery.demo.netty.grpc.generate;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.0)",
    comments = "Source: GrpcDemo.proto")
public final class GreeterServiceGrpc {

  private GreeterServiceGrpc() {}

  public static final String SERVICE_NAME = "org.pismery.demo.netty.grpc.generate.GreeterService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest,
      org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello",
      requestType = org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest.class,
      responseType = org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest,
      org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply> getSayHelloMethod() {
    io.grpc.MethodDescriptor<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest, org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply> getSayHelloMethod;
    if ((getSayHelloMethod = GreeterServiceGrpc.getSayHelloMethod) == null) {
      synchronized (GreeterServiceGrpc.class) {
        if ((getSayHelloMethod = GreeterServiceGrpc.getSayHelloMethod) == null) {
          GreeterServiceGrpc.getSayHelloMethod = getSayHelloMethod =
              io.grpc.MethodDescriptor.<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest, org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterServiceMethodDescriptorSupplier("SayHello"))
              .build();
        }
      }
    }
    return getSayHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest,
      org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply> getLotsOfRepliesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LotsOfReplies",
      requestType = org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest.class,
      responseType = org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest,
      org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply> getLotsOfRepliesMethod() {
    io.grpc.MethodDescriptor<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest, org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply> getLotsOfRepliesMethod;
    if ((getLotsOfRepliesMethod = GreeterServiceGrpc.getLotsOfRepliesMethod) == null) {
      synchronized (GreeterServiceGrpc.class) {
        if ((getLotsOfRepliesMethod = GreeterServiceGrpc.getLotsOfRepliesMethod) == null) {
          GreeterServiceGrpc.getLotsOfRepliesMethod = getLotsOfRepliesMethod =
              io.grpc.MethodDescriptor.<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest, org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LotsOfReplies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterServiceMethodDescriptorSupplier("LotsOfReplies"))
              .build();
        }
      }
    }
    return getLotsOfRepliesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest,
      org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply> getLotsOfGreetingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LotsOfGreetings",
      requestType = org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest.class,
      responseType = org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest,
      org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply> getLotsOfGreetingsMethod() {
    io.grpc.MethodDescriptor<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest, org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply> getLotsOfGreetingsMethod;
    if ((getLotsOfGreetingsMethod = GreeterServiceGrpc.getLotsOfGreetingsMethod) == null) {
      synchronized (GreeterServiceGrpc.class) {
        if ((getLotsOfGreetingsMethod = GreeterServiceGrpc.getLotsOfGreetingsMethod) == null) {
          GreeterServiceGrpc.getLotsOfGreetingsMethod = getLotsOfGreetingsMethod =
              io.grpc.MethodDescriptor.<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest, org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LotsOfGreetings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterServiceMethodDescriptorSupplier("LotsOfGreetings"))
              .build();
        }
      }
    }
    return getLotsOfGreetingsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GreeterServiceStub newStub(io.grpc.Channel channel) {
    return new GreeterServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GreeterServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GreeterServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GreeterServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GreeterServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class GreeterServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sayHello(org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest request,
        io.grpc.stub.StreamObserver<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    /**
     */
    public void lotsOfReplies(org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest request,
        io.grpc.stub.StreamObserver<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply> responseObserver) {
      asyncUnimplementedUnaryCall(getLotsOfRepliesMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest> lotsOfGreetings(
        io.grpc.stub.StreamObserver<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply> responseObserver) {
      return asyncUnimplementedStreamingCall(getLotsOfGreetingsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest,
                org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply>(
                  this, METHODID_SAY_HELLO)))
          .addMethod(
            getLotsOfRepliesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest,
                org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply>(
                  this, METHODID_LOTS_OF_REPLIES)))
          .addMethod(
            getLotsOfGreetingsMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest,
                org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply>(
                  this, METHODID_LOTS_OF_GREETINGS)))
          .build();
    }
  }

  /**
   */
  public static final class GreeterServiceStub extends io.grpc.stub.AbstractStub<GreeterServiceStub> {
    private GreeterServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreeterServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreeterServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sayHello(org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest request,
        io.grpc.stub.StreamObserver<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void lotsOfReplies(org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest request,
        io.grpc.stub.StreamObserver<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getLotsOfRepliesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest> lotsOfGreetings(
        io.grpc.stub.StreamObserver<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getLotsOfGreetingsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class GreeterServiceBlockingStub extends io.grpc.stub.AbstractStub<GreeterServiceBlockingStub> {
    private GreeterServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreeterServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreeterServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply sayHello(org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply> lotsOfReplies(
        org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getLotsOfRepliesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GreeterServiceFutureStub extends io.grpc.stub.AbstractStub<GreeterServiceFutureStub> {
    private GreeterServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreeterServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreeterServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply> sayHello(
        org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;
  private static final int METHODID_LOTS_OF_REPLIES = 1;
  private static final int METHODID_LOTS_OF_GREETINGS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GreeterServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GreeterServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest) request,
              (io.grpc.stub.StreamObserver<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply>) responseObserver);
          break;
        case METHODID_LOTS_OF_REPLIES:
          serviceImpl.lotsOfReplies((org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloRequest) request,
              (io.grpc.stub.StreamObserver<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOTS_OF_GREETINGS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.lotsOfGreetings(
              (io.grpc.stub.StreamObserver<org.pismery.demo.netty.grpc.generate.GrpcDemo.HelloReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GreeterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GreeterServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.pismery.demo.netty.grpc.generate.GrpcDemo.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GreeterService");
    }
  }

  private static final class GreeterServiceFileDescriptorSupplier
      extends GreeterServiceBaseDescriptorSupplier {
    GreeterServiceFileDescriptorSupplier() {}
  }

  private static final class GreeterServiceMethodDescriptorSupplier
      extends GreeterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GreeterServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GreeterServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GreeterServiceFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .addMethod(getLotsOfRepliesMethod())
              .addMethod(getLotsOfGreetingsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
