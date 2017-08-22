package com.aurospaces.neighbourhood.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.aurospaces.neighbourhood.bean.ClientBean;
import com.aurospaces.neighbourhood.bean.ProjectsBean;
import com.aurospaces.neighbourhood.db.dao.ClientDao;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class ClientController {
	@Autowired ClientDao objClientDao;
	private Logger logger = Logger.getLogger(ClientController.class);
	@RequestMapping(value = "/ClientHome")
	public String clientHome(@ModelAttribute("clientForm") ClientBean clientBean,ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		
		System.out.println("ClientHome page...");
		List<Map<String, String>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson=null;
		try{
			listOrderBeans = objClientDao.getAllClients();
			 objectMapper = new ObjectMapper();
			if (listOrderBeans != null && listOrderBeans.size() > 0) {
				
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1", sJson);
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
		return "clientHome";
	}
	@RequestMapping(value = "/addClient")
	public @ResponseBody String addHoliday(  @ModelAttribute("clientForm") ClientBean objClientBean,ModelMap model,HttpServletRequest request,HttpSession session,BindingResult objBindingResult) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("ClientHome page...");
		List<Map<String, String>> listOrderBeans = null;
		JSONObject jsonObj = new JSONObject();
		ObjectMapper objectMapper = null;
		String sJson=null;
		String message = null;
		try{
			
				 message =objClientDao.save(objClientBean);
				 jsonObj.put("message", message);
				System.out.println(message);
				listOrderBeans = objClientDao.getAllClients();
				 objectMapper = new ObjectMapper();
				if (listOrderBeans != null && listOrderBeans.size() > 0) {
					
					objectMapper = new ObjectMapper();
					sJson = objectMapper.writeValueAsString(listOrderBeans);
					request.setAttribute("allOrders1", sJson);
					// System.out.println(sJson);
					jsonObj.put("allOrders1", listOrderBeans);
				} else {
					objectMapper = new ObjectMapper();
					sJson = objectMapper.writeValueAsString(listOrderBeans);
					request.setAttribute("allOrders1", "''");
					jsonObj.put("allOrders1", listOrderBeans);
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
	@RequestMapping(value = "/deleteClient")
	public @ResponseBody String deleteHoliday(  @ModelAttribute("projectForm") ProjectsBean objProjectBean,ModelMap model,HttpServletRequest request,HttpSession session,BindingResult objBindingResult) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("HolidayHome page...");
		List<Map<String, String>> listOrderBeans  = null;
		JSONObject jsonObj = new JSONObject();
		ObjectMapper objectMapper = null;
		String sJson=null;
		boolean delete = false;
		try{
			if(objProjectBean.getId() != 0){
 				delete = objClientDao.delete(objProjectBean.getId());
 				if(delete){
 					jsonObj.put("message", "delete successfully");
 				}else{
 					jsonObj.put("message", "delete fail");
 				}
 			}
 				
 			listOrderBeans = objClientDao.getAllClients();
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
}
