
public class EquipmentStore extends NormalLoc {

	EquipmentStore(Player player) {
		super(player, "Mağaza");
	}

	public boolean getLocation() {
		System.out.println("Para : "+ player.getMoney());
		System.out.println("1. Ekipmanlar");
		System.out.println("2. Çıkış");
		System.out.print("Seçiminiz :");
		int selEquipment = scan.nextInt();
		int selItemID;
		switch (selEquipment) {
		case 1:
			selItemID = equipmentMenu();
			buyEquipment(selItemID);
			break;
		case 2:
			break;
			default:
				break;
		}
		return true;
	}
	
	public int equipmentMenu() {
		System.out.println("1. Tepsi--Para:25 - İşgücü+2");
		System.out.println("2. Büyük Tepsi--Para:35 - İşgücü+3");
		System.out.println("3. Yardımcı Personel--Para:45 - İşgücü+7");
		System.out.println("4. Çıkış");
		System.out.print("Ekipman Seçiniz");
		int selEquipmentID = scan.nextInt();
		return selEquipmentID;
		
	}
	
	public void buyEquipment(int itemID) {
		int workforce=0,price=0;
		String equipmentName=null;
		switch(itemID) {
		case 1:
			workforce = 2;
			equipmentName = "Tepsi";
			price = 25;
					break;
		case 2:
			workforce = 3;
			equipmentName = "Büyük Tepsi";
			price = 35;
			break;
		case 3:
			workforce = 7;
			equipmentName ="Yardımcı Personel";
			price = 45;
			break;
		case 4:
			System.out.println("Çıkış Yapılıyor");
			default:
				System.out.println("Geçersiz İşlem !");
				break;
		}
		
		if(price > 0 ) {
			if(player.getMoney()>=price) {
				player.getInv().setIsgucu(workforce);
				player.getInv().setEquipment(equipmentName);
				player.setMoney(player.getMoney()-price);
				System.out.println("Ekipmanı satın aldınız,Önceki İşgücü:"+player.getWorkforce()+",Yeni İşgücünüz :"+player.getTotalworkforce());
				System.out.println("Kalan Para : "+ player.getMoney());
			}else {
				System.out.println("Paranız Yetersiz !");
			}
			
		}
		
	}
}
