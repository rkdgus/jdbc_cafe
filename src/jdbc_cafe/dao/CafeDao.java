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
		String sql = "select * from byPrice "
				+ "union "
				+ "select '합계','','','','',sum(supply),sum(surtex),sum(price),'',sum(marginprice) "
				+ "from byPrice";
		
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
		String sql = "select * from byMarginprice "
				+ "union"
				+ " select '합계','','','','',sum(supply),sum(surtex),sum(price),'',sum(marginprice) "
				+ "from byMarginprice";
		
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
		String crank=rs.getString(1);
		String cofcode=rs.getString(2);
		String cofname = rs.getString(3);
		String cost = String.format("%,d", rs.getInt(4)) ;
		String salesnum = String.format("%,d", rs.getInt(5)) ;
		String supply = String.format("%,d", rs.getInt(6)) ;
		String surtex = String.format("%,d", rs.getInt(7)) ;
		String price = String.format("%,d", rs.getInt(8)) ;
		String margin = String.format("%,d", rs.getInt(9)) ;
		String marginprice = String.format("%,d", rs.getInt(10)) ;
		
		return new Cafe(crank, cofcode, cofname, cost, salesnum, supply, surtex, price, margin, marginprice);
	}
}
