package com.plantlink.controller;

import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.plantlink.builder.SensorCode;
import com.plantlink.model.Channel;
import com.plantlink.bdUtil.DBConnect;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ChannelController {
	
	
	@RequestMapping("/")
	public ModelAndView getChannelList() {
		
		try {
			Connection conn = DBConnect.openConnection();
			Statement stmnt = conn.createStatement();
			String sql = "SELECT * FROM channels";
			ResultSet rs = stmnt.executeQuery(sql);
			List<Channel> channels = new ArrayList<Channel>();
			while(rs.next())
			{
				System.out.println("ID: " + rs.getInt("id"));
				System.out.println("Name: " + rs.getString(2));
				Channel channel = new Channel();
				
				channel.setId(rs.getInt("id"));
				channel.setName(rs.getString("name"));
				channel.setImage(rs.getString("image"));
				channels.add(channel);
			}
			
			
			ModelAndView mv = new ModelAndView("DashboardView");
			mv.addObject("channels", channels);
			
			return mv;
		} catch (SQLException e)
		{
			ModelAndView mv = new ModelAndView("errorpage");
			
			
			e.printStackTrace();
			return mv;
		}
		
		
	}
	
	@RequestMapping("/create")
	public String displayChannelForm() {
		return "CreateChannelView";
	}
	
	@RequestMapping("/channel/{channelID}")
	public ModelAndView getChannelData(
			@PathVariable int channelID
			) {
		
		try {
			ModelAndView mv = new ModelAndView("ChannelView");
			
			
			Connection conn = DBConnect.openConnection();
			
			
			
			
			String sql = "SELECT * FROM channels WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, channelID);
			
			
			ResultSet rs = ps.executeQuery();
			Channel channel = new Channel();
			
			if(!rs.isBeforeFirst()) {
				throw new Exception("No such channel with ID " + channelID + " existed!");
			}
			while(rs.next())
			{
				channel.setId(rs.getInt("id"));
				channel.setDescription(rs.getString("description"));
				channel.setImage(rs.getString("image"));
				channel.setLatitude(rs.getDouble("latitude"));
				channel.setLongitude(rs.getDouble("longitude"));
				channel.setName(rs.getString("name"));
				channel.setPublic(rs.getBoolean("public"));
			}
			
			mv.addObject("channel", channel);
			
			return mv;
		}
		catch (Exception e) {
			e.printStackTrace();
			
			ModelAndView mv = new ModelAndView("errorpage");
			
			return mv;
		}
		
	}
	
	
	@RequestMapping(value="/channel/create", method=RequestMethod.POST)
	public ModelAndView createChannel(
			@RequestParam("name") String name,
			@RequestParam(value="description", required=false) String description,
			@RequestParam(value="latitude", required=false) String latitude,
			@RequestParam(value="longitude", required=false) String longitude,
			@RequestParam(value="isChannelPublic", required=false) String isChannelPublic,
			@RequestParam(value="filename", required=false) String filename 
			) {
		try {
			
			Connection conn = DBConnect.openConnection();
			boolean isPublic = isChannelPublic == null ? false : true;
			double latitudeDouble = Double.parseDouble(latitude);
			double longitudeDouble = Double.parseDouble(longitude);
			
			
			
			String sql = "INSERT INTO channels(name, description, latitude, longitude, public, image) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, description);
			ps.setDouble(3, latitudeDouble);
			ps.setDouble(4, longitudeDouble);
			ps.setBoolean(5, isPublic);
			ps.setString(6, filename);
			
			int row = ps.executeUpdate();
			
			ModelAndView mv = new ModelAndView("successpage");
			
			return mv;
			
			
		} catch (SQLException e) {
			ModelAndView mv = new ModelAndView("errorpage");
			e.printStackTrace();
			return mv;
		}
	}
}
