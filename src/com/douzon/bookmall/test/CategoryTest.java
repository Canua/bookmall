package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.CategoryDao;
import com.douzon.bookmall.vo.CategoryVo;

public class CategoryTest {

	public static void main(String[] args) {
//		insertTest("IT");
//		insertTest("소설");
//		insertTest("예술");
		displayCategoryInfo();
	}

	public static void insertTest(String name) {
		CategoryVo vo = new CategoryVo();
		vo.setName(name);
		new CategoryDao().insert(vo);
	}

	public static void displayCategoryInfo() {
		List<CategoryVo> list = new CategoryDao().getList();
		for (CategoryVo vo : list) {
			System.out.println("번호 : " + vo.getNo() + ", 이름 : " + vo.getName());
		}
	}
}
