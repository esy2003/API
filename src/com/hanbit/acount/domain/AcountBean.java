package com.hanbit.acount.domain;

public class AcountBean {

	private String name, id, pw, tradeDate, ssn;
	private int money, bankBookNo;
	public static final String BANK_NAME = "KB국민은행";
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	public int getMoney() {
		return money;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPw() {
		return pw;
	}
	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}
	public String getTradeDate() {
		return tradeDate;
	}
	
	public void setSSN(String ssn) {
		this.ssn = ssn;
	}
	public String getSSN() {
		return ssn;
	}
	
	public void setBankBookNo(int bankBookNo) {
		this.bankBookNo = bankBookNo;
	}
	public int getBankBookNo() {
		return bankBookNo;
	}
	
	@Override
	public String toString() {
		return String.format(BANK_NAME + "감사합니다. " + "계좌정보[이름 : %s, 계좌번호 : %d, 잔액 : %d원, 현재날짜 : %s]", name, bankBookNo, money, tradeDate);
	}
}
