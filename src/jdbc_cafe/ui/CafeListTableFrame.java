package jdbc_cafe.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import jdbc_cafe.list.TableList;

@SuppressWarnings("serial")
public class CafeListTableFrame extends JFrame {

	private JPanel contentPane;

	public CafeListTableFrame(TableList tl1,TableList tl2) {
		setTitle("판매실적 조회");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		
			tl1.loadDataPrice();
		
			tl2.loadDataMarginePrice();
		

		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		
		JPanel panelS = tl1;
		tabbedPane.addTab("판매금액 순", panelS);
		JPanel panelM = tl2;
		tabbedPane.addTab("마진액 순", panelM);
		

	}

}
