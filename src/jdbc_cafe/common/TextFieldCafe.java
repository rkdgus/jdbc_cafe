package jdbc_cafe.common;

import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		add(textField);
		textField.setColumns(10);
		
		
	}
	
	public void emptyText() throws Exception{
			if( getTextField().equals("")){
				textField.requestFocus();
				throw new Exception("공백존재");
			}
	}
	public void setTextField(String t){
		textField.setText(t);
	}
	public String getTextField() {
		
		return textField.getText().trim();
	}
	


}
