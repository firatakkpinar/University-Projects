
public class House extends NormalLoc {

	House(Player player) {
		super(player,"Ev");
	}
	
	public boolean getLocation() {
		player.setHealthy(player.getrHealthy());
		System.out.println("Dinlendiniz!");
		System.out.println("Şuan Evinizdesiniz");
		return true;
	}

}
