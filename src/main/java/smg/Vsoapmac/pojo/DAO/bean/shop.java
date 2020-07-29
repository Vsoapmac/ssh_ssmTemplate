package smg.Vsoapmac.pojo.DAO.bean;

public class shop {
	private int id;
	private String name;
	private String supplier;
	private String supplierid;
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
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}
	@Override
	public String toString() {
		return "shop [id=" + id + ", name=" + name + ", supplier=" + supplier + ", supplierid=" + supplierid + "]";
	}
}
