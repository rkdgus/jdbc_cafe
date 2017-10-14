package jdbc_cafe.dto;

public class Cafe {
	private String cofcode; 
	private String cofname;
	private int cost;
	private int salesnum;
	private int supply;
	private int surtex;
	private int price;
	private int margin;
	private int marginprice;
	
	public Cafe() {
		// TODO Auto-generated constructor stub
	}

	public Cafe(String cofcode, String cofname, int cost, int salesnum, int supply, int surtex, int price, int margin,
			int marginprice) {
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getSalesnum() {
		return salesnum;
	}

	public void setSalesnum(int salesnum) {
		this.salesnum = salesnum;
	}

	public int getSupply() {
		return supply;
	}

	public void setSupply(int supply) {
		this.supply = supply;
	}

	public int getSurtex() {
		return surtex;
	}

	public void setSurtex(int surtex) {
		this.surtex = surtex;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getMargin() {
		return margin;
	}

	public void setMargin(int margin) {
		this.margin = margin;
	}

	public int getMarginprice() {
		return marginprice;
	}

	public void setMarginprice(int marginprice) {
		this.marginprice = marginprice;
	}

	@Override
	public String toString() {
		return String.format(
				"%s, %s, %s, %s, %s, %s, %s, %s, %s",
				cofcode, cofname, cost, salesnum, supply, surtex, price, margin, marginprice);
	}
	
	
}
