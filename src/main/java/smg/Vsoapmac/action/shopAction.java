package smg.Vsoapmac.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.LinkedHashMap;
import java.util.Map;

public class shopAction extends ActionSupport{

	private int id;
//	private shopCastInterface sc;
	
	@Override
	public String execute() throws Exception {
//		/* 从sping容器中获取impl，用接口映射 */
//		sc = (shopCastInterface) springUtls.getBean("shopCastImpl");
//		/* 找到其中一个购物车 */
//		shopcast shopcast = sc.findOneById(id);
		
		/*
		 * 利用ActionCotext的getsession获取session
		 * Map<String, Object> map = ActionContext.getContext().getSession();的意思就是
		 * session.setAttribute(name, value);
		 * name = String
		 * value = Object;
		 * map.put(name , value)
		 */
		Map<String, Object> sessionScope = ActionContext.getContext().getSession();
		
		/* 先取sessionScope的session */
		Map<Integer , Integer> map = (LinkedHashMap)sessionScope.get("sessionScope");
		
		/* 万一用户没有添加购物车，就要使用一个新的map */
		if(map == null) {
			map = new LinkedHashMap<Integer, Integer>();
		}
		/*
		 * map是一个链式线性表
		 * 判断是否包含这个key
		 * 是，数量加一
		 * 不是，把这个key添加进去
		 * 这样就可以保存数据了
		 */
		if(map.containsKey(id)) {
			int i = map.get(id);
			map.remove(id);//记得移除，要不然就会保留原来的数据
			map.put(id, i+1);
		}else {
			map.put(id, 1);
		}
		
		/* 将map存到session里面去 */
		sessionScope.put("sessionScope", map);
		return SUCCESS;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
