package jdbc_cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_cafe.dto.Coffee;
import jdbc_cafe.jdbc.DBCon;

public class CoffeeDao {
	private static final CoffeeDao Instance = new CoffeeDao();

	public CoffeeDao() {
		// TODO Auto-generated constructor stub
	}

	public static CoffeeDao getInstance() {
		return Instance;
	}

	public void insertItem(Coffee item) throws SQLException {
		String sql = "insert into coffee values(?,?,?,?,?)";
		Connection con = DBCon.getInstance().getConnection();

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, item.getCofcode());
			pstmt.setString(2, item.getCofname());
			pstmt.setInt(3, item.getCost());
			pstmt.setInt(4, item.getSalesnum());
			pstmt.setInt(5, item.getMargin());

			pstmt.executeUpdate();

		}
	}

	public Coffee selectName(Coffee item) throws SQLException {
		String sql = "select * from coffee where cofcode=?";
		Connection con = DBCon.getInstance().getConnection();
		Coffee coffee = null;
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, item.getCofcode());

			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					coffee = getCoffee(rs);
				}
			}
		}
		return coffee;

	}

	private Coffee getCoffee(ResultSet rs) throws SQLException {
		String cofcode = rs.getString(1);
		String cofname = rs.getString(2);
		int cost = rs.getInt(3);
		int salesnum = rs.getInt(4);
		int margin = rs.getInt(5);
		return new Coffee(cofcode, cofname, cost, salesnum, margin);
	}

	public void updateItem(Coffee item) throws SQLException {
		String sql = "update coffee set cost=?, salesnum=?, margin=? where cofcode=?";
		Connection con = DBCon.getInstance().getConnection();

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, item.getCost());
			pstmt.setInt(2, item.getSalesnum());
			pstmt.setInt(3, item.getMargin());
			pstmt.setString(4, item.getCofcode());

			pstmt.executeUpdate();

		}

	}

	public List<Coffee> selectItemByAll() throws SQLException {
		List<Coffee> lists = new ArrayList<>();
		String sql = "select * from coffee";
		Connection con = DBCon.getInstance().getConnection();

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				lists.add(getCoffee(rs));
			}
		}

		return lists;
	}

}
