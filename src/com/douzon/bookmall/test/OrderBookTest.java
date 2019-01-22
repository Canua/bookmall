package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.CartDao;
import com.douzon.bookmall.dao.OrderBookDao;
import com.douzon.bookmall.vo.CartVo;
import com.douzon.bookmall.vo.OrderBookVo;

public class OrderBookTest {
	public static void main(String[] args) {
//		insertTest(1L); // 책 몇권 팔렸냐
//		getListTest();
		displayCartInfo();
	}

	public static void insertTest(Long book_no) {
		OrderBookVo vo = new OrderBookVo();
		vo.setBook_no(book_no);
		new OrderBookDao().insert(vo);

	}

	public static void getListTest() {
		List<OrderBookVo> list = new OrderBookDao().getList();
		for (OrderBookVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void displayCartInfo() {
		List<OrderBookVo> list = new OrderBookDao().getList();
		for (OrderBookVo vo : list) {
			System.out.println(
					"도서번호 : " + vo.getBookNo() + ", 도서제목 : " + vo.getBookTitle() + ", 수량 : " + vo.getCount());
		}
	}

}
