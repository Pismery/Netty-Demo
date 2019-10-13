package org.pismery.demo.netty.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.pismery.demo.netty.thrift.generate.Request;
import org.pismery.demo.netty.thrift.generate.RequestType;
import org.pismery.demo.netty.thrift.generate.Response;
import org.pismery.demo.netty.thrift.generate.ThriftService;

/**
 * @startuml
 * (*) --> "create socket"
 * "create socket" --> "create transport"
 * "create transport" --> "create protocol"
 * "create protocol" --> "open transport"
 * "open transport" --> (*)
 * @enduml
 */
public class ThriftClient {
    public static void main(String[] args) throws TException {
        TSocket socket = new TSocket("127.0.0.1", 8989);
        TTransport transport = new TFramedTransport(socket, 600);
        TProtocol protocol = new TCompactProtocol(transport);

        try {
            transport.open();

            ThriftService.Client client = new ThriftService.Client(protocol);
            Request request = new Request();
            request.setMsg("hello service");
            request.setRequestType(RequestType.GET);
            Response ping = client.ping(request);

            System.out.println(ping.toString());
        } finally {
            transport.close();
        }
    }
}
