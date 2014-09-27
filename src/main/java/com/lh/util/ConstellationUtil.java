package com.lh.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ConstellationUtil {

	public ConstellationUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static int BirthToProport(Date time) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(time);
			int year = cal.get(Calendar.YEAR);//获取年份
			return (year) % 12 + 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("生肖年份输入不合理！");
		}
		return 0;
	}
	private static String[] constellation={"白羊座","金牛座","双子座","巨蟹座","狮子座","处女座","天秤座","天蝎座","射手座","摩羯座","水瓶座","双鱼座"};
	
	public static int BirthToContell(Date time) {
		if(null==time){
			return 0;
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dddd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(time);
			int year = cal.get(Calendar.YEAR);//获取年份
			if (between(sdf.parse(year + "-03" + "-21"), time,
					sdf.parse(year + "-04" + "-20")))
				return 1;
			else if (between(sdf.parse(year + "-04" + "-21"), time,
					sdf.parse(year + "-05" + "-20")))
				return 2;
			else if (between(sdf.parse(year + "-05" + "-21"), time,
					sdf.parse(year + "-06" + "-21")))
				return 3;
			else if (between(sdf.parse(year + "-06" + "-22"), time,
					sdf.parse(year + "-07" + "-22")))
				return 4;
			else if (between(sdf.parse(year + "-07" + "-23"), time,
					sdf.parse(year + "-08" + "-22")))
				return 5;
			else if (between(sdf.parse(year + "-08" + "-23"), time,
					sdf.parse(year + "-09" + "-22")))
				return 6;
			else if (between(sdf.parse(year + "-09" + "-23"), time,
					sdf.parse(year + "-10" + "-22")))
				return 7;
			else if (between(sdf.parse(year + "-10" + "-23"), time,
					sdf.parse(year + "-11" + "-21")))
				return 8;
			else if (between(sdf.parse(year + "-11" + "-22"), time,
					sdf.parse(year + "-12" + "-21")))
				return 9;
			else if (between(sdf.parse(year + "-01" + "-20"), time,
					sdf.parse(year + "-02" + "-18")))
				return 11;
			else if (between(sdf.parse(year + "-02" + "-19"), time,
					sdf.parse(year + "-03" + "-20")))
				return 12;
			else if (between(sdf.parse(year + "-12" + "-22"), time,
					sdf.parse(year + "-12" + "-31"))
					|| between(sdf.parse(year + "-01" + "-01"), time,
							sdf.parse(year + "-01" + "-19")))
				return 10;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static boolean between(Date beforeTime, Date time, Date afterTime) {
		return time.getTime() >= beforeTime.getTime()
				&& time.getTime() <= afterTime.getTime();
	}

	public static String getConstellation(Date d) {
		if(null==d){
			return "";
		}
		try {
			int i= ConstellationUtil.BirthToContell(d);
			if(i>0){
				return constellation[i-1];
			}else{
				return"";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	 public static void main(String[] args) {
		 String s= ConstellationUtil.getConstellation(new Date());
		 System.out.println(s);
	 }
}