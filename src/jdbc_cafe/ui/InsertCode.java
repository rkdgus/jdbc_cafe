package jdbc_cafe.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import jdbc_cafe.content.CafeContent;
import jdbc_cafe.service.CoffeeService;
import jdbc_cafe.content.CreateCoffee;

@SuppressWarnings("serial")
public class InsertCode extends JFrame {

	private JPanel contentPane;
	private CoffeeService service;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertCode frame = new InsertCode();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public InsertCode() {
		service = new CoffeeService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		CafeContent panel_1 = new CafeContent(service);
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedPane.addTab("금액입력", null, panel_1, null);
		
		CreateCoffee panel = new CreateCoffee(service);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedPane.addTab("코드생성", null, panel, null);
	}

}
