package cn.edu.neu.util;

public class Value {
	//主页里用户每次浏览的柜子
	private static final int offSize = 6;
	//设置时间转换钱的大小：eg:一个小时多少钱？
	private static final double time2money = 0.1;
	//签到奖励规则:每天签到一次给baseAward分钟，连续签到，增加奖励，第(x)天获得baseAward+x/(cycleAward)*baseAward（分钟）
	private static final int baseAward = 100;
	private static final int cycleAward = 5;
	//用户第一次注册赠送免费租用时长，暂时设置为1天
	private static final long signBoxtime = 86400000;
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
