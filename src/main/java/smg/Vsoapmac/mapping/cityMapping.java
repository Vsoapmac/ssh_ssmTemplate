package smg.Vsoapmac.mapping;

import java.util.List;

import smg.Vsoapmac.springmvc.bean.city;

public interface cityMapping {
	public List<city> showallcity();
	public void addItem(city info);
	public city showcityByid(int id);
}
