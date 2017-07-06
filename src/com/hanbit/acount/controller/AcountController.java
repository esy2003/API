package com.hanbit.acount.controller;

import java.util.Vector;

import javax.swing.JOptionPane;

import com.hanbit.acount.domain.AcountBean;
import com.hanbit.acount.service.AcountService;
import com.hanbit.acount.serviceImpl.AcountServiceImpl;

public class AcountController {
	public static void main(String[] args) {
		AcountService service = new AcountServiceImpl();
		AcountBean bean = null;
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료 1.계좌개설 2.계좌리스트 3.이름검색(동명이인허용) 4.계좌번호조회\n"
					+ "5.전체계좌갯수 6.비밀번호변경 7.예금 8.출금 9.계좌해지")) {
			case "0":
				JOptionPane.showMessageDialog(null, "프로그램을 종료합니다");
				return;
			case "1":
				bean = new AcountBean();
				String[] info = JOptionPane.showInputDialog("이름/주민번호/아이디/비밀번호/입금액").split("/");
				bean.setName(info[0]);
				bean.setSSN(info[1]);
				bean.setId(info[2]);
				bean.setPw(info[3]);
				bean.setMoney(Integer.parseInt(info[4]));
				service.createBankBook(bean);
				JOptionPane.showMessageDialog(null, "계좌생성");
				break;
			case "2":
				System.out.println(bean.toString());
				Vector<AcountBean> vec = service.bankBookList();
				String bankList = "";
				for (int i=0;i<service.countList();i++) {
					bankList += vec.get(i).toString() + "\n";
				}
				
				JOptionPane.showMessageDialog(null, "계좌리스트 : " + bankList.toString());
				break;
			case "3":
				Vector<AcountBean> vec2 = service.searchByName(JOptionPane.showInputDialog("이름검색"));
				JOptionPane.showMessageDialog(null, "이름으로 검색한 계좌리스트 : " + vec2);
				break;
			case "4":
				bean = new AcountBean();
				bean=service.findByBankBookNo(Integer.parseInt(JOptionPane.showInputDialog("계좌번호")));
				JOptionPane.showMessageDialog(null, "계좌번호로 조회한 계좌 : " + bean.toString());
				break;
			case "5":
				int count = service.countList();
				JOptionPane.showMessageDialog(null, "계좌개수 : "+ count);
				break;
			case "6":
				bean = new AcountBean();
				String[] arr = JOptionPane.showInputDialog("계좌번호/비밀번호").split("/");
				bean.setBankBookNo(Integer.parseInt(arr[0]));
				bean.setPw(arr[1]);
				service.updatePw(bean);
				JOptionPane.showMessageDialog(null, "비밀번호 변경 완료");
				break;
			case "7":
				bean = new AcountBean();
				String[] arr1 = JOptionPane.showInputDialog("계좌번호/예금금액").split("/");
				bean.setBankBookNo(Integer.parseInt(arr1[0]));
				bean.setMoney(Integer.parseInt(arr1[1]));
				service.deposit(bean);
				JOptionPane.showMessageDialog(null, "예금완료");
				break;
			case "8":
				bean = new AcountBean();
				String[] arr2 = JOptionPane.showInputDialog("계좌번호/출금금액").split("/");
				bean.setBankBookNo(Integer.parseInt(arr2[0]));
				bean.setMoney(Integer.parseInt(arr2[1]));
				service.withdraw(bean);
				JOptionPane.showMessageDialog(null, "출금완료");
				break;
			case "9":
				service.deleteBankBook(Integer.parseInt(JOptionPane.showInputDialog("계좌번호")));
				JOptionPane.showMessageDialog(null, "해지완료");
				break;
			}
		}
	}

}
