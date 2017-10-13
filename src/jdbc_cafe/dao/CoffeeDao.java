package jdbc_cafe.dao;

public class CoffeeDao {
	private static final CoffeeDao Instance = new CoffeeDao();

	public CoffeeDao() {
		// TODO Auto-generated constructor stub
	}

	public static CoffeeDao getInstance() {
		return Instance;
	}
	
	
}
