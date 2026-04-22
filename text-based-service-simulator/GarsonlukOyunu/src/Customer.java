import java.util.Random;
public class Customer {
	private String name;
	private int workforce,tip,order,maxNumber;
	public Customer(String name, int workforce, int order, int tip, int maxNumber) {
		this.name = name;
		this.workforce = workforce;
		this.tip = tip;
		this.order = order;
		this.maxNumber = maxNumber;
	}
	
	
	public int count() {
		Random r = new Random();
		return r.nextInt(this.maxNumber)+1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWorkforce() {
		return workforce;
	}
	public void setWorkforce(int workforce) {
		this.workforce = workforce;
	}
	public int getTip() {
		return tip;
	}
	public void setTip(int tip) {
		this.tip = tip;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getMaxNumber() {
		return maxNumber;
	}
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	
	
}
