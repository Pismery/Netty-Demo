package org.pismery.demo.netty.bean;

import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Test;
import org.pismery.demo.netty.proto.generate.Info;

import static org.junit.Assert.assertEquals;

public class ResponseTest {

    @Test
    public void test1() throws InvalidProtocolBufferException {
        //Given

        Info.Message message = Info.Message.newBuilder()
                .setMessageType(Info.Message.MessageType.REQUEST)
                .setRequest( Info.Request.newBuilder()
                        .setMsg("msg")
                        .setCode(Info.Request.RequestType.GET)
                        .build())
                .build();
        byte[] bytes = message.toByteArray();
        //When
        Info.Message result = Info.Message.parseFrom(bytes);
        //Then
        System.out.println(result);
        assertEquals(message,result);
    }

}