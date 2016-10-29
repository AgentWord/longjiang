package com.century.longjiang;



import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




import com.century.longjiang.utils.C3P0Utils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * 监护人接�? 
 * @author likun
 *
 */
@Controller
public class AppUserController {
	

	@RequestMapping(value="/hello")
	public String hello(){
		return "hello";
	}
	/**
	 * 监护人用户注�?注册流程：检测用户是否存�?获取融云token>百度鹰眼添加entity
	 * @param name
	 * @param pwd
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/hel")
	public String register(
			@RequestParam(value = "username", required = false) String name,
			@RequestParam(value = "pwd", required = false) String pwd,
			@RequestParam(value = "callback", required = false) String callback,
			HttpServletRequest request, HttpServletResponse response) {
		 response.setHeader("Access-Control-Allow-Origin", "*");
	     response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        //System.out.println("/app/register called:" +new Date(System.currentTimeMillis()).toLocaleString());
	     try {
		   Connection con=C3P0Utils.getConnection();
		   System.out.println("连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("连接失败");
			e.printStackTrace();
			
		}
	     
	     return "hello";
	
		
		// implementation omitted
	}
    
	/**
	 * 登录接口 返回token和被监护者手机号，监护�?手机号是发�?消息时的targetid
	 * @param name
	 * @param pwd
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/app/login",produces = "text/plain; charset=utf-8")
	public String login(
			@RequestParam(value = "username", required = false) String name,
			@RequestParam(value = "pwd", required = false) String pwd,
			@RequestParam(value = "callback", required = false) String callback,
			HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        //System.out.println("/app/login called:" +new Date(System.currentTimeMillis()).toLocaleString());
		return callback;
		
	}

	
}