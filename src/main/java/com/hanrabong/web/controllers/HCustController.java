package com.hanrabong.web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanrabong.web.domains.HCustDTO;
import com.hanrabong.web.seviceImpls.HCustServiceImpl;

@Controller
@RequestMapping("/hcust/*")
public class HCustController{
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired Map<String, Object>map;
	@Autowired HCustDTO hcust;
	
	@PostMapping("/join")
	public @ResponseBody Map<?,?> join(@RequestBody HCustDTO hcust) {
		logger.info("ajax가 보낸 아이디 {}", hcust.getCid() +","+ hcust.getCpw());
		HashMap<String,String> map= new HashMap<>();
		map.put("cid",  "ser"+hcust.getCid());
		map.put("cpw", hcust.getCpw());
		logger.info("map에 담긴 아이디와 비번 {}", map.get("cid") +","+ map.get("cpw"));
		return map;
	}
	
	@PostMapping("/login")
	public @ResponseBody HCustDTO login(@RequestBody HCustDTO param) {
		logger.info("login>>>>ajax가 보낸 아이디 {}", param.getCid() +","+ param.getCpw());
		hcust.setCid(param.getCid());
		hcust.setCpw(param.getCpw());
		logger.info("login>>>>map에 담긴 아이디와 비번 {}", hcust.getCid()+","+ hcust.getCpw());
		return hcust;
	}
	
}
 