package smg.Vsoapmac.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import smg.Vsoapmac.springmvc.bean.city;
import smg.Vsoapmac.springmvc.mapping.cityMapping;
import smg.Vsoapmac.springmvc.service.cityService;

@Service("cityServiceImpl")
public class cityServiceImpl implements cityService {

	@Autowired
	private cityMapping cityMapping;
	
	@Override
	public List<city> findAllcity() {
		return cityMapping.showallcity();
	}

	@Override
	public city findById(int id) {
		return cityMapping.showcityByid(id);
	}

	@Override
	public List<city> findlimit(int page, int show) {
		return null;
	}

}
