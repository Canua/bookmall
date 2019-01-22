package com.douzon.bookmall.main;

import com.douzon.bookmall.dao.BookDao;
import com.douzon.bookmall.dao.CartDao;
import com.douzon.bookmall.dao.CategoryDao;
import com.douzon.bookmall.dao.MemberDao;
import com.douzon.bookmall.dao.OrderBookDao;
import com.douzon.bookmall.dao.OrderDao;
import com.douzon.bookmall.vo.BookVo;
import com.douzon.bookmall.vo.CartVo;
import com.douzon.bookmall.vo.CategoryVo;
import com.douzon.bookmall.vo.MemberVo;
import com.douzon.bookmall.vo.OrderBookVo;
import com.douzon.bookmall.vo.OrderVo;

public class BookMall {
	public static void main(String[] args) {

		MemberDao member = new MemberDao();
		CategoryDao category = new CategoryDao();
		BookDao book = new BookDao();
		CartDao cart = new CartDao();
		OrderDao order = new OrderDao();
		OrderBookDao orderbook = new OrderBookDao();

		member.insert(new MemberVo("둘리", "1111-1234", "Dooly@naver.com", "1234", "Busan"));
		member.insert(new MemberVo("또치", "1111-3456", "Ddochi@naver.com", "4321", "Seoul"));

		System.out.println("============= 사용자 =============");
		member.displayMemberInfo();

		category.insert(new CategoryVo("IT"));
		category.insert(new CategoryVo("소설"));
		category.insert(new CategoryVo("예술"));

		System.out.println("============= 카테고리 =============");
		category.displayCategoryInfo();

		book.insert(new BookVo("이것이 자바다", 19800L, 1L));
		book.insert(new BookVo("자바의 정석", 29900L, 1L));
		book.insert(new BookVo("스페인 예술로 걷다", 12000L, 3L));
		book.insert(new BookVo("소나기", 20000L, 2L));

		System.out.println("============= 서적 =============");
		book.displayBookInfo();

		cart.insert(new CartVo(1L, 1L, 2L));
		cart.insert(new CartVo(1L, 3L, 1L));

		System.out.println("============= 카트 =============");
		cart.displayCartInfo();

		order.insert(new OrderVo(1L));

		System.out.println("============= 주문 =============");
		order.displayOrderInfo();

		System.out.println("============= 주문도서 =============");
		orderbook.insert(new OrderBookVo(1L));
		orderbook.insert(new OrderBookVo(2L));
		orderbook.insert(new OrderBookVo(3L));

		orderbook.displayCartInfo();
	}
}
