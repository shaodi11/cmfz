package com.baizhi.cmfz.util;

import java.util.Random;

public class Salt {
	public static String getSalt(){
		Random random = new Random();
		String str = "123456789ABCDEFGHabcdefgh";
		char[] c = new char[4];
		for (int i = 0; i < c.length; i++) {
			c[i] = str.charAt( random.nextInt(20));
		}
		return new String(c);
		
	}
}
