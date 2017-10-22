package jdbc_cafe.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc_cafe.content.InsertCoffee;
import jdbc_cafe.service.CoffeeService;

@SuppressWarnings("serial")
public class InsertCodeFrame extends JFrame {

	private JPanel contentPane;
	private CoffeeService service;


	
	public InsertCodeFrame() {
		setTitle("신제품 입력창");
		service = new CoffeeService();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 282, 173);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		InsertCoffee panel = new InsertCoffee(service);
		contentPane.add(panel, BorderLayout.CENTER);
	}

}
