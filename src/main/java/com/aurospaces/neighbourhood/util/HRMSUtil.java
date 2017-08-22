package com.aurospaces.neighbourhood.util;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.aurospaces.neighbourhood.bean.UsersBean;

public class HRMSUtil {
	public static Date  dateFormate(String date){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
		Date date1 = null;
		if(StringUtils.isNotBlank(date)){
					 try {
						date1 = formatter.parse(date);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		return date1;
		}
	
	public  String  sessionChecking(HttpSession session){
		String sessionUser = null;
//		UsersBean objuserBean = null;
		try{
			UsersBean objuserBean =(UsersBean) session.getAttribute("cacheUserBean");
			if(objuserBean != null){
				if(Integer.parseInt(objuserBean.getRolId()) == 1){
					sessionUser = "admin";
					return sessionUser;
					}
					if(Integer.parseInt(objuserBean.getRolId()) == 3){
						sessionUser = "employee";
						return sessionUser;
						}
			}
		
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return sessionUser;
		
	}
	
	
	private static final char[] CHARSET_AZ_09 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

	public static String randomString(char[] characterSet, int length) {
		SecureRandom random = new SecureRandom();
		char[] result = new char[length];
		for (int i = 0; i < result.length; i++) {
			// picks a random index out of character set > random character
			int randomCharIndex = random.nextInt(characterSet.length);
			result[i] = characterSet[randomCharIndex];
		}
		return new String(result);
	}

	public String randNum() {
		String randNum = randomString(CHARSET_AZ_09, 5);
		return randNum;

	}
	public  UsersBean  sessionChecking1(HttpSession session){
		UsersBean objuserBean = null;
		try{
			 objuserBean =(UsersBean) session.getAttribute("cacheUserBean");
		}catch(Exception e){
			e.printStackTrace();
		}
		return objuserBean;
		
	}
}
