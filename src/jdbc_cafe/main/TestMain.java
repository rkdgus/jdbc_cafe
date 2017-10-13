package jdbc_cafe.main;

import java.sql.Connection;

import jdbc_cafe.jdbc.DBCon;

public class TestMain {

	public static void main(String[] args) {
		
			testDBCon();

			
		

	}

	private static void testDBCon() {
		DBCon dbCon = DBCon.getInstance();

		Connection connection = dbCon.getConnection();
		System.out.println(connection);
	}

}
