package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.bookmall.vo.OrderVo;

public class OrderDao {
	public List<OrderVo> getList() {
		List<OrderVo> list = new ArrayList<OrderVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			stmt = conn.createStatement();

			String sql = "select a.no, z.name, total, z.addr" + "		from request a, ("
					+ "				select a.no, a.name, sum(d.price * b.count) as total, a.addr"
					+ "				from member a, cart b, book d" + "				where b.member_no = a.no"
					+ "				and b.book_no = d.no" + "				group by a.name) z"
					+ "		where a.member_no = z.no" + "        order by no";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long no = rs.getLong(1);
				String memberName = rs.getString(2);
				Long totalPayment = rs.getLong(3);
				String memberAddr = rs.getString(4);

				OrderVo vo = new OrderVo();
				vo.setNo(no);
				vo.setMemberName(memberName);
				vo.setTotalPayemnt(totalPayment);
				vo.setMemberAddr(memberAddr);

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
	public boolean insert(OrderVo orderVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection();
			String sql = "insert into request values(null, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, orderVo.getMember_no());
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

	public void displayOrderInfo() { // DAO
		List<OrderVo> list = new OrderDao().getList();
		for (OrderVo vo : list) {
			System.out.println("주문번호 : " + vo.getNo() + ", 주문자 : " + vo.getMemberName() + ", 결제금액 : "
					+ vo.getTotalPayemnt() + ", 배송지 : " + vo.getMemberAddr());
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
