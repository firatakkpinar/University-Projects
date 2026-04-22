
public abstract class WorkLoc extends Location{
	protected Customer customer;
	WorkLoc(Player player,String name,Customer customer) {
		super(player);
		this.customer = customer;
		this.name = name;
	}

	
	public boolean getLocation() {
		int cstCount = customer.count();
		System.out.println("Şuan buradasınız :"+this.getName());
		System.out.println("Burada "+cstCount+" tane "+customer.getName()+" var");
		System.out.print("<S>ipariş al veya <V>azgeç :");
		String selCase = scan.nextLine();
		selCase = selCase.toUpperCase();
		if(selCase.equals("S")) {
			if(combat(cstCount)) {
				System.out.println(this.getName()+" Lokasyonundaki tüm müşterilerin siparişleri tamamlandı");
				return true;
			}
			if(player.getHealthy()<=0) {
				System.out.println("Başarısız oldunuz !");
				return false;
			}
		}
		return true;
		
	}
	
	public boolean combat(int cstCount) {
		for(int i=0; i<cstCount; i++) {
			int defCstHealth = customer.getOrder();
			playerStats();
			customerStats();
			while(player.getHealthy()>0&& customer.getOrder()>0) {
			System.out.print("<D>evam et veya <V>azgeç :");
			String selCase = scan.nextLine();
			selCase = selCase.toUpperCase();
			if(selCase.equals("D")) {
				System.out.println("Siparişle ilgilendiniz");
				customer.setOrder(customer.getOrder()-player.getTotalworkforce());
				afterHit();
				if(customer.getOrder()>0) {
					System.out.println();
					System.out.println("Yoruldunuz !");
					player.setHealthy(player.getHealthy()-customer.getWorkforce());
					afterHit();
				}
				
			}else {
				return false;
			}
			}
		if(customer.getOrder()<=0 && player.getHealthy()>0) {
			System.out.println("Siparişi başarıyla tamamladınız !");
			player.setMoney(player.getMoney()+customer.getTip());
			System.out.println("Güncel paranız :"+player.getMoney());
			customer.setOrder(defCstHealth);
		}else {
			return false;
		}
		System.out.println("----------------------------------");
		}
		return true;
	}
	
	public void playerStats() {
		System.out.println("Oyuncu Değerleri\n-------------");
		System.out.println("Dayanıklılık:"+player.getHealthy());
		System.out.println("İş Gücü:"+player.getTotalworkforce());
		System.out.println("Para :"+player.getMoney());
		if(player.getInv().getIsgucu()>0) {
			System.out.println("Ekipman :"+player.getInv().getEquipment());
		}
	}
	
	public void customerStats() {
		System.out.println("\n"+customer.getName()+" Bilgileri\n-------------");
		System.out.println("Müşterinin isteyeceği sipariş yükü:"+customer.getOrder());
		System.out.println("Sizi yoracağı miktar:"+customer.getWorkforce());
		System.out.println("Size bırakacağı bahşiş :"+customer.getTip());
	}
	public void afterHit() {
		System.out.println("Oyuncu Dayanıklılığı :"+player.getHealthy());
		System.out.println("Kalan sipariş miktarı :"+customer.getOrder());
		System.out.println("");
	}
}
