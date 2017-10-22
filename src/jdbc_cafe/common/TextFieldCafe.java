package jdbc_cafe.common;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TextFieldCafe extends JPanel {
	private JTextField textField;

	public TextFieldCafe(String str) {
		setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lbl = new JLabel(str);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl);

		textField = new JTextField();

		add(textField);
		textField.setColumns(10);

	}

	public void emptyText() throws Exception {
		if (getTextField().equals("")) {
			textField.requestFocus();
			throw new Exception("빈 칸 없이 입력하세요");
		}
	}

	public void setTextField(String t) {
		textField.setText(t);
	}

	public JTextField textField() {
		return textField;
	}

	public String getTextField() {

		return textField.getText().trim();
	}
}
