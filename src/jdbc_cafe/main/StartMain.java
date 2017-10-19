package jdbc_cafe.main;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import jdbc_cafe.ui.CoffeeUi;

public class StartMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeUi frame = new CoffeeUi();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());

				}
			}
		});
	}
}
