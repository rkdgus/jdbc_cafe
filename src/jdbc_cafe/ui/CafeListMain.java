package jdbc_cafe.ui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import jdbc_cafe.list.TableList;

public class CafeListMain extends JFrame {

	private JPanel contentPane;

	
	

	
	public CafeListMain(TableList tl,String str) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel(str);
		lblNewLabel.setFont(new Font("돋움", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		if(str.equals("판매금액순위")){
			tl.loadDataPrice();
		}else{
			tl.loadDataMarginePrice();
		}
		
		contentPane.add(tl, BorderLayout.CENTER);
		
		
	}

}
