package org.pismery.demo.netty.proto;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.pismery.demo.netty.proto.generate.Info;

public class ProtoClientHandler extends SimpleChannelInboundHandler<Info.Message> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Info.Message msg) throws Exception {
        System.out.println(msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Info.Message.Builder builder = Info.Message.newBuilder();
        Info.Message message = builder.setMessageType(Info.Message.MessageType.REQUEST)
                .setRequest(Info.Request.newBuilder()
                        .setCode(Info.Request.RequestType.GET)
                        .setMsg("request message")
                        .build())
                .build();
        ctx.channel().writeAndFlush(message);
    }
}
