package smg.Vsoapmac.pojo.DAO.bean;

public class shopcast {
	private int id;
	private String name;
	private String place;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	@Override
	public String toString() {
		return "shopcast [id=" + id + ", name=" + name + ", place=" + place + "]";
	}
}
