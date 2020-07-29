package smg.Vsoapmac.pojo.DAO.bean;

public class anotherone {
	private int anr_id;
	private String anr_name;
	private one one;//设置一对一
	public int getAnr_id() {
		return anr_id;
	}
	public void setAnr_id(int anr_id) {
		this.anr_id = anr_id;
	}
	public String getAnr_name() {
		return anr_name;
	}
	public void setAnr_name(String anr_name) {
		this.anr_name = anr_name;
	}
	public one getOne() {
		return one;
	}
	public void setOne(one one) {
		this.one = one;
	}
	@Override
	public String toString() {
		return "anotherone [anr_id=" + anr_id + ", anr_name=" + anr_name + ", one=" + one + "]";
	}
	
}
