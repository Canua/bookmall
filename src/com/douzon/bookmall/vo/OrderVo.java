package com.douzon.bookmall.vo;

public class OrderVo {
	private long no;
	private long member_no;
	private String memberName;
	private long totalPayment;
	private String memberAddr;

	public OrderVo() {

	}

	public OrderVo(long member_no) {
		this.member_no = member_no;
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public long getMember_no() {
		return member_no;
	}

	public void setMember_no(long member_no) {
		this.member_no = member_no;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public long getTotalPayemnt() {
		return totalPayment;
	}

	public void setTotalPayemnt(long totalPayemnt) {
		this.totalPayment = totalPayemnt;
	}

	public String getMemberAddr() {
		return memberAddr;
	}

	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}

	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", member_no=" + member_no + ", memberName=" + memberName + ", totalPayemnt="
				+ totalPayment + ", memberAddr=" + memberAddr + "]";
	}

}
