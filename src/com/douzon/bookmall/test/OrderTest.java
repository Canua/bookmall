package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.OrderDao;
import com.douzon.bookmall.vo.OrderVo;

public class OrderTest {
	public static void main(String[] args) {
//		insertTest(1L); // 멤버, 책 번호, 수량
//		getListTest();
		displayOrderInfo();
	}

	public static void insertTest(Long member_no) {
		OrderVo vo = new OrderVo();
		vo.setMember_no(member_no);
		new OrderDao().insert(vo);
	}
	
	public static void getListTest() {
		List<OrderVo> list = new OrderDao().getList();
		for (OrderVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void displayOrderInfo() { // DAO
		List<OrderVo> list = new OrderDao().getList();
		for (OrderVo vo : list) {
			System.out.println("주문번호 : " + vo.getNo() + ", 주문자 : " + vo.getMemberName() + ", 결제금액 : "
					+ vo.getTotalPayemnt() + ", 배송지 : " + vo.getMemberAddr());
		}
	}

}
