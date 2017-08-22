package com.aurospaces.neighbourhood.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aurospaces.neighbourhood.bean.Proje;
import com.aurospaces.neighbourhood.bean.DesignationBean;
import com.aurospaces.neighbourhood.bean.TimeLogBean;
import com.aurospaces.neighbourhood.db.dao.TimeLogsDao;
import com.aurospaces.neighbourhood.util.HRMSUtil;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller 
public class TimeLogsController {
	
	@Autowired TimeLogsDao timeLogsDao;
	
	private Logger logger = Logger.getLogger(TimeLogsController.class);
	
	@RequestMapping(value = "/timeLogsHome")
	public String displaTimeLogsHome(@ModelAttribute("packCmd") TimeLogBean timeLogsBean, ModelMap model,HttpServletRequest request) {
		System.out.println("in displaTimeLogsHome....");
		List<Map<String, String>> listOrderBeans =null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		try{
			listOrderBeans = timeLogsDao.getAllTimeLogs();
			 objectMapper = new ObjectMapper();
			if (listOrderBeans != null && listOrderBeans.size() > 0) {
				
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1", sJson);
				// System.out.println(sJson);
			} else {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1", "''");
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in displaTimeLogsHome method in displaTimeLogsHome class");
		}
		return "timeLogsHome";
	}
	@RequestMapping(value = "/addTimeLogs")
	public String addTimeLogs(@ModelAttribute("packCmd") TimeLogBean timeLogsBean, ModelMap model,HttpServletRequest request,HttpSession session)  {
		System.out.println(" in addTimeLogs...");
		List<Map<String, String>> listOrderBeans =null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		try{
			System.out.println("proj name:"+timeLogsBean.getProjName());
			System.out.println("job name:"+timeLogsBean.getJobName());
			if(StringUtils.isNotBlank(timeLogsBean.getDate1())){
				Date date = HRMSUtil.dateFormate(timeLogsBean.getDate1());
				timeLogsBean.setDate(date);
			}
			
			String hours = timeLogsBean.getHours();
			if(StringUtils.isNotBlank(hours)){
			if(hours.equals("HOURS"))
			{
				String logged_hours = timeLogsBean.getLoggedHours();
				if((logged_hours != null) && (!logged_hours.isEmpty()))
				{
					timeLogsBean.setHours(logged_hours);
				}
			} else if(hours.equals("START_END")){
				String time1 = timeLogsBean.getStartTime();
				String time2 = timeLogsBean.getEndTime();
				if(StringUtils.isNotBlank(time1) && StringUtils.isNotBlank(time2)){
				SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
				Date date1 = format.parse(time1);
				Date date2 = format.parse(time2);
				long difference = date2.getTime() - date1.getTime();
				System.out.println(difference);
				long diffSeconds = difference / 1000 % 60;
				long diffMinutes = difference / (60 * 1000) % 60;
				long diffHours = difference / (60 * 60 * 1000) % 24;
				String Hours = diffHours+":"+diffMinutes+":"+diffSeconds;
				timeLogsBean.setHours(Hours);
				}
				// logic for getting the diff b/w startTime and endTime as string.
//				String  timeDiff = "START_END hardcoded value"; // timeDiff = endTime-startTime
//				timeLogsBean.setHours(timeDiff);
			} else if(hours.equals("START_TIMER")){
				// 
				String timerVal = "START_TIMER temporarily hard coded ";
				timeLogsBean.setHours(timerVal);
			}
			}
			timeLogsDao.saveOrUpdate(timeLogsBean);
			
			
			listOrderBeans = timeLogsDao.getAllTimeLogs();
			 objectMapper = new ObjectMapper();
			if (listOrderBeans != null && listOrderBeans.size() > 0) {
				
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1", sJson);
				// System.out.println(sJson);
			} else {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1", "''");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}

		return "redirect:timeLogsHome";
	}
	@RequestMapping(value = "/deleteTimeLog ")
	public @ResponseBody String deleteDesignation(@ModelAttribute("packCmd") TimeLogBean objTimeLogBean,
			ModelMap model, HttpServletRequest request, HttpSession session)
					throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("deleteDepartment page...");
		List<Map<String, String>> listOrderBeans =null; 
		ObjectMapper objectMapper = null;
		String sJson = null;
		JSONObject jsonObj = new JSONObject();
		try {
			if(objTimeLogBean.getId() != 0){
			boolean delete = timeLogsDao.delete(objTimeLogBean.getId());
			if(delete){
				jsonObj.put("message", "successfully deleted");
			}else{
				jsonObj.put("message", " delete fail");
			}
			}
			listOrderBeans = timeLogsDao.getAllTimeLogs();
			 objectMapper = new ObjectMapper();
			if (listOrderBeans != null && listOrderBeans.size() > 0) {
				
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1", sJson);
				jsonObj.put("allOrders1", listOrderBeans);
				// System.out.println(sJson);
			} else {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1", "''");
				jsonObj.put("allOrders1", listOrderBeans);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school DepartmentController class DepartmentHome method  ");
			return "DepartmentHome";

		}
		return String.valueOf(jsonObj);
	}
}
