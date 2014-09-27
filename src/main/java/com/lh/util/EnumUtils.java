package com.lh.util;

import java.io.Serializable;

public class EnumUtils implements Serializable {

	private static final long serialVersionUID = -1681114124138039378L;

	public static enum ReturnFlag implements Serializable {
		/**
		 * 初始状态
		 */
		INSTALL((short) 0),
		/**
		 * 成功
		 */
		SUCCESS((short) 1),
		/**
		 * 失败
		 */
		FAIL((short) 2);

		private short flag;

		private ReturnFlag(short flag) {
			this.flag = flag;
		}

		public short getFlag() {
			return this.flag;
		}
	}

	/**
	 * 手机消息类型
	 * 
	 * @author Administrator
	 */
	public enum MobileMessageType implements Serializable {
		/**
		 * 注册消息
		 */
		REGISTER((short) 1,"注册校验码:"),
		/**
		 * 重置密码
		 */
		RESETPASS((short) 2,"重置密码校验码:"),
		/**
		 * 系统发送
		 */
		SYSTEM((short) 3,"");

		private short type;

		private String desc;

		private MobileMessageType(short type, String desc) {
			this.type = type;
			this.desc = desc;
		}

		public short getType() {
			return type;
		}

		public String getDesc() {
			return desc;
		}

		public static MobileMessageType getMobileMessageType(short type) {
			switch (type) {
				case 1:
					return MobileMessageType.REGISTER;
				case 2:
					return MobileMessageType.RESETPASS;
				case 3:
					return MobileMessageType.SYSTEM;
			}
			return null;
		}
	}

	/**
	 * 动态类型
	 * 
	 * @author Administrator
	 */
	public enum TrendsType implements Serializable {
		/**
		 * 作品上传
		 */
		COMPOSITIONUPLOAD((short) 1),
		/**
		 * 作品分享
		 */
		COMPOSITIONSHARE((short) 2),
		/**
		 * 照片上传
		 */
		PHOTOUPLOAD((short) 3),
		/**
		 * 照片分享
		 */
		PHOTOSHARE((short) 4),
		/**
		 * MV作品上传
		 */
		MVCOMPOSITIONUPLOAD((short) 5),
		/**
		 * MV作品分享
		 */
		MVCOMPOSITIONSHARE((short) 6);

		private short type;

		private TrendsType(short type) {
			this.type = type;
		}

		public short getType() {
			return type;
		}

		public static TrendsType getTrendsType(short type) {
			switch (type) {
				case 1:
					return TrendsType.COMPOSITIONUPLOAD;
				case 2:
					return TrendsType.COMPOSITIONSHARE;
				case 3:
					return TrendsType.PHOTOUPLOAD;
				case 4:
					return TrendsType.PHOTOSHARE;
				case 5:
					return TrendsType.MVCOMPOSITIONUPLOAD;
				case 6:
					return TrendsType.MVCOMPOSITIONSHARE;
			}
			return null;
		}
	}

	public enum RechargeType implements Serializable {
		UNIONPAY((short) 0, "网银"), ALIPAY((short) 1, "支付宝"), IOS((short) 2, "苹果商城"), OTHER((short) 3, "其他平台");

		private short type;
		private String rechargeName;

		private RechargeType(short type, String rechargeName) {
			this.type = type;
			this.rechargeName = rechargeName;
		}

		public String getRechargeName() {
			return rechargeName;
		}

		public short getType() {
			return type;
		}

		public static RechargeType getRechargeType(short type) {
			switch (type) {
				case 0:
					return RechargeType.UNIONPAY;
				case 1:
					return RechargeType.ALIPAY;
				case 2:
					return RechargeType.IOS;
				case 3:
					return RechargeType.OTHER;
			}
			return null;
		}
	}

	public enum CommodityHistoryType implements Serializable {
		/**
		 * 玩家
		 */
		PLAYER((short) 0),
		/**
		 * 作品
		 */
		COMPOSITION((short) 1),
		/**
		 * 相片
		 */
		PHOTO((short) 2);

		private short type;

		private CommodityHistoryType(short type) {
			this.type = type;
		}

		public short getType() {
			return type;
		}

		public static CommodityHistoryType getCommodityHistoryType(short type) {
			switch (type) {
				case 0:
					return CommodityHistoryType.PLAYER;
				case 1:
					return CommodityHistoryType.COMPOSITION;
				case 2:
					return CommodityHistoryType.PHOTO;
			}
			return null;
		}
	}

	public enum GiftLuckFlg implements Serializable {
		/**
		 * 非幸运礼物
		 */
		DEFAULT((short) 0),
		/**
		 * 小幸运礼物
		 */
		SMALLLUCK((short) 1),
		/**
		 * 大幸运礼物
		 */
		BIGLUCK((short) 2);

		private short type;

		private GiftLuckFlg(short type) {
			this.type = type;
		}

		public short getType() {
			return type;
		}

		public static GiftLuckFlg getGiftLuckFlg(short type) {
			switch (type) {
				case 0:
					return GiftLuckFlg.DEFAULT;
				case 1:
					return GiftLuckFlg.SMALLLUCK;
				case 2:
					return GiftLuckFlg.BIGLUCK;
			}
			return null;
		}
	}

	public static enum VirtualFlag implements Serializable {
		/**
		 * 虚拟物品
		 */
		VIRTUAL((short) 0),
		/**
		 * 
		 */
		ENTITY((short) 1);
		private short flag;

		private VirtualFlag(short flag) {
			this.flag = flag;
		}

		public short getFlag() {
			return flag;
		}
	}

	public static enum GoodsAddType implements Serializable {

		/**
		 * 购买
		 */
		BUY((short) 0, "购买", true),
		/**
		 * 收礼
		 */
		SEND((short) 1, "收礼", false),
		/**
		 * 中奖
		 */
		PRIZE((short) 2, "中奖", false),
		/**
		 * 系统发放
		 */
		SYSTEM((short) 3, "系统发放", false);

		private short addType;
		private String addTypeName;
		private boolean subBalance;

		private GoodsAddType(short addType, String addTypeName, boolean subBalance) {
			this.addType = addType;
			this.addTypeName = addTypeName;
			this.subBalance = subBalance;
		}

		public short getAddType() {
			return addType;
		}

		public String getAddTypeName() {
			return addTypeName;
		}

		public boolean isSubBalance() {
			return subBalance;
		}

	}

	public static enum GoodsType implements Serializable {
		/**
		 * 道具
		 */
		ITEM((short) 0, "道具", true, (short) 0),
		/**
		 * 礼物
		 */
		COMMODITY((short) 1, "礼物", true, (short) 1),
		/**
		 * VIP
		 */
		VIP((short) 2, "VIP", false, (short) 1),
		/**
		 * 赞
		 */
		GOOD((short) 3, "赞", true, (short) 1);

		private short type;
		private String typeName;
		private boolean sub;
		private short isShow;

		private GoodsType(short type, String typeName, boolean sub, short isShow) {
			this.type = type;
			this.typeName = typeName;
			this.sub = sub;
			this.isShow = isShow;
		}

		public short getType() {
			return type;
		}

		public String getTypeName() {
			return typeName;
		}

		public boolean isSub() {
			return sub;
		}

		public short getIsShow() {
			return isShow;
		}
	}

	public enum BalanceType implements Serializable {
		/**
		 * 币
		 */
		BALABCE((short) 0),
		/**
		 * 返回币
		 */
		RETURNBALABCE((short) 1);

		private short type;

		private BalanceType(short type) {
			this.type = type;
		}

		public short getType() {
			return type;
		}
	}

	public static enum BalanceCostType implements Serializable {
		/**
		 * user_rechage_history
		 */
		RECHARGE((short) 1, "充值", 1),
		/**
		 * user_buy_history
		 */
		BUYCOMMODITY((short) 2, "购买物品", -1), BUYVIP((short) 2, "购买VIP", -1),
		/**
		 * commodity_history
		 */
		RETURNGOLD((short) 3, "送礼返回", 1),
		/**
		 * 
		 */
		PRIZE((short) 4, "中奖", 1),
		/**
		 * 
		 */
		SYSTEM((short) 5, "系统奖励", 1),
		/**
		 * 
		 */
		EXCHANGE((short) 6, "秀币兑换", -1),
		/**
		 * 
		 */
		UNEXCHANGE((short) 7, "取消秀币兑换", 1),
		/**
		 * 
		 */
		OPERATORPLUS((short) 8, "运营增加扶持币", 1),
		/**
		 * 
		 */
		OPERATORMINUS((short) 9, "运营减少扶持币", 1),
		/**
		 * 
		 */
		SENDRECHARGE((short) 10, "充值赠送金币", 1),
		/**
		 * 
		 */
		SENDINVITECODE((short) 11, "邀请码赠送金币", 1);

		private short balanceCostType;
		private String balanceCostName;
		private int state;

		private BalanceCostType(short balanceCostType, String balanceCostName, int state) {
			this.balanceCostType = balanceCostType;
			this.balanceCostName = balanceCostName;
			this.state = state;
		}

		public String getBalanceCostName() {
			return balanceCostName;
		}

		public short getBalanceCostType() {
			return balanceCostType;
		}

		public int getState() {
			return this.state;
		}
	}

	public static enum Flag implements Serializable {
		/**
		 * 启用
		 */
		ABLE((short) 1),
		/**
		 * 禁用
		 */
		DISABLE((short) 0);

		private short flag;

		private Flag(short flag) {
			this.flag = flag;
		}

		public short getFlag() {
			return this.flag;
		}
	}

	public static enum FromType implements Serializable {
		/**
		 * web网站
		 */
		WEB((short) 0),
		/**
		 * ANDROID
		 */
		ANDROID((short) 1),
		/**
		 * IOS
		 */
		IOS((short) 2);

		private short type;

		private FromType(short type) {
			this.type = type;
		}

		public short getType() {
			return this.type;
		}

		public static FromType getFromType(short type) {
			switch (type) {
				case 0:
					return FromType.WEB;
				case 1:
					return FromType.ANDROID;
				case 2:
					return FromType.IOS;
				default:
					return null;
			}
		}
	}

	public static enum DeleteFlag implements Serializable {
		/**
		 * 没有删除
		 */
		UNDELETE((short) 0),
		/**
		 * 删除
		 */
		DELETE((short) 1);

		private short flag;

		private DeleteFlag(short flag) {
			this.flag = flag;
		}

		public short getFlag() {
			return this.flag;
		}

	}

	public static enum RechageFlag implements Serializable {
		/**
		 * 初始状态
		 */
		INSTALL((short) 0),
		/**
		 * 成功
		 */
		SUCCESS((short) 1),
		/**
		 * 失败
		 */
		FAIL((short) 2);

		private short flag;

		private RechageFlag(short flag) {
			this.flag = flag;
		}

		public short getFlag() {
			return this.flag;
		}
	}

	public static enum Level implements Serializable {
		/**
		 * 群组等级
		 */
		ONE((int) 1),
		/**
		 * 
		 */
		TWO((int) 2),
		/**
		 * 
		 */
		THREE((int) 3),
		/**
		 * 
		 */
		FOUR((int) 4);

		private int level;

		private Level(int level) {
			this.level = level;
		}

		public int getLevel() {
			return this.level;
		}
	}

	public static enum ApplyFlag implements Serializable {
		// 申请标识：0申请中，1申请通过，2申请不通过
		/**
		 * 申请中
		 */
		INSTALL((short) 0),
		/**
		 * 申请通过
		 */
		PASS((short) 1),
		/**
		 * 申请不通过
		 */
		UNPASS((short) 2);

		private short flag;

		private ApplyFlag(short flag) {
			this.flag = flag;
		}

		public short getFlag() {
			return this.flag;
		}
	}

	public static enum GroupType implements Serializable {
		// 群组类型：0普通，1推荐
		/**
		 * 普通
		 */
		COMMON((short) 0),
		/**
		 * 推荐
		 */
		RECOMMEND((short) 1);

		private short type;

		private GroupType(short type) {
			this.type = type;
		}

		public short getType() {
			return this.type;
		}
	}
	

	/**
	 * 等级经验获取类型
	 * @author Administrator
	 *
	 */
	public static enum GradeLevelSetting implements Serializable {
		
		/**
		 * 作品
		 */
		COMPOSITON((int) 1),
		/**
		 * 转发作品
		 */
		FROM_COMPOSITON((int) 2),
		/**
		 * 被转发作品
		 */
		TO_COMPOSITON((int) 3),
		/**
		 * 评论
		 */
		FROM_COMMENT((int) 4),
		/**
		 * 被评论
		 */
		TO_COMMENT((int) 5),
		/**
		 * 收听
		 */
		FROM_LISTEN ((int) 6),
		/**
		 * 被收听
		 */
		TO_LISTEN((int) 7),
		/**
		 * 礼物
		 */
		GIFT((int) 8),
		/**
		 * 免费礼物
		 */
		FREE_GIFT((int) 9);
		
		private int type;

		private GradeLevelSetting(int type) {
			this.type = type;
		}

		public int getType() {
			return this.type;
		}
	}

}
