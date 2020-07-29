package smg.Vsoapmac.Utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class springUtls {
	/**
	 * 简化操作，不需要重复加载xml
	 * @param beanName spring中的bean的名字
	 * @return 放回的bean的类
	 */
	public static Object getBean(String beanName) {
		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("applicationContext.xml");
		return cpx.getBean(beanName);
	}
}
