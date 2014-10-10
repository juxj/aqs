package com.lh.util;

import java.io.Serializable;
import java.security.MessageDigest;

public class MD5Util implements Serializable {
	private static final long serialVersionUID = 2046569272788545499L;

	/**
	 * 将一个字符串通过MD5转换成加密串
	 * 
	 * @param sign
	 * @return
	 */
	public final static String MD5(String sign) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = sign.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * 将一个字符串通过MD5转换成加密串
	 * 
	 * @param sign
	 * @return
	 */
	public final static String MD5toUpperCase(String sign) {
		String resultStr = "";
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] temp = sign.getBytes();
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(temp);
			// resultStr = new String(md5.digest());
			byte[] b = md5.digest();
			for (int i = 0; i < b.length; i++) {
				char[] ob = new char[2];
				ob[0] = hexDigits[(b[i] >>> 4) & 0X0F];
				ob[1] = hexDigits[b[i] & 0X0F];
				resultStr += new String(ob);
			}
			return resultStr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

}
