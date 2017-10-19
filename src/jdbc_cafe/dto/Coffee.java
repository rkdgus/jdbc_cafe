package jdbc_cafe.dto;

public class Coffee {
	private String cofcode;
	private String cofname;
	private int cost;
	private int salesnum;
	private int margin;

	public Coffee() {
		// TODO Auto-generated constructor stub
	}

	public Coffee(String cofcode, String cofname, int cost, int salesnum, int margin) {
		this.cofcode = cofcode;
		this.cofname = cofname;
		this.cost = cost;
		this.salesnum = salesnum;
		this.margin = margin;
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

	public int getMargin() {
		return margin;
	}

	public void setMargin(int margin) {
		this.margin = margin;
	}

	@Override
	public String toString() {
		return String.format("%s", cofcode);
	}

	public String toArray() {

		return String.format("%s", cofcode);
	}

}
