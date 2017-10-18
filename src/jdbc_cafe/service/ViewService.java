package jdbc_cafe.service;

import java.sql.SQLException;
import java.util.List;

import jdbc_cafe.dao.ViewDao;
import jdbc_cafe.dto.View;

public class ViewService {
	private ViewDao viewDao;

	public ViewService(ViewDao viewDao) {
		this.viewDao = viewDao;
	}
	
	public List<View> selectAllPrice(){
		try {
			return viewDao.selectAllPrice();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	

}
