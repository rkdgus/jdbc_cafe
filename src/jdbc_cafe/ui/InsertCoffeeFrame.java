package jdbc_cafe.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import jdbc_cafe.content.CafeContent;
import jdbc_cafe.service.CoffeeService;

@SuppressWarnings("serial")
public class InsertCoffeeFrame extends JFrame {

	private JPanel contentPane;
	private CoffeeService service;
	private JMenuItem mntmAdd;
	private JMenuItem mntmDelete;
	private CafeContent panel;
	private JMenuItem mntmInsert;
	private InsertCodeFrame Finsert;

	
	

	
	public InsertCoffeeFrame() {
		setTitle("카페 관리 프로그램");
		service = new CoffeeService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 298, 352);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		mntmAdd = new JMenuItem("제품추가");
		mntmAdd.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				panel.clearTf();
				if(Finsert==null){
					Finsert = new InsertCodeFrame(panel.getComBoBox());
				}
				Finsert.setVisible(true);
				
				
			}
		});
		
		mnMenu.add(mntmAdd);
		
		mntmDelete = new JMenuItem("제품삭제");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.clearTf();
				panel.isEnable(false);
				panel.getBtnAdd().setText("삭제");
				
				
			}
			
		});
		
		mnMenu.add(mntmDelete);
		
		mntmInsert = new JMenuItem("금액입력");
		mntmInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.clearTf();
				panel.isEnable(true);
				panel.getBtnAdd().setText("입력");
			}
		});
		mnMenu.add(mntmInsert);
		
		panel = new CafeContent(service);
		contentPane.add(panel, BorderLayout.CENTER);
	}
	


}
