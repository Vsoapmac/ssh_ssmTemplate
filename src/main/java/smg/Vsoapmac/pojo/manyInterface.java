package smg.Vsoapmac.pojo;

import java.util.List;

import smg.Vsoapmac.pojo.DAO.bean.many;

public interface manyInterface {
	
	/* 多对一保存 */
	public void save(many info,int one_id);
	
	/* 多对一的查询 */
	public List<many> show();
}
