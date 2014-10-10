package com.lh.util;

/**
 * Created by tju on 2/25/14.
 */
public class Constants {

    public class ConstSysParam {
        public static final String SONG_TAG = "00-01";
    }

    public class ConstError {

        /**
         * 系统错误
         */
        public static final String ERR_ACTION_NOT_FOUND = "101,Http请求参数中未找到相关方法";
        public static final String HANDLER_NOT_FOUND = "102,在Spring容器中未找到相关处理器[%s]";
        public static final String METHOD_NOT_FOUND = "103,在类[%s]中未找到方法[%s]";
        public static final String METHOD_INVOKE_EXCEPTION = "104,调用类[%s]的[%s]方法出现异常";

        /**
         * 逻辑错误
         */
        public static final String HTTP_SERVLET_PARAMTERS_NOT_MATCH = "105,请求参数不匹配";
        public static final String HTTP_SERVLET_PARAMTERS_IS_NULL = "106,传入参数值为空[%s]";
        public static final String ENTITY_NOT_FOUND = "107,实体类[%s]未找到";
        
        public static final String FAIL = "108,[%s]";
        
        //
        public static final String MOBILE_GET_CODE_ERROR = "109,获取校验码失败";
        public static final String MOBILE_CODE_ERROR = "110,验证码错误";
        public static final String MOBILE_OVER_CODE_ERROR = "111,验证码过期";
        public static final String MOBILE_NO_NULL_ERROR = "112,请输入手机号码";
        public static final String MOBILE_NO_REGISTER_ERROR = "113,手机号码没有注册";
        public static final String MOBILE_IS_REGISTER_ERROR = "114,手机号码已注册";        
        public static final String MOBILE_NO_EXISTS_ERROR = "115,请输入正确的机号码";   
        public static final String NO_Longin_ERROR = "116,请重新登录";
        public static final String COMPOSITION_SHARE_ERROR = "39,作品在同一平台不能重复分享";
        public static final String PLAYER_PASSWORD_ERROR= "40,密码长度只能为6-18非空字符";
        public static final String PLAYER_BIRTHDAY_ERROR= "43,请选择正确出生日期";
        public static final String PLAYER_NICKNAME_ERROR= "44,请输入昵称";
        public static final String Activity_ERROR_1= "45,未找到活动";
        public static final String Activity_ERROR_2= "46,活动未开始";
        public static final String Activity_ERROR_3= "47,活动已结束";
        public static final String Activity_ERROR_4= "48,活动码不存在";
        public static final String Activity_ERROR_5= "49,玩家已激活";
        public static final String Activity_ERROR_6= "50,玩家不能使用自己动态码";
        public static final String COMMENT_ERROR_1= "51,评论内容长度不能超过100字节";
        public static final String Activity_ERROR_7= "52,活动口令不正确";
        
        // 活动赠送金币
        public static final String ACTIVITY_SENDBALANCE_SUCCESS = "120,成功";
        public static final String ACTIVITY_SENDBALANCE_ERROR_1 = "121,赠送金币不为0";
        public static final String ACTIVITY_SENDBALANCE_ERROR_2 = "122,活动赠送金币余额不足";

    }

    public class ConstRedis{
        public static final String R_LOGIN_TOKEN_PREFIX = "PST_";
        public static final String R_LOGIN_Message_PREFIX = "PPD_";
        public static final int expired_time=60*60*12;//过期时间
        public static final int exp_expired_time=60*60*24;//经验获取过期时间
        public static final int uploadMD5_expired_time=60*60*1;//上传作品MD5过期时间
        
        /**
         * 免费礼物
         */
        public static final String R_USERGOOD_KEY="PST_USERGOOD_NUM";//免费礼物key
        public static final String R_USERGOOD_EXPIRED_TIME="R_USERGOOD_EXPIRED_TIME";//免费礼物key
        /**
         * 玩家key
         */
        public static final String R_LOGIN_PLAYER_Message_PREFIX = "PPD_PLAYER_";//玩家基本信息前缀
        public static final String R_LOGIN_COMPOSITIONS_Message_PREFIX = "PPD_COMPOSITIONS_";//玩家作品信息前缀
        public static final String R_SHARE_COMPOSITIONS_Message_PREFIX = "PPD_COMPOSITIONS_SHARE_";//玩家分享作品信息前缀
        public static final String R_PLAYER_PHOTO_Message_PREFIX = "PPD_PLAYER_PHOTO_";//玩家轮播相片
        public static final String R_PLAYER_GIFT_Message_PREFIX = "PPD_PLAYER_GIFT_";//玩家礼物列表
        public static final String R_PLAYER_Message_PREFIX = "PPD_PLAYER_MESSAGE_";//玩家基本信息前缀
        
        /**
         * 作品key
         */
        public static final String R_COMPOSITIONS_COMMENT_PREFIX = "PPD_COMPOSITIONS_COMMENT_";//作品评论列表
        public static final String R_COMPOSITIONS_GIFT_PREFIX = "PPD_COMPOSITIONS_GIFT_";//作品礼物列表
        public static final String R_COMPOSITIONS_MESSAGE_PREFIX = "PPD_COMPOSITIONS_MESSAGE_";//作品信息列表
        
        /**
         * 玩家获取经验条件前缀
         */
        public static final String R_PLAYER_EXP_ = "PLAYER_EXP_";//作品
    }

}
