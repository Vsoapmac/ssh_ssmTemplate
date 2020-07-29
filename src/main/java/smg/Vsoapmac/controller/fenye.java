package smg.Vsoapmac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class fenye {
	@RequestMapping(value="/fenye.action")
	public ModelAndView execute() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("fenye.jsp");
		return mav;
	}
}
