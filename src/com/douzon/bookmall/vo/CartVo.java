package com.douzon.bookmall.vo;

public class CartVo {
	private long no;
	private long member_no;
	private long book_no;
	private long count;
	private String memberName;
	private String bookTitle;
	private long bookPrice;

	public CartVo() {

	}

	public CartVo(long member_no, long book_no, long count) {
		this.member_no = member_no;
		this.book_no = book_no;
		this.count = count;
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

	public long getBook_no() {
		return book_no;
	}

	public void setBook_no(long book_no) {
		this.book_no = book_no;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public long getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(long bookPrice) {
		this.bookPrice = bookPrice;
	}

	@Override
	public String toString() {
		return "CartVo [no=" + no + ", member_no=" + member_no + ", book_no=" + book_no + ", count=" + count
				+ ", memberName=" + memberName + ", bookTitle=" + bookTitle + ", bookPrice=" + bookPrice + "]";
	}

}
