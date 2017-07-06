package com.hanbit.acount.service;

import java.util.Vector;

import com.hanbit.acount.domain.AcountBean;

public interface AcountService {
	public void createBankBook(AcountBean bean);
	public Vector<AcountBean> bankBookList();
	public Vector<AcountBean> searchByName(String name);
	public AcountBean findByBankBookNo(int bankBookNo);
	public int countList();
	public void updatePw(AcountBean bean);
	public void deposit(AcountBean bean);
	public void withdraw(AcountBean bean);
	public void deleteBankBook(int bankBookNo);
}
