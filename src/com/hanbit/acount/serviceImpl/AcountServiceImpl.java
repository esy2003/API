package com.hanbit.acount.serviceImpl;

import java.util.Calendar;
import java.util.Vector;

import com.hanbit.acount.domain.AcountBean;
import com.hanbit.acount.service.AcountService;

public class AcountServiceImpl implements AcountService {
	Vector<AcountBean> vec;
	AcountBean bean;
	public AcountServiceImpl() {
		vec = new Vector<>(10,10);
		bean = new AcountBean();
	}
	
	@Override
	public void createBankBook(AcountBean bean) {
		int randomNo = (int)(Math.random()*99999999+10000000);
		bean.setBankBookNo(randomNo);
		
		Calendar now = Calendar.getInstance();
		int yy = now.get(now.YEAR);
		int mm = now.get(now.MONTH)+1;
		int dd = now.get(now.DAY_OF_MONTH);
		
		bean.setTradeDate(String.valueOf(yy) + "년 " + String.valueOf(mm) + "월 " + String.valueOf(dd) + "일");
		
		vec.add(bean);
	}

	@Override
	public Vector<AcountBean> bankBookList() {
		return vec;
	}

	@Override
	public Vector<AcountBean> searchByName(String name) {
		Vector<AcountBean> vec1 = new Vector<>(10,10);
		
		for (int i=0;i<vec.size();i++) {
			if (name.equals(vec.get(i).getName())) {
				vec1.add(vec.get(i));
			}
		}
		return vec1;
	}

	@Override
	public AcountBean findByBankBookNo(int bankBookNo) {
		bean = new AcountBean();
		for (int i=0;i<vec.size();i++) {
			if (bankBookNo == vec.get(i).getBankBookNo()) {
				bean = vec.get(i);
			}
		}
		return bean;
	}

	@Override
	public int countList() {
		return vec.size();
	}

	@Override
	public void updatePw(AcountBean bean) {
		for (int i=0;i<vec.size();i++) {
			if (bean.getBankBookNo() == vec.get(i).getBankBookNo()) {
				vec.get(i).setPw(bean.getPw());
			}
		}
	}

	@Override
	public void deposit(AcountBean bean) {
		for (int i=0;i<vec.size();i++) {
			if (bean.getBankBookNo() == vec.get(i).getBankBookNo()) {
				vec.get(i).setMoney(vec.get(i).getMoney() + bean.getMoney());
			}
		}
	}

	@Override
	public void withdraw(AcountBean bean) {
		for (int i=0;i<vec.size();i++) {
			if (bean.getBankBookNo() == vec.get(i).getBankBookNo()) {
				vec.get(i).setMoney(vec.get(i).getMoney() - bean.getMoney());
			}	
		}
	}

	@Override
	public void deleteBankBook(int bankBookNo) {
		for (int i=0;i<vec.size();i++) {
			if (bankBookNo == vec.get(i).getBankBookNo()) {
				vec.remove(vec.get(i));
			}
		}
	}
}
