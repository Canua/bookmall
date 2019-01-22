package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.MemberDao;
import com.douzon.bookmall.vo.MemberVo;

public class MemberTest {

	public static void main(String[] args) {
//		insertTest("둘리", "1111-1234", "Dooly@naver.com", "1234", "Busan");
//		insertTest("또치", "2222-1234", "Ddochi@naver.com", "4321", "Seoul");
		displayMemberInfo();
	}

	public static void insertTest(String name, String tel, String mail, String pwd, String addr) {
		MemberVo vo = new MemberVo();
		vo.setName(name);
		vo.setTel(tel);
		vo.setMail(mail);
		vo.setPwd(pwd);
		vo.setAddr(addr);
		new MemberDao().insert(vo);
	}

	public static void displayMemberInfo() {
		List<MemberVo> list = new MemberDao().getList();
		for (MemberVo vo : list) {
			System.out.println("번호 : " + vo.getNo() + ", 전화번호 : " + vo.getTel() + ", e-mail : " + vo.getMail() + ", 비밀번호 : " + vo.getPwd() + ", 주소 : " + vo.getAddr());
		}
	}
}
