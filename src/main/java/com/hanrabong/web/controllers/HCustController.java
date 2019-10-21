package com.hanrabong.web.controllers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanrabong.web.domains.HCustDTO;
import com.hanrabong.web.seviceImpls.HCustServiceImpl;

@Controller
@RequestMapping("/hcust/*")
public class HCustController{
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired HCustServiceImpl hCustService;
	@Autowired Map<String, Object>map;
	@Autowired HCustDTO hcust;
	
	@PostMapping("/join")
	public @ResponseBody HCustDTO join(@RequestBody HCustDTO param) {
		logger.info("ajax가 보낸 아이디 {}", param.getCid() +","+ param.getCpw());
		
		int temp = hCustService.lastCNum();
		param.setCnum(String.valueOf(temp+1));
		hCustService.insertHCust(param);
		
		return hCustService.selectHCustByCNum(temp+1);
	}
	
	@PostMapping("/login")
	public @ResponseBody HCustDTO login(@RequestBody HCustDTO param) {
		logger.info("login>>>>ajax가 보낸 아이디 {}", param.getCid() +","+ param.getCpw());
		HCustDTO hcust = new HCustDTO();
		hcust = hCustService.login(param);

		return hcust;
	}
	
}
 