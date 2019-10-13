package org.pismery.demo.netty.thrift.service;

import org.apache.thrift.TException;
import org.pismery.demo.netty.thrift.generate.*;

public class ThriftServiceImpl implements ThriftService.Iface {
    @Override
    public Response ping(Request request) throws DataException, TException {
        System.out.println(request.toString());

        Response response = new Response();
        response.setMsg("success");
        response.setResponseType(ResponseType.SUCCESS);
        response.setResult("success");
        return response;
    }
}
