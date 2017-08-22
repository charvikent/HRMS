package com.aurospaces.neighbourhood.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import com.aurospaces.neighbourhood.bean.Proje;
import com.aurospaces.neighbourhood.bean.ProjectsBean;
import com.aurospaces.neighbourhood.db.dao.DepartmentDao;
import com.aurospaces.neighbourhood.db.dao.ProjectsDao;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class ProjectsController {
	@Autowired ProjectsDao objProjectsDao;
	@Autowired DepartmentDao objDepartmentDao;
	private Logger logger = Logger.getLogger(ProjectsController.class);
	@RequestMapping(value = "/ProjectHome")
	public String HolidayHome(@ModelAttribute("projectForm") ProjectsBean objProjectsBean,ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		
		System.out.println("HolidayHome page...");
		List<ProjectsBean> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson=null;
		try{
			listOrderBeans = objProjectsDao.getAllProjects();
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
			logger.fatal("error in userLogin method in school ProjectsController class DepartmentHome method  ");
			return "HolidayHome";
			
		}
		return "ProjectHome";
	}
	@RequestMapping(value = "/addProject")
	public @ResponseBody String addHoliday( @Valid @ModelAttribute("projectForm") ProjectsBean objProjectsBean,ModelMap model,HttpServletRequest request,HttpSession session,BindingResult objBindingResult) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("HolidayHome page...");
		List<ProjectsBean> listOrderBeans = null;
		JSONObject jsonObj = new JSONObject();
		ObjectMapper objectMapper = null;
		String sJson=null;
		String message = null;
		try{
 			if(objBindingResult.hasErrors()){
				 request.setAttribute("error", "login fail");
				 jsonObj.put("message", "fill all the fileds");
				 return String.valueOf(jsonObj);
			}
			
				 message =objProjectsDao.save(objProjectsBean);
				 jsonObj.put("message", message);
				
				listOrderBeans = objProjectsDao.getAllProjects();
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
				
//			}
		}catch(Exception e){
e.printStackTrace();
	System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school Project controller class DepartmentHome method  ");
			jsonObj.put("message", "excetption"+e);
			return String.valueOf(jsonObj);
			
		}
		return String.valueOf(jsonObj);
	}
	@RequestMapping(value = "/deleteProject")
	public @ResponseBody String deleteHoliday(  @ModelAttribute("projectForm") ProjectsBean objProjectBean,ModelMap model,HttpServletRequest request,HttpSession session,BindingResult objBindingResult) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("HolidayHome page...");
		List<ProjectsBean> listOrderBeans = null;
		JSONObject jsonObj = new JSONObject();
		ObjectMapper objectMapper = null;
		String sJson=null;
		boolean delete = false;
		try{
			
			if(objProjectBean.getId() != 0){
 				delete = objProjectsDao.delete(objProjectBean.getId());
 				if(delete){
 					jsonObj.put("message", "delete successfully");
 				}else{
 					jsonObj.put("message", "delete fail");
 				}
 			}
 			listOrderBeans =  objProjectsDao.getAllProjects();
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
	@ModelAttribute("clients")
	public Map<Integer, String> populateProjects() {
		Map<Integer, String> statesMap = new LinkedHashMap<Integer, String>();
		try {
			String sSql = "select id, clientName as name from client order by name asc";
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
