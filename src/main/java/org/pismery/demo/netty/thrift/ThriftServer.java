package org.pismery.demo.netty.thrift;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.pismery.demo.netty.thrift.generate.ThriftService;
import org.pismery.demo.netty.thrift.service.ThriftServiceImpl;

/**
 * @startuml
 * (*) --> "create server socket"
 * "create server socket" --> "create server args"
 * "create server args" --> "set up protocol"
 * "create server args" --> "set up transport"
 * "create server args" --> "set up processor"
 * "set up protocol" --> "create server"
 * "set up transport" --> "create server"
 * "set up processor" --> "create server"
 * "create server" --> "start up server"
 * @enduml
 */
public class ThriftServer {
    public static void main(String[] args) throws TTransportException {
        TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(8989);
        THsHaServer.Args arg = new THsHaServer.Args(serverSocket).minWorkerThreads(2).maxWorkerThreads(4);
        ThriftService.Processor<ThriftServiceImpl> processor = new ThriftService.Processor<>(
                new ThriftServiceImpl()
        );

        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(processor));


        TServer server = new THsHaServer(arg);
        System.out.println("Server start up !...");

        server.serve();
    }
}
