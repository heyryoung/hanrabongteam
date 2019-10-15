package com.hanrabong.web.controllers;

import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.hanrabong.web.seviceImpls.HCustServiceImpl;

@Controller
public class HomeController {
    
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired HCustServiceImpl hCustService;
    
    @GetMapping("/")
    public String home(Locale locale, Model model) {
        logger.info("Welcome {}.", "HomeController");
        
        int count =hCustService.countHCusts();
        model.addAttribute("count", count );
        return "index";
    }
    
}
 