package jdbc_cafe.list;

import java.util.List;

import jdbc_cafe.dto.Cafe;
import jdbc_cafe.service.CafeService;

@SuppressWarnings("serial")
public class CafeList extends TableList{
	private CafeService cafeService;

	public CafeList(CafeService cafeService) {
		this.cafeService = cafeService;
	}
	@Override
	protected Object[][] getDataPrice(){
		List<Cafe> lists = cafeService.selectAllPrice();
		Object[][] data = new Object[lists.size()][];
		for(int i=0;i<lists.size();i++){
			
			data[i] = lists.get(i).toArray();
		}
		return data;
	}
	@Override
	protected Object[] getColumnNames() {
		
		return new String[]{"제품코드","제품명","제품단가","판매수량","공급가액","부가세액","판매금액","마진율","마진액"};
	}
	
	

	@Override
	protected Object[][] getDataMarginPrice() {
		List<Cafe> lists = cafeService.selectAllMarginPrice();
		Object[][] data = new Object[lists.size()][];
		for(int i=0;i<lists.size();i++){
			
			data[i] = lists.get(i).toArray();
		}
		
		return data;
		
	}


	

	
	
	
}
