package smg.Vsoapmac.pojo.DAO.bean;

import java.util.HashSet;
import java.util.Set;

public class one {
	private int one_id;
	private String one_name;
	private Set<many> manyset = new HashSet<many>();//一方使用set装取多的一方
	private anotherone anr;//一对一
	public int getOne_id() {
		return one_id;
	}
	public void setOne_id(int one_id) {
		this.one_id = one_id;
	}
	public String getOne_name() {
		return one_name;
	}
	public void setOne_name(String one_name) {
		this.one_name = one_name;
	}
	public anotherone getAnr() {
		return anr;
	}
	public void setAnr(anotherone anr) {
		this.anr = anr;
	}
	public Set<many> getManyset() {
		return manyset;
	}
	public void setManyset(Set<many> manyset) {
		this.manyset = manyset;
	}
	@Override
	public String toString() {
		return "one [one_id=" + one_id + ", one_name=" + one_name + "]";
	}
}
