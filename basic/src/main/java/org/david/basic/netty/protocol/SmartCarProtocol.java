package org.david.basic.netty.protocol;

import org.david.basic.netty.support.ConstantValue;

/**
 * 自定义报文协议
 * +——----——+——-----——+——----——+
 * |协议开始标志|  长度  | 数据       |
 * +——----——+——-----——+——----——+
 * 1.协议开始标志head_data，为int类型的数据，16进制表示为0X7(118)
 * 2.传输数据的长度contentLength，int类型
 * 3.要传输的数据
 * @author hanxiaowei
 *
 */
public class SmartCarProtocol {
	/**
	 * 消息的开头的信息标志
	 */
	private int head_data = ConstantValue.HEAD_DATA;
	/**
	 * 消息的长度
	 */
	private int contentLength;
	/**
	 * 消息的内容
	 */
	private byte[] content;
	
	/**
	 * 用于初始化，SmartCarProtocol
	 * 
	 * @param contentLength
	 *            协议里面，消息数据的长度
	 * @param content
	 *            协议里面，消息的数据
	 */
	public SmartCarProtocol(int contentLength, byte[] content) {
		this.contentLength = contentLength;
		this.content = content;
	}

	public int getHead_data() {
		return head_data;
	}

	public void setHead_data(int head_data) {
		this.head_data = head_data;
	}

	public int getContentLength() {
		return contentLength;
	}

	public void setContentLength(int contentLength) {
		this.contentLength = contentLength;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}
	
}
