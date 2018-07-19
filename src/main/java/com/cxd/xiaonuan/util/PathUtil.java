package com.cxd.xiaonuan.util;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

/**
 * 获取JAVAWEB下面的的WebRoot绝对路径
 * 
 */
public class PathUtil {
	private static PathUtil instance = null;

	private PathUtil() {
	}

	public static PathUtil getInstance() {
		if (instance == null) {
			instance = new PathUtil();
		}
		return instance;
	}

	public String getWebRootPath() {
		URL url = this.getClass().getProtectionDomain().getCodeSource().getLocation();
		String path = url.toString();
		int index = path.indexOf("WEB-INF");
		if (index == -1) {
			index = path.indexOf("classes");
		}

		if (index == -1) {
			index = path.indexOf("bin");
		}

		path = path.substring(0, index);

		if (path.startsWith("zip")) {// 当class文件在war中时，此时返回zip:D:/...这样的路径
			path = path.substring(4);
		} else if (path.startsWith("file")) {// 当class文件在class文件中时，此时返回file:/D:/...这样的路径
			path = path.substring(6);
		} else if (path.startsWith("jar")) {// 当class文件在jar文件里面时，此时返回jar:file:/D:/...这样的路径
			path = path.substring(10);
		}

		if(!path.substring(1,2).equalsIgnoreCase(":")){
			//判断第二个字符是不是冒号，是冒号的话就是win系统，不是的话是linux系统，需要在最前面加上斜杠
			path="/"+path;
		}
		System.out.println("获取到的webroot：" + path);
		try {
			path = URLDecoder.decode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return path;
	}



}
