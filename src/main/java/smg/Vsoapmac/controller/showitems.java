package smg.Vsoapmac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import smg.Vsoapmac.springmvc.service.cityService;
import smg.Vsoapmac.springmvc.controllerObj.QueryVo;
import smg.Vsoapmac.springmvc.bean.city;

@Controller
public class showitems {

	@Autowired
	@Qualifier("cityServiceImpl")
	private cityService service;
	
	public ModelAndView showitemtest01() {
		List<city> list = service.findAllcity();

		System.out.println(list.size());
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);

		mav.setViewName("index.jsp");
		return mav;
	}

	/**
	 * 1.ModelAndView 无敌的 带着数据 返回视图路径 不建议使用
	 *  2.String 返回视图路径 model带数据 官方推荐此种方式 解耦 数据 视图 分离 MVC 建议使用 
	 * 3.void ajax 请求 合适 json格式数据 （response 异步请求使用
	 */
	@RequestMapping(value = "/index")
	public String showitem(Model model) {
		List<city> list = service.findAllcity();

		System.out.println(list.size());
		model.addAttribute("list", list);
		return "index";
	}
	
	/**
	 * 不能用形参传List的值
	 * 要用对象包装
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/updates")
	public String updateItem(QueryVo vo) {
		Integer[] ids = vo.getIds();
		List<city> list = vo.getList();
		System.out.println(ids.length);
		System.out.println(list.size());
		return "index";
	}
}
