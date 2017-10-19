package jdbc_cafe.list;

import java.util.List;

import javax.swing.SwingConstants;

import jdbc_cafe.dto.Cafe;
import jdbc_cafe.service.CafeService;

@SuppressWarnings("serial")
public class CafeList extends TableList {
	private CafeService cafeService;

	public CafeList(CafeService cafeService) {
		this.cafeService = cafeService;
	}

	@Override
	protected Object[][] getDataPrice() {
		List<Cafe> lists = cafeService.selectAllPrice();
		Object[][] data = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {
			if(i==lists.size()-1){
				data[i] = lists.get(i).toArrayByLast();
			}else{
				data[i] = lists.get(i).toArray();
			}
			
			
		}
		return data;
	}

	@Override
	protected Object[] getColumnNames() {

		return new String[] { "순위", "제품코드", "제품명", "제품단가", "판매수량", "공급가액", "부가세액", "판매금액", "마진율", "마진액" };
	}

	@Override
	protected Object[][] getDataMarginPrice() {
		List<Cafe> lists = cafeService.selectAllMarginPrice();
		Object[][] data = new Object[lists.size()][];
		for (int i = 0; i < lists.size(); i++) {

			data[i] = lists.get(i).toArray();
		}

		return data;

	}

	@Override
	protected void setAlignWidth() {
		setAlign(SwingConstants.CENTER, 0,1,2,8);
		setAlign(SwingConstants.RIGHT, 3,4,5,6,7,9);
		setCellWidth(50,80,100,80,80,150,100,150,50,100);
		
	}

}
