package jdbc_cafe.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import jdbc_cafe.common.ComboCafe;
import jdbc_cafe.common.TextFieldCafe;
import jdbc_cafe.dto.Coffee;
import jdbc_cafe.service.CoffeeService;

@SuppressWarnings("serial")
public class InputCoffeePanel extends JPanel {
	private TextFieldCafe pCost;
	private TextFieldCafe pSalesNum;
	private TextFieldCafe pMargin;
	private JPanel panel;
	private JLabel lblName;
	private JLabel tfName;
	private ComboCafe comBoBox;
	private CoffeeService service;

	public InputCoffeePanel(CoffeeService service) {
		this.service = service;
		setLayout(new GridLayout(0, 1, 5, 5));
		
		comBoBox = new ComboCafe("제품코드");
		comBoBox.getComboBox().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				selectCoffeeName();
				
			}
		});
		add(comBoBox);
		

		panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		lblName = new JLabel("제품명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblName);

		tfName = new JLabel("");
		tfName.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(tfName);

		pCost = new TextFieldCafe("제품단가");
		add(pCost);

		pSalesNum = new TextFieldCafe("판매수량");
		add(pSalesNum);

		pMargin = new TextFieldCafe("마 진 율");
		add(pMargin);
		
		setCodeModel();
		
	}

	private void selectCoffeeName() {
		Coffee code =  comBoBox.getComboboxValue();
//		String code ="A001";
		
		setLbl(service.selectCodeName(code).getCofname());
			
		
	}

	private void setCodeModel() {
		List<Coffee> lists = service.selectAll();
		Vector<Coffee> coffee = new Vector<>(lists);
		
		comBoBox.setComboboxModel(coffee);				
	}


	public void setLbl(String code) {
		tfName.setText(code);
	}
	
	public void getTf(){
		Coffee coffee = (Coffee) comBoBox.getComboboxValue();
		String cofname = tfName.getText();
		int cost = Integer.parseInt(pCost.getTextField());
		int salesnum = Integer.parseInt(pSalesNum.getTextField());
		int margin = Integer.parseInt(pMargin.getTextField());
		
		service.updateCoffee(new Coffee(coffee.getCofcode(), cofname, cost, salesnum, margin));
	}
	
	public void clearTf(){
		comBoBox.setSelected();
		tfName.setText("");
		pCost.setTextField("");
		pSalesNum.setTextField("");
		pMargin.setTextField("");
	}
}
