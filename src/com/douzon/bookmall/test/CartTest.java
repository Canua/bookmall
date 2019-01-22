package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.CartDao;
import com.douzon.bookmall.vo.CartVo;

public class CartTest {
	public static void main(String[] args) {
//		insertTest(3L, 1L, 3L); // 멤버, 책 번호, 수량
//		getListTest();
		displayCartInfo();
	}

	public static void insertTest(Long member_no, Long book_no, Long count) {
		CartVo vo = new CartVo();
		vo.setMember_no(member_no);
		vo.setBook_no(book_no);
		vo.setCount(count);
		new CartDao().insert(vo);
	}

	public static void getListTest() {
		List<CartVo> list = new CartDao().getList();
		for (CartVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void displayCartInfo() {
		List<CartVo> list = new CartDao().getList();
		for (CartVo vo : list) {
			System.out.println("사용자 : " + vo.getMemberName() + ", 도서 제목 : " + vo.getBookTitle() + ", 수량 : "
					+ vo.getCount() + ", 가격 : " + vo.getBookPrice());
		}
	}

}
