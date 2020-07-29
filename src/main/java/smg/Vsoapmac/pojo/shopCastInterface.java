package smg.Vsoapmac.pojo;

import java.util.List;

import smg.Vsoapmac.pojo.DAO.bean.shopcast;

public interface shopCastInterface {
	
	/**
	 * 展示所有的购物车清单
	 * @return 带有购物车信息的list
	 */
	public List<shopcast> showCast();
	
	/**
	 * 通过id查找其中一项商品
	 * @param id
	 * @return 带有信息的shopcast对象
	 */
	public shopcast findOneById(int id);
	
}
