import java.util.Scanner;

public class Player {
	private int workforce,healthy,money,rHealthy;
	private String name,cName;
	private Inventory inv;
	Scanner scan = new Scanner(System.in);
	
	public Player(String name) {
		this.name = name;
		this.inv = new Inventory();
	}
	
	public void selectCha() {
		switch(chaMenu()) {
		case 1:
			initPlayer("Komi", 5 , 21, 15);
			break;
		case 2:
			initPlayer("Garson", 7 , 18 , 20);
			break;
		case 3:
			initPlayer("Şef Garson", 8 , 24, 5);
			break;
			default:
				initPlayer("Komi", 5 , 21, 15);
			break;
		}
		System.out.println("Karakteriniz :"+getcName() +"\t İşgücü:"+getWorkforce()+"\t Dayanıklılık: "+getHealthy()+"\t Para:"+getMoney() );
	}
	
	public int chaMenu() {
		System.out.println("Lütfen bir karakter seçiniz : ");
		System.out.println("1- Komi \t İşgücü:5 \t Dayanıklılık:21 \t Para:15");
		System.out.println("2- Garson \t İşgücü:7 \t Dayanıklılık:18 \t Para:20");
		System.out.println("3- Şef Garson \t İşgücü:8 \t Dayanıklılık:24 \t Para:5");
		System.out.print("Karakter Seçiminiz :");
		int chaID = scan.nextInt();
		
		while(chaID <1 || chaID >3) {
			System.out.print("Lütfen geçerli bir karakter seçiniz!");
			chaID = scan.nextInt();
		}
		
		return chaID;
		
			}
	
	public int getTotalworkforce() {
		return this.getWorkforce() + this.getInv().getIsgucu();
	}
	
	public void initPlayer(String cName,int wforce,int hlthy,int mny) {
		setcName(cName);
		setWorkforce(wforce);
		setHealthy(hlthy);
		setMoney(mny);
		setrHealthy(hlthy);
	}
	
	public int getWorkforce() {
		return workforce;
	}
	public void setWorkforce(int workforce) {
		this.workforce = workforce;
	}
	public int getHealthy() {
		return healthy;
	}
	public void setHealthy(int healthy) {
		this.healthy = healthy;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Inventory getInv() {
		return inv;
	}
	public void setInv(Inventory inv) {
		this.inv = inv;
	}

	public int getrHealthy() {
		return rHealthy;
	}

	public void setrHealthy(int rHealthy) {
		this.rHealthy = rHealthy;
	}
	
	

}
