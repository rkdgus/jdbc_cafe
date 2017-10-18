package jdbc_cafe.list;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public abstract class TableList extends JPanel {
	private JTable table;

	
	public TableList() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}
	
	public void loadDataPrice() {
		DefaultTableModel model = new DefaultTableModel(getDataPrice(),getColumnNames());
		table.setModel(model);
		
	}
	

	
	public void loadDataMarginePrice() {
		DefaultTableModel model = new DefaultTableModel(getDataMarginPrice(),getColumnNames());
		table.setModel(model);
		
	}
	

	protected abstract Object[][] getDataPrice();
	
	protected abstract Object[] getColumnNames();
	
	protected abstract Object[][] getDataMarginPrice();
	
	

}
