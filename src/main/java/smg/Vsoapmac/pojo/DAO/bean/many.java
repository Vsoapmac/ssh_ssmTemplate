package smg.Vsoapmac.pojo.DAO.bean;


public class many {
	private int many_id;
	private String many_name;
	private one one;//多的一方获取一的一方
	
	public int getMany_id() {
		return many_id;
	}

	public void setMany_id(int many_id) {
		this.many_id = many_id;
	}

	public String getMany_name() {
		return many_name;
	}

	public void setMany_name(String many_name) {
		this.many_name = many_name;
	}

	public one getOne() {
		return one;
	}

	public void setOne(one one) {
		this.one = one;
	}

	@Override
	public String toString() {
		return "many [many_id=" + many_id + ", many_name=" + many_name + "]";
	}

	
}
