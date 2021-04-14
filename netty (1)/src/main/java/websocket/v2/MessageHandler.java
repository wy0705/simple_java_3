package websocket.v2;

import com.google.gson.Gson;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MessageHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    public static ConcurrentHashMap<String, ChannelId> channelIdMap = new ConcurrentHashMap<>();
    public static AtomicInteger online;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame webSocketFrame) throws Exception {
        Message message = new Gson().fromJson(webSocketFrame.text(), Message.class);
        if (message == null) {
            sendMessageByChannel(channelHandlerContext.channel(), new Message(channelHandlerContext.channel().id().asShortText(), "消息错误", System.currentTimeMillis()));
        } else {
            ChannelId channelId = channelIdMap.get(message.getId());
            if (channelId == null) {
                sendMessageByChannel(channelHandlerContext.channel(), new Message(channelHandlerContext.channel().id().asShortText(), "对方已下线", System.currentTimeMillis()));
            } else {
                sendMessageByChannel(channelGroup.find(channelId), message);
            }
        }
        System.out.println(channelHandlerContext.channel().remoteAddress() + "--->" + message.getContent() + "--->" + message.getTimestamp());
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        channelGroup.add(ctx.channel());
        channelIdMap.put(ctx.channel().id().asShortText(), ctx.channel().id());
        online.set(channelGroup.size());
        System.out.println(ctx.channel().remoteAddress() + "上线！");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        channelGroup.remove(ctx.channel());
        channelIdMap.remove(ctx.channel().id().asShortText());
        online.set(channelGroup.size());
        System.out.println(ctx.channel().remoteAddress() + "下线！");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }


    private void sendMessageByChannel(Channel channel, Message message) {
        channel.writeAndFlush(new TextWebSocketFrame(new Gson().toJson(message)));
    }
}
