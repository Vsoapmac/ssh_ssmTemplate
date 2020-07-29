package smg.Vsoapmac.controllerObj;

import java.util.List;

import smg.Vsoapmac.springmvc.bean.city;

public class QueryVo {
	private List<city> list;
	private Integer[] ids;
	private String text;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<city> getList() {
		return list;
	}
	public void setList(List<city> list) {
		this.list = list;
	}
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
}
