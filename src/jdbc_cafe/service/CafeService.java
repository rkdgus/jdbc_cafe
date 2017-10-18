package jdbc_cafe.service;

import java.sql.SQLException;
import java.util.List;

import jdbc_cafe.dao.CafeDao;
import jdbc_cafe.dto.Cafe;

public class CafeService {
	private CafeDao cafeDao;

	@SuppressWarnings("static-access")
	public CafeService() {
		this.cafeDao = cafeDao.getInstance();
	}
	
	public List<Cafe> selectAllPrice(){
		try {
			return cafeDao.selectAllPrice();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<Cafe> selectAllMarginPrice(){
		try {
			return cafeDao.selectAllMarginprice();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	
}
