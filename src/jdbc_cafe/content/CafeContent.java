package jdbc_cafe.content;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import jdbc_cafe.common.ComboCafe;
import jdbc_cafe.common.LabelCafe;
import jdbc_cafe.common.TextFieldCafe;
import jdbc_cafe.dto.Coffee;
import jdbc_cafe.list.CafeList;
import jdbc_cafe.service.CafeService;
import jdbc_cafe.service.CoffeeService;
import jdbc_cafe.ui.CafeListMain;

@SuppressWarnings("serial")
public class CafeContent extends JPanel implements ActionListener {
	private TextFieldCafe pCost;
	private TextFieldCafe pSalesNum;
	private TextFieldCafe pMargin;
	private LabelCafe lblName;
	private ComboCafe comBoBox;
	private CoffeeService service;
	private JPanel panel;
	private JButton btnAdd;
	private JButton btnView1;
	private JButton btnView2;
	private CafeListMain listMain;

	public CafeContent(CoffeeService service) {
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

		lblName = new LabelCafe("제품명");
		add(lblName);
		lblName.setLayout(new GridLayout(0, 2, 0, 0));

		pCost = new TextFieldCafe("제품단가");
		add(pCost);

		pSalesNum = new TextFieldCafe("판매수량");
		add(pSalesNum);

		pMargin = new TextFieldCafe("마 진 율");
		add(pMargin);
		
		panel = new JPanel();
		add(panel);
		
		btnAdd = new JButton("입력");
		btnAdd.addActionListener(this);
		panel.setLayout(new GridLayout(0, 3, 5, 10));
		panel.add(btnAdd);
		
		btnView1 = new JButton("판매금액 순");
		btnView1.addActionListener(this);
		panel.add(btnView1);
		
		btnView2 = new JButton("마진액 순");
		btnView2.addActionListener(this);
		panel.add(btnView2);

		setCodeModel();

	}

	private void selectCoffeeName() {
		Coffee code = comBoBox.getComboboxValue();
		// String code ="A001";

		lblName.setLabel(service.selectCodeName(code).getCofname());

	}

	private void setCodeModel() {
		List<Coffee> lists = service.selectAll();
		Vector<Coffee> coffee = new Vector<>(lists);

		comBoBox.setComboboxModel(coffee);
	}

	public void getTf() {
		Coffee coffee = (Coffee) comBoBox.getComboboxValue();
		String cofname = lblName.getLabel();
		int cost = Integer.parseInt(pCost.getTextField());
		int salesnum = Integer.parseInt(pSalesNum.getTextField());
		int margin = Integer.parseInt(pMargin.getTextField());

		service.updateCoffee(new Coffee(coffee.getCofcode(), cofname, cost, salesnum, margin));
	}

	public void isEmpty() throws Exception {
		lblName.emptyText();
		pCost.emptyText();
		pSalesNum.emptyText();
		pMargin.emptyText();
	}

	public void isMatch() throws Exception {
		Pattern p = Pattern.compile("^[0-9]{1,8}$");
		Matcher m = p.matcher(pCost.getTextField());

		if (!m.find()) {

			throw new Exception("[제품단가]에 정수 1~8자리를 입력하세요");
		}

		m = p.matcher(pSalesNum.getTextField());

		if (!m.find()) {

			throw new Exception("[판매수량]에 정수 1~8자리를 입력하세요");
		}
		p = Pattern.compile("^[0-9]{1,2}$");
		m = p.matcher(pMargin.getTextField());

		if (!m.find()) {
			throw new Exception("[마진율]에 정수 1~2자리를 입력하세요");
		}
	}

	public void clearTf() {
		comBoBox.setSelected();
		lblName.setLabel("");
		pCost.setTextField("");
		pSalesNum.setTextField("");
		pMargin.setTextField("");
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			btnAddActionPerformed(e);
		}
		if (e.getSource() == btnView2) {
			btnView2ActionPerformed(e);
		}
		if (e.getSource() == btnView1) {
			btnView1ActionPerformed(e);
		}
	}
	
	
	private void btnAddActionPerformed(ActionEvent e) {
		try {
			isEmpty();
			isMatch();
			getTf();
			clearTf();

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			return;
		}

	}

	protected void btnView1ActionPerformed(ActionEvent e) {

		listMain = new CafeListMain(new CafeList(new CafeService()), "판매금액순위");

		listMain.setVisible(true);
	}

	protected void btnView2ActionPerformed(ActionEvent e) {

		listMain = new CafeListMain(new CafeList(new CafeService()), "마진액순위");

		listMain.setVisible(true);
	}
}
