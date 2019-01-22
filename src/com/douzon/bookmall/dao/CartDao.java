package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.bookmall.vo.BookVo;
import com.douzon.bookmall.vo.CartVo;

public class CartDao {
	public List<CartVo> getList() {
		List<CartVo> list = new ArrayList<CartVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			stmt = conn.createStatement();

			String sql = "select a.no, z.name, z.title, z.price, total\r\n" + "	from cart  a, (\r\n"
					+ "		select c.no, b.name, a.title, a.price, sum(c.count) as total\r\n"
					+ "		from book a, member b, cart c\r\n" + "		where c.member_no = b.no\r\n"
					+ "		and c.book_no = a.no\r\n" + "		group by a.title\r\n" + "    ) z\r\n"
					+ "    where a.no = z.no\r\n" + "    order by a.no";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long no = rs.getLong(1);
				String memberName = rs.getString(2);
				String bookTitle = rs.getString(3);
				Long bookPrice = rs.getLong(4);
				Long count = rs.getLong(5);

				CartVo vo = new CartVo();
				vo.setNo(no);
				vo.setMemberName(memberName);
				vo.setBookTitle(bookTitle);
				vo.setBookPrice(bookPrice);
				vo.setCount(count);

				list.add(vo);

			}

		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// insert
	public boolean insert(CartVo cartVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection();
			String sql = "insert into cart values (null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, cartVo.getMember_no());
			pstmt.setLong(2, cartVo.getBook_no());
			pstmt.setLong(3, cartVo.getCount());
			int count = pstmt.executeUpdate();

			result = count == 1;
		}

		catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public void displayCartInfo() {
		List<CartVo> list = new CartDao().getList();
		for (CartVo vo : list) {
			System.out.println("사용자 : " + vo.getMemberName() + ", 도서 제목 : " + vo.getBookTitle() + ", 수량 : "
					+ vo.getCount() + ", 가격 : " + vo.getBookPrice());
		}
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/bookmall";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패" + e);
		}
		return conn;
	}
}
