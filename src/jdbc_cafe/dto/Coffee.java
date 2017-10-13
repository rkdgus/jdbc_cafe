package jdbc_cafe.dto;

public class Coffee {
	 private String cofCode;
	 private String cofName;
	 private int price;
	 private int sales;
	 private int supply;
	 private int surtax;
	 private int exitValue;
	 private int margin;
	 private int marginpirce;
	 
	public Coffee(String cofCode, String cofName, int price, int sales, int supply, int surtax, int exitValue,
			int margin, int marginpirce) {
		this.cofCode = cofCode;
		this.cofName = cofName;
		this.price = price;
		this.sales = sales;
		this.supply = supply;
		this.surtax = surtax;
		this.exitValue = exitValue;
		this.margin = margin;
		this.marginpirce = marginpirce;
	}
	public Coffee() {
		// TODO Auto-generated constructor stub
	}
	public String getCofCode() {
		return cofCode;
	}
	public void setCofCode(String cofCode) {
		this.cofCode = cofCode;
	}
	public String getCofName() {
		return cofName;
	}
	public void setCofName(String cofName) {
		this.cofName = cofName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getSupply() {
		return supply;
	}
	public void setSupply(int supply) {
		this.supply = supply;
	}
	public int getSurtax() {
		return surtax;
	}
	public void setSurtax(int surtax) {
		this.surtax = surtax;
	}
	public int getExitValue() {
		return exitValue;
	}
	public void setExitValue(int exitValue) {
		this.exitValue = exitValue;
	}
	public int getMargin() {
		return margin;
	}
	public void setMargin(int margin) {
		this.margin = margin;
	}
	public int getMarginpirce() {
		return marginpirce;
	}
	public void setMarginpirce(int marginpirce) {
		this.marginpirce = marginpirce;
	}
	@Override
	public String toString() {
		return String.format(
				"Coffee [cofCode=%s, cofName=%s, price=%s, sales=%s, supply=%s, surtax=%s, exitValue=%s, margin=%s, marginpirce=%s]",
				cofCode, cofName, price, sales, supply, surtax, exitValue, margin, marginpirce);
	}
	 
	 
	 
}
