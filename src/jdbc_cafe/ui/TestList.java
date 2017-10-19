package jdbc_cafe.ui;

import javax.swing.JFrame;

import jdbc_cafe.list.CafeList;
import jdbc_cafe.list.TableList;
import jdbc_cafe.service.CafeService;

public class TestList {
	public static void main(String[] args) {
		TestList(new CafeList(new CafeService()));
	}

	private static void TestList(TableList table) {
		JFrame jf = new JFrame();

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBounds(300, 300, 600, 450);

		table.loadDataMarginePrice();
		jf.add(table);

		jf.setVisible(true);

	}

}
