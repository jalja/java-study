package com.jalja.org.bytes;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.apache.commons.codec.binary.Hex;
public class ByteSizePattern {
	public static void main(String[] args) {
		//00000000 00000000 00000000 00000011
		int by=3;

		byteBig(by);
		System.out.println();
		byteLe(by);
	}
	public static void byteBig(int by) {
		System.out.println("======大端模式=====");
		// byte=8bit   00000000 00000000 00000000 00000000  00000000 00000000 00000000 00000000
		ByteBuffer buffer=ByteBuffer.allocate(8);
		// int =4byte=32bit
		buffer.order(ByteOrder.BIG_ENDIAN).putInt(by);
		buffer.flip();
		byte [] bytes =new byte[4];
		buffer.order(ByteOrder.BIG_ENDIAN).get(bytes);
		System.out.println("0x"+Hex.encodeHexString(bytes));
		for(byte b:bytes){
			System.out.print(getTByte(b) +" ");
		}
	}
	public static void byteLe(int by) {
		System.out.println("======小端模式=====");
		ByteBuffer buffer=ByteBuffer.allocate(8);
		buffer.order(ByteOrder.LITTLE_ENDIAN).putInt(by);
		buffer.flip();
		byte [] bytes =new byte[4];
		buffer.order(ByteOrder.LITTLE_ENDIAN).get(bytes);
		System.out.println("0x"+Hex.encodeHexString(bytes));
		for(byte b:bytes){
			System.out.print(getTByte(b) +" ");
		}
	}
	public static String getTByte(Byte tByte){
		String tString = Integer.toBinaryString((tByte & 0xFF) + 0x100).substring(1);
		return tString;
	}
}
