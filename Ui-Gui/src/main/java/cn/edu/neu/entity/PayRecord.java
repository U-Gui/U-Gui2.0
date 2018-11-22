package cn.edu.neu.entity;

public class PayRecord {

	private String openId;
	private String bankType;
	private Integer totalFee;
	private double overtimeMoney;
	private String transactionId;
	private String outTradeNo;
	private String timeEnd;
	private String body;
	private Integer nofityStatus;
	public PayRecord() {}
	public PayRecord(String openId, String bankType, Integer totalFee, double overtimeMoney, String transactionId,
			String outTradeNo, String timeEnd, String body, Integer nofityStatus) {
		super();
		this.openId = openId;
		this.bankType = bankType;
		this.totalFee = totalFee;
		this.overtimeMoney = overtimeMoney;
		this.transactionId = transactionId;
		this.outTradeNo = outTradeNo;
		this.timeEnd = timeEnd;
		this.body = body;
		this.nofityStatus = nofityStatus;
	}
	public PayRecord(String openId, Integer totalFee, double overtimeMoney, String outTradeNo, String body,
			Integer nofityStatus) {
		super();
		this.openId = openId;
		this.totalFee = totalFee;
		this.overtimeMoney = overtimeMoney;
		this.outTradeNo = outTradeNo;
		this.body = body;
		this.nofityStatus = nofityStatus;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getBankType() {
		return bankType;
	}
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
	public Integer getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}
	public double getOvertimeMoney() {
		return overtimeMoney;
	}
	public void setOvertimeMoney(double overtimeMoney) {
		this.overtimeMoney = overtimeMoney;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getOutTradeNo() {
		return outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	public String getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Integer getNofityStatus() {
		return nofityStatus;
	}
	public void setNofityStatus(Integer nofityStatus) {
		this.nofityStatus = nofityStatus;
	}
	
}
