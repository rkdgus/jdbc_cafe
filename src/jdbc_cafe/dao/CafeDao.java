package jdbc_cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_cafe.dto.Cafe;
import jdbc_cafe.jdbc.DBCon;

public class CafeDao {
	private static final CafeDao Instance = new CafeDao();

	public CafeDao() {
	}

	public static CafeDao getInstance() {
		return Instance;
	}
	
	public List<Cafe> selectAllPrice() throws SQLException {
		List<Cafe> lists = new ArrayList<>();
		String sql = "select * from cafe group by price desc "
				+ "union "
				+ "select '합계','','','',sum(supply),sum(surtex),sum(price),'',sum(marginprice) from cafe";
		
		Connection con = DBCon.getInstance().getConnection();

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				lists.add(getCafe(rs));
			}
		}

		return lists;
	}
	
	public List<Cafe> selectAllMarginprice() throws SQLException {
		List<Cafe> lists = new ArrayList<>();
		String sql = "select * from cafe group by marginprice desc"
				+ " union "
				+ "select '합계','','','',sum(supply),sum(surtex),sum(price),'',sum(marginprice) from cafe";
		
		Connection con = DBCon.getInstance().getConnection();

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				lists.add(getCafe(rs));
			}
		}

		return lists;
	}
	
	
	
	
	
	private Cafe getCafe(ResultSet rs) throws SQLException {
		String cofcode=rs.getString(1);
		String cofname = rs.getString(2);
		int cost = rs.getInt(3);
		int salesnum = rs.getInt(4);
		int supply = rs.getInt(5);
		int surtex = rs.getInt(6);
		int price = rs.getInt(7);
		int margin = rs.getInt(8);
		int marginprice = rs.getInt(9);
		
		return new Cafe(cofcode, cofname, cost, salesnum, supply, surtex, price, margin, marginprice);
	}
}
