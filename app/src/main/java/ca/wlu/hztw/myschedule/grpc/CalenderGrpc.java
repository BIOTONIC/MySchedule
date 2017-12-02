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
public final class CalenderGrpc {

  private CalenderGrpc() {}

  public static final String SERVICE_NAME = "ca.wlu.hztw.myschedule.grpc.Calender";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAddCalenderEventMethod()} instead. 
  public static final io.grpc.MethodDescriptor<ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent,
      ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult> METHOD_ADD_CALENDER_EVENT = getAddCalenderEventMethod();

  private static volatile io.grpc.MethodDescriptor<ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent,
      ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult> getAddCalenderEventMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent,
      ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult> getAddCalenderEventMethod() {
    io.grpc.MethodDescriptor<ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent, ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult> getAddCalenderEventMethod;
    if ((getAddCalenderEventMethod = CalenderGrpc.getAddCalenderEventMethod) == null) {
      synchronized (CalenderGrpc.class) {
        if ((getAddCalenderEventMethod = CalenderGrpc.getAddCalenderEventMethod) == null) {
          CalenderGrpc.getAddCalenderEventMethod = getAddCalenderEventMethod = 
              io.grpc.MethodDescriptor.<ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent, ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ca.wlu.hztw.myschedule.grpc.Calender", "addCalenderEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult.getDefaultInstance()))
                  .setSchemaDescriptor(new CalenderMethodDescriptorSupplier("addCalenderEvent"))
                  .build();
          }
        }
     }
     return getAddCalenderEventMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAddUnavailableTimeMethod()} instead. 
  public static final io.grpc.MethodDescriptor<ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent,
      ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult> METHOD_ADD_UNAVAILABLE_TIME = getAddUnavailableTimeMethod();

  private static volatile io.grpc.MethodDescriptor<ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent,
      ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult> getAddUnavailableTimeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent,
      ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult> getAddUnavailableTimeMethod() {
    io.grpc.MethodDescriptor<ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent, ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult> getAddUnavailableTimeMethod;
    if ((getAddUnavailableTimeMethod = CalenderGrpc.getAddUnavailableTimeMethod) == null) {
      synchronized (CalenderGrpc.class) {
        if ((getAddUnavailableTimeMethod = CalenderGrpc.getAddUnavailableTimeMethod) == null) {
          CalenderGrpc.getAddUnavailableTimeMethod = getAddUnavailableTimeMethod = 
              io.grpc.MethodDescriptor.<ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent, ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ca.wlu.hztw.myschedule.grpc.Calender", "addUnavailableTime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult.getDefaultInstance()))
                  .setSchemaDescriptor(new CalenderMethodDescriptorSupplier("addUnavailableTime"))
                  .build();
          }
        }
     }
     return getAddUnavailableTimeMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetCalendersEventMethod()} instead. 
  public static final io.grpc.MethodDescriptor<ca.wlu.hztw.myschedule.grpc.CalenderServices.Account,
      ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent> METHOD_GET_CALENDERS_EVENT = getGetCalendersEventMethod();

  private static volatile io.grpc.MethodDescriptor<ca.wlu.hztw.myschedule.grpc.CalenderServices.Account,
      ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent> getGetCalendersEventMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<ca.wlu.hztw.myschedule.grpc.CalenderServices.Account,
      ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent> getGetCalendersEventMethod() {
    io.grpc.MethodDescriptor<ca.wlu.hztw.myschedule.grpc.CalenderServices.Account, ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent> getGetCalendersEventMethod;
    if ((getGetCalendersEventMethod = CalenderGrpc.getGetCalendersEventMethod) == null) {
      synchronized (CalenderGrpc.class) {
        if ((getGetCalendersEventMethod = CalenderGrpc.getGetCalendersEventMethod) == null) {
          CalenderGrpc.getGetCalendersEventMethod = getGetCalendersEventMethod = 
              io.grpc.MethodDescriptor.<ca.wlu.hztw.myschedule.grpc.CalenderServices.Account, ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "ca.wlu.hztw.myschedule.grpc.Calender", "getCalendersEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ca.wlu.hztw.myschedule.grpc.CalenderServices.Account.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent.getDefaultInstance()))
                  .setSchemaDescriptor(new CalenderMethodDescriptorSupplier("getCalendersEvent"))
                  .build();
          }
        }
     }
     return getGetCalendersEventMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CalenderStub newStub(io.grpc.Channel channel) {
    return new CalenderStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CalenderBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CalenderBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CalenderFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CalenderFutureStub(channel);
  }

  /**
   */
  public static abstract class CalenderImplBase implements io.grpc.BindableService {

    /**
     */
    public void addCalenderEvent(ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent request,
        io.grpc.stub.StreamObserver<ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult> responseObserver) {
      asyncUnimplementedUnaryCall(getAddCalenderEventMethod(), responseObserver);
    }

    /**
     */
    public void addUnavailableTime(ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent request,
        io.grpc.stub.StreamObserver<ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult> responseObserver) {
      asyncUnimplementedUnaryCall(getAddUnavailableTimeMethod(), responseObserver);
    }

    /**
     */
    public void getCalendersEvent(ca.wlu.hztw.myschedule.grpc.CalenderServices.Account request,
        io.grpc.stub.StreamObserver<ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCalendersEventMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddCalenderEventMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent,
                ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult>(
                  this, METHODID_ADD_CALENDER_EVENT)))
          .addMethod(
            getAddUnavailableTimeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent,
                ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult>(
                  this, METHODID_ADD_UNAVAILABLE_TIME)))
          .addMethod(
            getGetCalendersEventMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ca.wlu.hztw.myschedule.grpc.CalenderServices.Account,
                ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent>(
                  this, METHODID_GET_CALENDERS_EVENT)))
          .build();
    }
  }

  /**
   */
  public static final class CalenderStub extends io.grpc.stub.AbstractStub<CalenderStub> {
    private CalenderStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalenderStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalenderStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalenderStub(channel, callOptions);
    }

    /**
     */
    public void addCalenderEvent(ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent request,
        io.grpc.stub.StreamObserver<ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddCalenderEventMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addUnavailableTime(ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent request,
        io.grpc.stub.StreamObserver<ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddUnavailableTimeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCalendersEvent(ca.wlu.hztw.myschedule.grpc.CalenderServices.Account request,
        io.grpc.stub.StreamObserver<ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetCalendersEventMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CalenderBlockingStub extends io.grpc.stub.AbstractStub<CalenderBlockingStub> {
    private CalenderBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalenderBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalenderBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalenderBlockingStub(channel, callOptions);
    }

    /**
     */
    public ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult addCalenderEvent(ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent request) {
      return blockingUnaryCall(
          getChannel(), getAddCalenderEventMethod(), getCallOptions(), request);
    }

    /**
     */
    public ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult addUnavailableTime(ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent request) {
      return blockingUnaryCall(
          getChannel(), getAddUnavailableTimeMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent> getCalendersEvent(
        ca.wlu.hztw.myschedule.grpc.CalenderServices.Account request) {
      return blockingServerStreamingCall(
          getChannel(), getGetCalendersEventMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CalenderFutureStub extends io.grpc.stub.AbstractStub<CalenderFutureStub> {
    private CalenderFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalenderFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalenderFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalenderFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult> addCalenderEvent(
        ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent request) {
      return futureUnaryCall(
          getChannel().newCall(getAddCalenderEventMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult> addUnavailableTime(
        ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent request) {
      return futureUnaryCall(
          getChannel().newCall(getAddUnavailableTimeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_CALENDER_EVENT = 0;
  private static final int METHODID_ADD_UNAVAILABLE_TIME = 1;
  private static final int METHODID_GET_CALENDERS_EVENT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CalenderImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CalenderImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_CALENDER_EVENT:
          serviceImpl.addCalenderEvent((ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent) request,
              (io.grpc.stub.StreamObserver<ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult>) responseObserver);
          break;
        case METHODID_ADD_UNAVAILABLE_TIME:
          serviceImpl.addUnavailableTime((ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent) request,
              (io.grpc.stub.StreamObserver<ca.wlu.hztw.myschedule.grpc.CalenderServices.EventAddResult>) responseObserver);
          break;
        case METHODID_GET_CALENDERS_EVENT:
          serviceImpl.getCalendersEvent((ca.wlu.hztw.myschedule.grpc.CalenderServices.Account) request,
              (io.grpc.stub.StreamObserver<ca.wlu.hztw.myschedule.grpc.CalenderServices.CalenderEvent>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CalenderBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CalenderBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ca.wlu.hztw.myschedule.grpc.CalenderServices.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Calender");
    }
  }

  private static final class CalenderFileDescriptorSupplier
      extends CalenderBaseDescriptorSupplier {
    CalenderFileDescriptorSupplier() {}
  }

  private static final class CalenderMethodDescriptorSupplier
      extends CalenderBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CalenderMethodDescriptorSupplier(String methodName) {
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
      synchronized (CalenderGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CalenderFileDescriptorSupplier())
              .addMethod(getAddCalenderEventMethod())
              .addMethod(getAddUnavailableTimeMethod())
              .addMethod(getGetCalendersEventMethod())
              .build();
        }
      }
    }
    return result;
  }
}
