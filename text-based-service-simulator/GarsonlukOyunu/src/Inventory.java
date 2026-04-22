
public class Inventory {
	private String equipment;
	private int isgucu;
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public int getIsgucu() {
		return isgucu;
	}
	public void setIsgucu(int isgucu) {
		this.isgucu = isgucu;
	}
	Inventory() {
		this.isgucu = 0;
		this.equipment = null;
	}
}
