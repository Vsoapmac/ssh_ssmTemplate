package smg.Vsoapmac.bean;

public class city {
	private int ID;
	private String name;
	private String countryCode;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	@Override
	public String toString() {
		return "city [ID=" + ID + ", name=" + name + ", countryCode=" + countryCode + "]";
	}
}
