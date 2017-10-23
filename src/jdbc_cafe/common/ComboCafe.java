package jdbc_cafe.common;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import jdbc_cafe.dao.CoffeeDao;
import jdbc_cafe.dto.Coffee;

@SuppressWarnings("serial")
public class ComboCafe extends JPanel {

	private JComboBox<Coffee> comboBox;

	public ComboCafe(String name) {
		setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel = new JLabel(name);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);

		comboBox = new JComboBox<>();
		add(comboBox);

	}

	public JComboBox<Coffee> getComboBox() {
		return comboBox;
	}

	public void setComboboxModel(Vector<Coffee> lists) {
		ComboBoxModel<Coffee> model = new DefaultComboBoxModel<>(lists);
		comboBox.setModel(model);
	}

	public void setCodeModel() {
		List<Coffee> lists;
		try {
			lists = CoffeeDao.getInstance().selectItemByAll();
			Vector<Coffee> coffee = new Vector<>(lists);
			setComboboxModel(coffee);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Coffee getComboboxValue() {

		return (Coffee) comboBox.getSelectedItem();
	}

	public void setSelected() {
		comboBox.setSelectedIndex(0);

	}
}
