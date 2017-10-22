package jdbc_cafe.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import jdbc_cafe.dao.CoffeeDao;
import jdbc_cafe.dto.Coffee;

public class CoffeeService {
	private CoffeeDao coffeeDao;

	@SuppressWarnings("static-access")
	public CoffeeService() {
		this.coffeeDao = coffeeDao.getInstance();
	}

	public void insertCoffee(Coffee coffee) {
		try {
			coffeeDao.insertItem(coffee);
			showMessage("추가완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateCoffee(Coffee coffee) {
		try {
			coffeeDao.updateItem(coffee);
			showMessage("입력완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void deleteCoffee(Coffee coffee) {
		try {
			coffeeDao.deleteItem(coffee);
			showMessage("삭제완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public Coffee selectCodeName(Coffee coffee) {
		try {
			return coffeeDao.selectName(coffee);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public List<Coffee> selectAll() {
		try {
			return coffeeDao.selectItemByAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
