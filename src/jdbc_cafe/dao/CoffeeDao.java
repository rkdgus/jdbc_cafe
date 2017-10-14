package jdbc_cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
	public String selectName(Coffee item) throws SQLException{
		String sql = "select cofname from coffee where cofcode=?";
		Connection con = DBCon.getInstance().getConnection();
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, item.getCost());
		}
		return null;
		
	}
	
	
	public void updateItem(Coffee item) throws SQLException{
		String sql = "update coffee set cost=?, salesnum=?, margin=? where cofcode=?";
		Connection con = DBCon.getInstance().getConnection();
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, item.getCost());
			pstmt.setInt(2, item.getSalesnum());
			pstmt.setInt(3, item.getMargin());
			pstmt.setString(4, item.getCofcode());
			
			pstmt.executeUpdate();
			System.out.println(pstmt);
			
		}
		
	}
	
	
	


}
