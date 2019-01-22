package com.douzon.bookmall.vo;

import java.util.List;

import com.douzon.bookmall.dao.BookDao;
import com.douzon.bookmall.dao.MemberDao;

public class MemberVo {
	private long no;
	private String name;
	private String tel;
	private String mail;
	private String pwd;
	private String addr;

	public MemberVo() {

	}

	public MemberVo(String name, String tel, String mail, String pwd, String addr) {
		this.name = name;
		this.tel = tel;
		this.mail = mail;
		this.pwd = pwd;
		this.addr = addr;
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", name=" + name + ", tel=" + tel + ", mail=" + mail + ", pwd=" + pwd + ", addr="
				+ addr + "]";
	}

}
