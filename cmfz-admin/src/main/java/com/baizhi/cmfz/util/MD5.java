package com.baizhi.cmfz.util;

import org.apache.commons.codec.digest.DigestUtils;


public class MD5 {

	public static String getMD5String(String s){
		
		return DigestUtils.md5Hex(s);
	}
	
}
