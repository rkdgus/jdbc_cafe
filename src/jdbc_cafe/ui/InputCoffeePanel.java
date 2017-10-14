package jdbc_cafe.ui;

import javax.swing.JPanel;
import jdbc_cafe.common.TextFieldCafe;
import java.awt.GridLayout;

public class InputCoffeePanel extends JPanel {
	private TextFieldCafe pCode;
	private TextFieldCafe pCost;
	private TextFieldCafe pSalesNum;
	private TextFieldCafe pMargin;
	private TextFieldCafe panel;

	/**
	 * Create the panel.
	 */
	public InputCoffeePanel() {
		setLayout(new GridLayout(0, 1, 5, 5));
		
		pCode = new TextFieldCafe("제품코드");
		add(pCode);
		
		panel = new TextFieldCafe("제품명");
		panel.setEnabled(false);
		add(panel);
		
		pCost = new TextFieldCafe("판매수량");
		add(pCost);
		
		pSalesNum = new TextFieldCafe("판매수량");
		add(pSalesNum);
		
		pMargin = new TextFieldCafe("마 진 율");
		add(pMargin);

	}
	
	

}
