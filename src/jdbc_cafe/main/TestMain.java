package jdbc_cafe.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc_cafe.dao.CafeDao;
import jdbc_cafe.dao.CoffeeDao;
import jdbc_cafe.dto.Cafe;
import jdbc_cafe.dto.Coffee;
import jdbc_cafe.jdbc.DBCon;

public class TestMain {

	public static void main(String[] args) {
		
//			testDBCon();
//			testCoffeDao();
			
		testCafeDao();
	
		
	}

	private static void testCafeDao() {
		try {
			List<Cafe> lists=CafeDao.getInstance().selectAllMarginprice();
			
			for(Cafe c : lists){
				System.out.println(c);
			
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	private static void testCoffeDao() {
		try {
			CoffeeDao.getInstance().updateItem(new Coffee("A001","아메리카노", 500, 10, 30));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

	private static void testDBCon() {
		DBCon dbCon = DBCon.getInstance();

		Connection connection = dbCon.getConnection();
		System.out.println(connection);
	}

}
