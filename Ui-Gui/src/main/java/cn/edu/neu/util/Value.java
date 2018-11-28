package cn.edu.neu.util;

public class Value {
	
	//备份数据库地址
	private static final String backupUGDBPath = "";
	
	//主页里用户每次浏览的柜子
	private static final int offSize = 6;
	//设置时间转换钱的大小：eg:一个小时多少元？
	private static final double time2money = 0.1;
	//签到奖励规则:每天签到一次给baseAward分钟，连续签到，增加奖励，第(x)天获得baseAward+x/(cycleAward)*baseAward（分钟）
	private static final int baseAward = 100;
	private static final int cycleAward = 5;
	//用户第一次注册赠送免费租用时长，暂时设置为1天
	private static final long signBoxtime = 86400000;
	
	
	//支付相关
	//小程序ID
	private static final String appid = "";
	//商户号
	private static final String mch_id = "";
	//终端IP
	private static final String spbill_create_ip = "";
	//接收支付结果通知的地址
	private static final String notify_url = "http://"+spbill_create_ip+":8080/Ui-Gui/pay/resultNotify";
	//商户平台秘钥
	private static final String secret_key = "";
	
	
	//硬件服务器IP地址，用户名，密码
	private static final String boxOpenUrl = "";
	private static final String boxOpenUser = "";
	private static final String boxOpenPassword = "";
	
	
	
	public static String getBackupugdbpath() {
		return backupUGDBPath;
	}
	public static String getSecretKey() {
		return secret_key;
	}
	public static String getAppid() {
		return appid;
	}
	public static String getMchId() {
		return mch_id;
	}
	public static String getSpbillCreateIp() {
		return spbill_create_ip;
	}
	public static String getNotifyUrl() {
		return notify_url;
	}
	public static String getBoxopenurl() {
		return boxOpenUrl;
	}
	public static String getBoxopenuser() {
		return boxOpenUser;
	}
	public static String getBoxopenpassword() {
		return boxOpenPassword;
	}
	public static int getOffsize() {
		return offSize;
	}
	public static double getTime2money() {
		return time2money;
	}
	public static int getBaseaward() {
		return baseAward;
	}
	public static int getCycleaward() {
		return cycleAward;
	}
	public static int awardtime(int UsersignDays) {
		return baseAward+UsersignDays/cycleAward*baseAward;
	}
	public static long getSignboxtime() {
		return signBoxtime;
	}
}
