package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.BookDao;
import com.douzon.bookmall.vo.BookVo;

public class BookTest {
	public static void main(String[] args) {
//		insertTest("자바스크립트 프로젝트북", 22000L, 1L);
//		getListTest();
		displayBookInfo();
	}

	public static void insertTest(String title, Long price, Long category_no) {
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setPrice(price);
		vo.setCategory_no(category_no);
		new BookDao().insert(vo);
	}

	public static void getListTest() {
		List<BookVo> list = new BookDao().getList();
		for (BookVo vo : list) {
			System.out.println(vo);
		}

	}

	private static void displayBookInfo() { // DAO
		List<BookVo> list = new BookDao().getList();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("카테고리 : " + list.get(i).getCategoryName() + ", 제목 : " + list.get(i).getTitle()
					+ ", 가격 : " + list.get(i).getPrice());
		}
	}
}
