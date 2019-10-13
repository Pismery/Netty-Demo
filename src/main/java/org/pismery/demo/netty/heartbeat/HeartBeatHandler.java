package org.pismery.demo.netty.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

public class HeartBeatHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;

            String idleState = "";
            switch (idleStateEvent.state()) {
                case READER_IDLE:
                    idleState = "read idle";
                    break;
                case WRITER_IDLE:
                    idleState = "write idle";
                    break;
                case ALL_IDLE:
                    idleState = "read write idle";
                    break;
                default:
                    throw new Exception("Illegal idle state...");
            }
            System.out.println(ctx.channel().remoteAddress() + ": " + idleState);

            if ("read write idle".equals(idleState)) {
                ctx.channel().close();
            }
        }
    }
}
