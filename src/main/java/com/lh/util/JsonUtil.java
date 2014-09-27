package com.lh.util;

import java.lang.reflect.Type;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;


public class JsonUtil{
	private static final long	serialVersionUID	= 2221956648539334217L;

	public static String objToJsonString(Object obj){
		try{
			if(obj instanceof JSONObject){
				return obj.toString();
			}
			return JSON.toJSONString(obj);
		}catch(Exception e){
			return null;
		}
	}

	public static <T> T stringToTObj(String objectStr,Class<T> t){
		try{
			if(StringUtils.isBlank(objectStr) || t == null){
				return null;
			}
			return JSON.parseObject(objectStr,t);
		}catch(Exception e){
			return null;
		}
	}

	public static Object[] stringToObject(String objectStr){
		try{
			if(StringUtils.isBlank(objectStr)){
				return null;
			}
			return JSONObject.parseArray(objectStr,Object.class).toArray();
		}catch(Exception e){
			return null;
		}
	}

	public static JSONObject stringToJSONObject(String objectStr){
		try{
			if(StringUtils.isBlank(objectStr)){
				return null;
			}
			return JSONObject.parseObject(objectStr);
		}catch(Exception e){
			return null;
		}
	}

	private JsonUtil(){}

	private static Gson gson=null;
	static{
		if(gson==null){
			gson=new Gson();
		}
	}
	/**
	 * 将对象转换成json格式
	 * @param ts
	 * @return
	 */
	public static String objectToJson(Object ts){
		String jsonStr=null;
		if(gson!=null){
			jsonStr=gson.toJson(ts);
		}
		return jsonStr;
	}
	
	public static List fromJson(String str,Type type){
		if(gson!=null){
			return gson.fromJson(str, type);
		}
		return null;
	}
	
//	/**
//	 * 将对象转换成json格式(并自定义日期格式)
//	 * @param ts
//	 * @return
//	 */
//	public static String objectToJsonDateSerializer(Object ts,final String dateformat){
//		String jsonStr=null;
//		gson=new GsonBuilder().registerTypeHierarchyAdapter(Date.class, new JsonSerializer<Date>() {
//			public JsonElement serialize(Date src, Type typeOfSrc,
//					JsonSerializationContext context) {
//				SimpleDateFormat format = new SimpleDateFormat(dateformat);
//				return new JsonPrimitive(format.format(src));
//			}
//		}).setDateFormat(dateformat).create();
//		if(gson!=null){
//			jsonStr=gson.toJson(ts);
//		}
//		return jsonStr;
//	}
//	
//	/**
//	 * 将对象转换成json格式(时间转成毫秒数)
//	 * @param ts
//	 * @return
//	 */
//	public static String objectToJsonDateSerializer(Object ts){
//		String jsonStr=null;
//		gson=new GsonBuilder().registerTypeHierarchyAdapter(Date.class, new JsonSerializer<Date>() {
//			public JsonElement serialize(Date src, Type typeOfSrc,
//					JsonSerializationContext context) {
//				String s=src.getTime()+"";
//				return new JsonPrimitive(s);
//			}
//		}).create();
//		if(gson!=null){
//			jsonStr=gson.toJson(ts);
//		}
//		return jsonStr;
//	}
	
	public static Object formJsonToObject(String str,Type type){
		if(gson!=null){
			return gson.fromJson(str, type);
		}
		return null;
	}
}
