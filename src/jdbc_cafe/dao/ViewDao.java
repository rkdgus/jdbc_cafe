package jdbc_cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc_cafe.dto.View;
import jdbc_cafe.jdbc.DBCon;

public class ViewDao {
	private static final ViewDao Instance = new ViewDao();

	public ViewDao() {
		// TODO Auto-generated constructor stub
	}

	public static ViewDao getInstance() {
		return Instance;
	}

	public List<View> selectAllPrice() throws SQLException {
		List<View> lists = new ArrayList<>();
		String sql = "select * from showlist";

		Connection con = DBCon.getInstance().getConnection();

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				lists.add(getView(rs));
			}
		}

		return lists;
	}

	private View getView(ResultSet rs) throws SQLException {
		String crank = rs.getString(1);
		String cofcode= rs.getString(2);
		String cofname= rs.getString(3);
		String cost= rs.getString(4);
		String salesnum= rs.getString(5);
		String supply= rs.getString(6);
		String surtex= rs.getString(7);
		String price= rs.getString(8);
		String margin= rs.getString(9);
		String marginprice= rs.getString(10);

		return new View(crank, cofcode, cofname, cost, salesnum, supply, surtex, price, margin, marginprice);
	}
}
