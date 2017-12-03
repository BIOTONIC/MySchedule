package ca.wlu.hztw.myschedule.grpc;

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
    value = "by gRPC proto compiler (version 1.9.0-SNAPSHOT)",
    comments = "Source: calender_services.proto")
public final class LoginGrpc {

  private LoginGrpc() {}

  public static final String SERVICE_NAME = "ca.wlu.hztw.myschedule.grpc.Login";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @Deprecated // Use {@link #getLoginMethod()} instead.
  public static final io.grpc.MethodDescriptor<CalenderServices.LoginRequest,
      CalenderServices.LoginResult> METHOD_LOGIN = getLoginMethod();

  private static volatile io.grpc.MethodDescriptor<CalenderServices.LoginRequest,
      CalenderServices.LoginResult> getLoginMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<CalenderServices.LoginRequest,
      CalenderServices.LoginResult> getLoginMethod() {
    io.grpc.MethodDescriptor<CalenderServices.LoginRequest, CalenderServices.LoginResult> getLoginMethod;
    if ((getLoginMethod = LoginGrpc.getLoginMethod) == null) {
      synchronized (LoginGrpc.class) {
        if ((getLoginMethod = LoginGrpc.getLoginMethod) == null) {
          LoginGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<CalenderServices.LoginRequest, CalenderServices.LoginResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ca.wlu.hztw.myschedule.grpc.Login", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CalenderServices.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CalenderServices.LoginResult.getDefaultInstance()))
                  .setSchemaDescriptor(new LoginMethodDescriptorSupplier("login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LoginStub newStub(io.grpc.Channel channel) {
    return new LoginStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LoginBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LoginBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LoginFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LoginFutureStub(channel);
  }

  /**
   */
  public static abstract class LoginImplBase implements io.grpc.BindableService {

    /**
     */
    public void login(CalenderServices.LoginRequest request,
        io.grpc.stub.StreamObserver<CalenderServices.LoginResult> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                CalenderServices.LoginRequest,
                CalenderServices.LoginResult>(
                  this, METHODID_LOGIN)))
          .build();
    }
  }

  /**
   */
  public static final class LoginStub extends io.grpc.stub.AbstractStub<LoginStub> {
    private LoginStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoginStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected LoginStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoginStub(channel, callOptions);
    }

    /**
     */
    public void login(CalenderServices.LoginRequest request,
        io.grpc.stub.StreamObserver<CalenderServices.LoginResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LoginBlockingStub extends io.grpc.stub.AbstractStub<LoginBlockingStub> {
    private LoginBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoginBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected LoginBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoginBlockingStub(channel, callOptions);
    }

    /**
     */
    public CalenderServices.LoginResult login(CalenderServices.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LoginFutureStub extends io.grpc.stub.AbstractStub<LoginFutureStub> {
    private LoginFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoginFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected LoginFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoginFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CalenderServices.LoginResult> login(
        CalenderServices.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LoginImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LoginImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((CalenderServices.LoginRequest) request,
              (io.grpc.stub.StreamObserver<CalenderServices.LoginResult>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LoginBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LoginBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return CalenderServices.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Login");
    }
  }

  private static final class LoginFileDescriptorSupplier
      extends LoginBaseDescriptorSupplier {
    LoginFileDescriptorSupplier() {}
  }

  private static final class LoginMethodDescriptorSupplier
      extends LoginBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LoginMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LoginGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LoginFileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .build();
        }
      }
    }
    return result;
  }
}
