package ca.wlu.hztw.myschedule.data;
import ca.wlu.hztw.myschedule.grpc.CalenderGrpc;
import ca.wlu.hztw.myschedule.grpc.LoginGrpc;
import ca.wlu.hztw.myschedule.grpc.CalenderServices;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class EventDataSource {
    private final ManagedChannel channel;
    private final CalenderGrpc.CalenderBlockingStub calenderBlockingStub;
    private final CalenderGrpc.CalenderStub calenderAsyncStub;
    private final LoginGrpc.LoginBlockingStub loginBlockingStub;
    private final LoginGrpc.LoginStub loginAsyncStub;

    public EventDataSource(String host, int port){
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext(true)
                .build();
        calenderBlockingStub = CalenderGrpc.newBlockingStub(channel);
        calenderAsyncStub = CalenderGrpc.newStub(channel);
        loginBlockingStub = LoginGrpc.newBlockingStub(channel);
        loginAsyncStub = LoginGrpc.newStub(channel);
    }

    public CalenderServices.LoginResult login(final String id,final String hashedPassword){
        CalenderServices.LoginRequest request = CalenderServices.LoginRequest.newBuilder().setId(id).setHashedPW(hashedPassword).build();
        CalenderServices.LoginResult result = loginBlockingStub.login(request);
        result.getAuthResult();
        result.getAdminpermission();
        result.getResultMessage();
        return result;

    }
}
