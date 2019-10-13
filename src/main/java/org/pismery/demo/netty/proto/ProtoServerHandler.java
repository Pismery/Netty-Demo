package org.pismery.demo.netty.proto;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.pismery.demo.netty.proto.generate.Info;

public class ProtoServerHandler extends SimpleChannelInboundHandler<Info.Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Info.Message msg) throws Exception {
        System.out.println(msg);

        Info.Message.Builder builder = Info.Message.newBuilder();
        Info.Message message = builder.setMessageType(Info.Message.MessageType.RESPONSE)
                .setResponse(Info.Response.newBuilder()
                        .setCode(Info.Response.ResponseType.SUCCESS)
                        .setMsg("success")
                        .setResult("result")
                        .build())
                .build();
        ctx.channel().writeAndFlush(message);
    }
}
