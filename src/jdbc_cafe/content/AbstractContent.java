package jdbc_cafe.content;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class AbstractContent extends JPanel {
	
	
	public abstract void clearTf();

	public abstract void isEmpty() throws Exception;

	public abstract void isMatch() throws Exception;
	
	public abstract void getTf();

}
