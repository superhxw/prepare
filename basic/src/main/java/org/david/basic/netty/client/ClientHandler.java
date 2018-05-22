package org.david.basic.netty.client;

import org.david.basic.netty.protocol.SmartCarProtocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;

/**
 * 
 * @author hanxiaowei
 *
 */
public class ClientHandler extends SimpleChannelInboundHandler {
	
	// 客户端与服务端，连接成功的售后
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// 发送SmartCar协议的消息
		// 要发送的信息
		String data = "I am client ...";
		// 获得要发送信息的字节数组
		byte[] content = data.getBytes();
		// 要发送信息的长度
		int contentLength = content.length;
		SmartCarProtocol protocol = new SmartCarProtocol(contentLength, content);
		ctx.writeAndFlush(protocol);
	}

	// 只是读数据，没有写数据的话
	// 需要自己手动的释放的消息
	@Override
	protected void channelRead0(ChannelHandlerContext ctx,  Object msg) throws Exception {
		try {
	        //System.out.println("Client received: " + ByteBufUtil.hexDump(in.readBytes(in.readableBytes())));  
			// 用于获取客户端发来的数据信息
			SmartCarProtocol body = (SmartCarProtocol) msg;
			System.out.println("Client接受的客户端的信息 :" +new String(body.getContent(),"UTF-8")+"   >>>>>>> contentLength:"+body.getContentLength());
		} finally {
			ReferenceCountUtil.release(msg);
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}

}
