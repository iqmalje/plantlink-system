package com.plantlink.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.plantlink.bdUtil.DBConnect;
import com.plantlink.builder.SensorCode;
import com.plantlink.model.Channel;

@Controller
@RequestMapping("/sensor")
public class SensorController {
	
	@RequestMapping("/register")
	public String displayRegisterSensor() {
		return "RegisterSensorView";
	}
	
	
	
	
	@RequestMapping(value="/registersensor", method=RequestMethod.POST)
	@ResponseBody()
	public String registerSensorToDB(
			@RequestParam("apikey") String APIKey,
			@RequestParam("name") String name
			) {
		try {
			Connection conn = DBConnect.openConnection();
			
			
			
			
			String sql = "INSERT INTO sensors(apikey, name) VALUES (?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, APIKey);
			ps.setString(2, name);
			
			
			int row = ps.executeUpdate();
			
			return "Successfully added SENSOR - " + name + " to the Database!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error!";
		}
	}
	
	
	
}
