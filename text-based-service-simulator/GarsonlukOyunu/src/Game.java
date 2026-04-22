import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);
	
	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Garsonluk Oyununa Hoşgeldiniz !");
		System.out.print("Oyuna başlamadan önce isminizi giriniz : ");
		String playerName = scan.nextLine();
		player = new Player(playerName);
		player.selectCha();
		start();
	}
	
	public void start() {
		while(true) {
			System.out.println();
			System.out.println("==================");
			System.out.println();
			System.out.println("Eylem gerçekleştirmek için bir yer seçiniz");
			System.out.println("1. Ev --> Dinlenmeniz için size ait bir mekan");
			System.out.println("2. Pastane --> Fazla iş yoktur");
			System.out.println("3. Lokanta --> Orta derecede iş yükü");
			System.out.println("4. Restaurant --> Çok fazla iş yükü yoğun bir mekan");
			System.out.println("5. Mağaza --> Buradan ekipman alabilirsiniz");
			System.out.print("Gitmek istediğiniz yer:");
			int selLoc = scan.nextInt();
			while (selLoc <0 || selLoc >5) {
				System.out.println("Lütfen geçerli bir yer seçiniz!");
				selLoc = scan.nextInt();
			}
			
			switch(selLoc) {
			case 1:
				location = new House(player);
				break;
			case 2:
				location = new Pastane(player);
				break;
			case 3:
				location = new Lokanta(player);
				break;
			case 4:
				location = new Restaurant(player);
				break;
			case 5:
				location = new EquipmentStore(player);
				break;
				default:
					location = new House(player);
			}
			
			if(!location.getLocation()) {
				System.out.println("Oyun Bitti !");
				break;
			}
		}
		
		
	}
}
