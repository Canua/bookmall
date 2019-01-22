package com.douzon.bookmall.vo;

public class OrderBookVo {
	private long no;
	private long book_no;

	private long bookNo;
	private String bookTitle;
	private long count;

	public OrderBookVo() {

	}

	public OrderBookVo(long book_no) {
		this.book_no = book_no;
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public long getBook_no() {
		return book_no;
	}

	public void setBook_no(long book_no) {
		this.book_no = book_no;
	}

	public long getBookNo() {
		return bookNo;
	}

	public void setBookNo(long bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "OrderBookVo [no=" + no + ", book_no=" + book_no + ", bookNo=" + bookNo + ", bookTitle=" + bookTitle
				+ ", count=" + count + "]";
	}

}
