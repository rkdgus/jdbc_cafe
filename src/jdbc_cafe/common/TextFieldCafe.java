package jdbc_cafe.common;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TextFieldCafe extends JPanel {
	private JTextField textField;


	public TextFieldCafe(String str) {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel	lbl = new JLabel(str);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);

	}
	
	public void emptyText(){
		if(getTextField().equals("")){
			
		}
	}
	public void setTextField(String t){
		textField.setText(t);
	}
	private Object getTextField() {
		
		return textField.getText().trim();
	}

}
