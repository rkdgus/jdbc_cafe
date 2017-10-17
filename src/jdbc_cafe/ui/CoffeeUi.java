package jdbc_cafe.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc_cafe.service.CoffeeService;

@SuppressWarnings("serial")
public class CoffeeUi extends JFrame {

	private JPanel contentPane;
	private CoffeeService service;
	private InputCoffeePanel iputCoffeepanel;

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
		
		JPanel pBtn = new JPanel();
		FlowLayout fl_pBtn = (FlowLayout) pBtn.getLayout();
		fl_pBtn.setHgap(10);
		contentPane.add(pBtn, BorderLayout.SOUTH);
		
<<<<<<< HEAD
=======
		iputCoffeepanel = new InputCoffeePanel(service);
		contentPane.add(iputCoffeepanel, BorderLayout.CENTER);
		
		JButton btnAdd = new JButton("입력");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iputCoffeepanel.getTf();
				iputCoffeepanel.clearTf();
			}
		});
		
	
		pBtn.add(btnAdd);
		
		JButton btnView1 = new JButton("출력1");
		
		pBtn.add(btnView1);
		
		JButton btnView2 = new JButton("출력2");
		
		pBtn.add(btnView2);
		
		
		
>>>>>>> branch 'master' of https://github.com/rkdgus/jdbc_cafe.git
		
		
		
	}
	
	

}
