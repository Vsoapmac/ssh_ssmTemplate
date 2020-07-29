package smg.Vsoapmac.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class cleanCastAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		Map<String, Object> map = ActionContext.getContext().getSession();
		map.clear();
		return super.execute();
	}
	
}
