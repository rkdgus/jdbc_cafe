package jdbc_cafe.content;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc_cafe.common.ComboCafe;
import jdbc_cafe.common.TextFieldCafe;
import jdbc_cafe.dto.Coffee;
import jdbc_cafe.service.CoffeeService;

@SuppressWarnings("serial")
public class InsertCoffee extends AbstractContent implements ActionListener {
	private JButton btnAdd;
	private CoffeeService service;
	private TextFieldCafe pCode;
	private TextFieldCafe pName;
	private JButton btnDelete;
	private ComboCafe comBoBox;
	
	
	public InsertCoffee(CoffeeService service,ComboCafe comBoBox) {
		this.comBoBox = comBoBox;
		setForeground(Color.WHITE);
		this.service = service;
		setLayout(new GridLayout(0, 1, 5, 5));
		
		pCode = new TextFieldCafe("제품코드");
		add(pCode);
		
		pName = new TextFieldCafe("제품명");
		add(pName);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(panel_2);
		panel_2.setLayout(new GridLayout(1, 1, 5, 5));
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		panel_2.add(btnAdd);
		
		btnDelete = new JButton("취소");
		btnDelete.addActionListener(this);
		panel_2.add(btnDelete);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}if (e.getSource() == btnDelete) {
			btnDeleteActionPerformed(e);
		}
	}
	private void btnDeleteActionPerformed(ActionEvent e) {
		clearTf();
		
	}

	protected void btnAddActionPerformed(ActionEvent e) {
		try {
			isEmpty();
			getTf();
			clearTf();
			comBoBox.setCodeModel();
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			
			return;
		}
	}

	@Override
	public void clearTf() {
		pCode.setTextField("");
		pName.setTextField("");
		
	}


	@Override
	public void isEmpty() throws Exception {
		pCode.emptyText();
		pName.emptyText();
		
	}

	@Override
	public void getTf() {
		String cofcode=pCode.getTextField();
		String cofname=pName.getTextField();
		int cost = 0;
		int salesnum =0;
		int margin = 0;
		service.insertCoffee(new Coffee(cofcode, cofname, cost, salesnum, margin));
		
	}
	
	
}
