package jdbc_cafe.dto;

public class Cafe {
	private String crank; 
	private String cofcode; 
	private String cofname;
	private String cost;
	private String salesnum;
	private String supply;
	private String surtex;
	private String price;
	private String margin;
	private String marginprice;
	
	



public String getCrank() {
		return crank;
	}





	public void setCrank(String crank) {
		this.crank = crank;
	}





	public String getCofcode() {
		return cofcode;
	}





	public void setCofcode(String cofcode) {
		this.cofcode = cofcode;
	}





	public String getCofname() {
		return cofname;
	}





	public void setCofname(String cofname) {
		this.cofname = cofname;
	}





	public String getCost() {
		return cost;
	}





	public void setCost(String cost) {
		this.cost = cost;
	}





	public String getSalesnum() {
		return salesnum;
	}





	public void setSalesnum(String salesnum) {
		this.salesnum = salesnum;
	}





	public String getSupply() {
		return supply;
	}





	public void setSupply(String supply) {
		this.supply = supply;
	}





	public String getSurtex() {
		return surtex;
	}





	public void setSurtex(String surtex) {
		this.surtex = surtex;
	}





	public String getPrice() {
		return price;
	}





	public void setPrice(String price) {
		this.price = price;
	}





	public String getMargin() {
		return margin;
	}





	public void setMargin(String margin) {
		this.margin = margin;
	}





	public String getMarginprice() {
		return marginprice;
	}





	public void setMarginprice(String marginprice) {
		this.marginprice = marginprice;
	}





@Override
	public String toString() {
		return String.format(
				"CafeView [crank=%s, cofcode=%s, cofname=%s, cost=%s, salesnum=%s, supply=%s, surtex=%s, price=%s, margin=%s, marginprice=%s]",
				crank, cofcode, cofname, cost, salesnum, supply, surtex, price, margin, marginprice);
	}





public Cafe(String crank, String cofcode, String cofname, String cost, String salesnum, String supply,
			String surtex, String price, String margin, String marginprice) {
		this.crank = crank;
		this.cofcode = cofcode;
		this.cofname = cofname;
		this.cost = cost;
		this.salesnum = salesnum;
		this.supply = supply;
		this.surtex = surtex;
		this.price = price;
		this.margin = margin;
		this.marginprice = marginprice;
	}





public Cafe() {
		// TODO Auto-generated constructor stub
	}





public Object[] toArray() {
		
		
		return  new Object[]{crank,cofcode, cofname, cost, salesnum, supply, surtex, price, margin, marginprice};
	}
	
}