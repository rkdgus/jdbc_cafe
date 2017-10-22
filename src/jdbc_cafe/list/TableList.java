package jdbc_cafe.list;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public abstract class TableList extends JPanel {
	private JTable table;

	public TableList(String str) {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 0, 5, 0));
		add(panel, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel(str);
		lblTitle.setFont(new Font("굴림", Font.BOLD, 24));
		panel.add(lblTitle);

	}

	public void loadDataPrice() {
		DefaultTableModel model = new DefaultTableModel(getDataPrice(), getColumnNames());
		table.setModel(model);
		setAlignWidth();

	}

	public void loadDataMarginePrice() {
		DefaultTableModel model = new DefaultTableModel(getDataMarginPrice(), getColumnNames());
		table.setModel(model);
		setAlignWidth();

	}

	protected void setCellWidth(int...width) {
		TableColumnModel cModel = table.getColumnModel();
		for(int i=0;i<width.length;i++){
			cModel.getColumn(i).setPreferredWidth(width[i]);//비율
		}
	
	
	}


	protected void setAlign(int align,int...idx) {
		//0번 컬럼을 정렬 (left,right,center)
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		TableColumnModel cModel = table.getColumnModel();
		
		for(int i=0;i<idx.length;i++){
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
	
		
	protected abstract void setAlignWidth();
	
	protected abstract Object[][] getDataPrice();

	protected abstract Object[] getColumnNames();

	protected abstract Object[][] getDataMarginPrice();

}
