package com.plantlink.controller;

/*
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.plantlink.builder.CodeGenerator;
import com.plantlink.builder.SensorCode;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class TestController {
	@RequestMapping("/")
	public String test() {
		return "test";
	}
	
	@RequestMapping("/dashboard")
	public ModelAndView viewDashboard() {
		List<String> strings = new ArrayList<String>();
		
		strings.add("hii");
		strings.add("hii");
		strings.add("hii");
		strings.add("hii");
		strings.add("hii");
		
		
		ModelAndView mv = new ModelAndView("DashboardView");
		
		mv.addObject("strings", strings);
		
		return mv;
	}
	
	@RequestMapping("/create")
	public ModelAndView displayChannelForm() {
		
		ModelAndView mv = new ModelAndView("CreateChannelView");
		
		return mv;
	}
	
	@RequestMapping("/register")
	public ModelAndView displayRegisterSensorView() {
	    
	    
		ModelAndView mv = new ModelAndView("RegisterSensorView");
		
		
		return mv;
	}
	
	@RequestMapping(value="/displaycode", method=RequestMethod.POST)
	public ModelAndView displayCode(
			@RequestParam("platform") String platform, 
			@RequestParam(value="iscustom", required=false) String isCustomImport, 
			@RequestParam("connection-method") String connectionMethod) {
		String APIKEY = getSaltString();
		
		
		boolean isUsingCustom = isCustomImport == null ? false : true;
		boolean isUsingArduino = platform.equals("arduino") ? true : false;
		boolean isUsingWiFi = connectionMethod.equals("wifi") ? true : false;
		
		CodeGenerator cg = new CodeGenerator();
		
		SensorCode sc = cg.generateCode(APIKEY, isUsingCustom, isUsingArduino, isUsingWiFi);
		
		
		
		ModelAndView mv = new ModelAndView("displaycode");
		
		
		
		mv.addObject("APIKEY", APIKEY);
		mv.addObject("sensorcode", sc);
		return mv;
	}
	
	protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	
}

*/
