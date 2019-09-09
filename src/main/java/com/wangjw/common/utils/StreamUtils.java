package com.wangjw.common.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/** 
* @author 作者:wangjiawen
* @version 创建时间: 2019年9月9日 下午7:48:40
* 类功能说明 
*/
public class StreamUtils {
	
	/**
	 * 关闭流
	 * @param closeables
	 * @throws IOException 
	 */
	public static void closeStream(Closeable ...closeables) throws IOException {
		for (Closeable closeable : closeables) {
			closeable.close();
		}
		
	}
	
	/**
	 * 
	 * @param is
	 * @param os
	 * @throws IOException 
	 */
	public static void copyStream(InputStream is,OutputStream os) throws IOException {
		
		byte b[] = new byte[1024];
		while(is.read(b)>0) {
			os.write(b);
		}
		//刷新
		os.flush();
		
	}
	
}
