package jdbc_cafe.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc_cafe.service.CoffeeService;

@SuppressWarnings("serial")
public class CoffeeUi extends JFrame {

	private JPanel contentPane;
	private CoffeeService service;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeUi frame = new CoffeeUi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CoffeeUi() {
		service = new CoffeeService();
		setTitle("판매실적 입력창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 268, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		InputCoffeePanel panel = new InputCoffeePanel(service);
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 10, 10));
		
		
		
		
	}
	
	

}
