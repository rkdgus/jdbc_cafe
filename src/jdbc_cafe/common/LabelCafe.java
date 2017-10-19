package jdbc_cafe.common;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class LabelCafe extends JPanel {

	private JLabel lblGetName;

	public LabelCafe(String str) {
		setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblName = new JLabel(str);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblName);

		lblGetName = new JLabel("제품코드 선택");
		add(lblGetName);

	}

	public void emptyText() throws Exception {
		if (getLabel().equals("제품코드 선택")) {
			throw new Exception("제품코드를 선택하세요");
		}
	}

	public String getLabel() {
		return lblGetName.getText();

	}

	public void setLabel(String t) {
		lblGetName.setText(t);
	}

}
