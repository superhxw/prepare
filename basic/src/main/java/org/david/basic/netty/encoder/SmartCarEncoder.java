package org.david.basic.netty.encoder;

import org.david.basic.netty.protocol.SmartCarProtocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 协议的编码器
 * @author hanxiaowei
 *
 */
public class SmartCarEncoder extends MessageToByteEncoder<SmartCarProtocol> {

	// 写入消息体的具体内容
	@Override
	protected void encode(ChannelHandlerContext tcx, SmartCarProtocol msg, ByteBuf out) throws Exception {
		// 1.写入消息的开头的信息标志(int类型)
		out.writeInt(msg.getHead_data());
		// 2.写入消息的长度(int 类型)
		out.writeInt(msg.getContentLength());
		// 3.写入消息的内容(byte[]类型)
		out.writeBytes(msg.getContent());
	}

}
