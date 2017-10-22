package jdbc_cafe.main;

import java.awt.EventQueue;

import jdbc_cafe.ui.InsertCoffeeFrame;

public class StartCoffee {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertCoffeeFrame frame = new InsertCoffeeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
