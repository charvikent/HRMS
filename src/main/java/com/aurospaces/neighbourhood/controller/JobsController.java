package com.aurospaces.neighbourhood.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aurospaces.neighbourhood.bean.HolidayBean;
import com.aurospaces.neighbourhood.bean.JobsBean;
import com.aurospaces.neighbourhood.bean.Proje;
import com.aurospaces.neighbourhood.db.dao.DepartmentDao;
import com.aurospaces.neighbourhood.db.dao.HolidayDao;
import com.aurospaces.neighbourhood.db.dao.JobsDao;
import com.aurospaces.neighbourhood.util.HRMSUtil;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class JobsController {
	@Autowired HolidayDao objHolidayDao;
	@Autowired JobsDao objJobsDao;
	@Autowired DepartmentDao objDepartmentDao;
	private Logger logger = Logger.getLogger(JobsController.class);
	@RequestMapping(value = "/JobsHome")
	public String JobsHome(@ModelAttribute("jobsForm") JobsBean objJobsBean,ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("JobsHome page...");
		List<Map<String, String>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson=null;
		try{
			listOrderBeans = objJobsDao.getJobs();
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
			logger.fatal("error in userLogin method in school DepartmentController class DepartmentHome method  ");
			return "HolidayHome";
			
		}
		return "jobsHome";
	}
	@RequestMapping(value = "/addJobs")
	public @ResponseBody String addHoliday(  @ModelAttribute("jobsForm") JobsBean objJobsBean,ModelMap model,HttpServletRequest request,HttpSession session,BindingResult objBindingResult) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("HolidayHome page...");
		List<Map<String, String>> listOrderBeans = null;
		JSONObject jsonObj = new JSONObject();
		ObjectMapper objectMapper = null;
		String sJson=null;
		String message = null;
		try{
 			/*if(objBindingResult.hasErrors()){
				 request.setAttribute("error", "login fail");
				 jsonObj.put("message", "fill all the fileds");
				 return String.valueOf(jsonObj);
			}*/
			if(objJobsBean != null){
				String s = objJobsBean.getStartDate1();
				Date fromdate = HRMSUtil.dateFormate(objJobsBean.getStartDate1());
				if(fromdate != null){
					objJobsBean.setStartDate(fromdate);
				}
				Date todate = HRMSUtil.dateFormate(objJobsBean.getEndDate1());
				if(todate != null){
					objJobsBean.setEndDate(todate);
				}
				objJobsBean.setProjectId(1);
				 message =objJobsDao.save(objJobsBean);
				 jsonObj.put("message", message);
				
				listOrderBeans = objJobsDao.getJobs();
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
					jsonObj.put("message", listOrderBeans);
				}
				
			}
		}catch(Exception e){
e.printStackTrace();
	System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school DepartmentController class DepartmentHome method  ");
			jsonObj.put("message", "excetption"+e);
			return String.valueOf(jsonObj);
			
		}
		return String.valueOf(jsonObj);
	}
	@RequestMapping(value = "/deleteJobs")
	public @ResponseBody String deleteHoliday(  @ModelAttribute("holidayForm") HolidayBean objHolidayBean,ModelMap model,HttpServletRequest request,HttpSession session,BindingResult objBindingResult) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("HolidayHome page...");
		List<Map<String, String>> listOrderBeans = null;
		JSONObject jsonObj = new JSONObject();
		ObjectMapper objectMapper = null;
		String sJson=null;
		String message = null;
		boolean delete = false;
		try{
 			if(objHolidayBean.getId() != 0){
 				delete = objJobsDao.delete(objHolidayBean.getId());
 				if(delete){
 					jsonObj.put("message", "delete successfully");
 				}else{
 					jsonObj.put("message", "delete fail");
 				}
 			}
 			listOrderBeans = objJobsDao.getJobs();
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
				jsonObj.put("message", listOrderBeans);
			}
		}catch(Exception e){
			e.printStackTrace();
	System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school DepartmentController class DepartmentHome method  ");
			jsonObj.put("message", "excetption"+e);
			return String.valueOf(jsonObj);
			
		}
		return String.valueOf(jsonObj);
	}
	@ModelAttribute("projects")
	public Map<Integer, String> populateProjects() {
		Map<Integer, String> statesMap = new LinkedHashMap<Integer, String>();
		try {
			String sSql = "select id, name from projects order by name asc";
			List<Proje> list = objDepartmentDao.populate(sSql);
			for (Proje bean : list) {
				statesMap.put(bean.getId(), bean.getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return statesMap;
	}
}
