package com.hanrabong.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanrabong.web.seviceImpls.HCustServiceImpl;

@Controller
@RequestMapping("/hcust/*")
public class HCustController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired HCustServiceImpl hCustService;

	@GetMapping("/count")
	public String count (Model model) {
		int count = hCustService.countHCusts();
		model.addAttribute("count", count);
		return "index";
	}
	
	@GetMapping("/info")
	public String findHCustByCNum(@RequestParam("cnum")  String cnum, 
			@RequestParam("cpw") String pwd) {
		
		return "index";
    }
	
}
 