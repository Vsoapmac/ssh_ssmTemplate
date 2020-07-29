package smg.Vsoapmac.pojo;

import java.util.List;

import smg.Vsoapmac.pojo.DAO.bean.one;

public interface oneInterface {
	public List<one> show();
	
	public one findById(int id);
}
