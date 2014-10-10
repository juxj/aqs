package com.lh.util;

import java.util.UUID;

/**
 * Created by tju on 9/16/14.
 */
public class StringUtils {

    public static String getUUID()
    {
        return UUID.randomUUID().toString();
    }
    
    /**
	 * 是否为null
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str){
		if(str == null){
			return true;
		}
		return false;
	}

	/**
	 * 不为null
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str){
		return !StringUtils.isNull(str);
	}
    
	/**
	 * 是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str){
		if(!StringUtils.isNull(str) && !"".equals(str.trim())){
			return false;
		}
		return true;
	}
	
	/**
	 * 不为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str){
		return !StringUtils.isBlank(str);
	}
	
}
