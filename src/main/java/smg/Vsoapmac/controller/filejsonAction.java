package smg.Vsoapmac.controller;

import net.sf.json.JSONObject;
import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import smg.Vsoapmac.controllerObj.QueryVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class filejsonAction {
	
	/* 基于ResponseEntity实现springmvc的文件下载 */
	@RequestMapping(value = "/download")
	public ResponseEntity<byte[]> download(HttpServletRequest request , HttpServletResponse response) throws Exception {
		/* 获取项目真实路径 */
		String realPath = request.getRealPath("/download");
		
		File file = new File(realPath + "/123.jpg");//获取文件
		
		/* 将文件存到数据流里面 */
	    byte[] body = null;
	    InputStream is = new FileInputStream(file);
	    body = new byte[is.available()];
	    is.read(body);
	    
	    /* 设置请求头，设置为文件下载 */
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Disposition", "attchement;filename=" + file.getName());
	    /* 设置下载的status */
	    HttpStatus statusCode = HttpStatus.OK;
	    
	    /* 将数据流（byte），请求头 ，status（HttpStatus）存储到ResponseEntity */
	    ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
	    return entity;
	}
	
	@RequestMapping(value = "/pic")
	public String pic(MultipartFile picfile , Model model , HttpServletRequest request) throws Exception {
		/* 获取项目真实路径 */
		String realPath = request.getRealPath("/img/pic/");
	
		String filename = UUID.randomUUID().toString().replaceAll("-", "");//更改图片的名字为随机的字符串，把所有的-去掉
		
		String extendsion = FilenameUtils.getExtension(picfile.getOriginalFilename());//获取传送过来的文件名字，并提取出后缀
		
		String picfilename = realPath + filename + "." + extendsion;
		System.out.println(picfilename);
		File file = new File(picfilename);
		picfile.transferTo(file);;//存储到服务器上
		
		System.out.println("成功绑定到服务器上");
		return "redirect:index2.jsp";
	}
	
	/**
	 * json解析(后台)
	 * 必须添加@ResponseBody
	 * 传过来的数据用对象封装
	 */
	@RequestMapping(value = "/json")
	public @ResponseBody String json(@RequestBody QueryVo vo) {
		System.out.println("这是我从AJAX传过来的数据"+vo.getText());
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("name", "斗地主");
		jsonObject.put("status", "success");
		return jsonObject.toString();
	}
}
