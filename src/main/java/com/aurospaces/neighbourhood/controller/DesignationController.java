package com.aurospaces.neighbourhood.controller;

import java.io.IOException;
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
import com.aurospaces.neighbourhood.bean.DesignationBean;
import com.aurospaces.neighbourhood.db.dao.DesignationDao;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class DesignationController {
	@Autowired
	DesignationDao objDesignationDao;
	private Logger logger = Logger.getLogger(DesignationController.class);

	@RequestMapping(value = "/DesignationHome")
	public String addDesignationPage(@ModelAttribute("DesignationHome") DesignationBean empBean, ModelMap model,
			HttpServletRequest request) {
		System.out.println("addDesignationPage");
		List<DesignationBean> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		try {

			listOrderBeans = objDesignationDao.getAllDesignations();
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

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school Homecontroller class viewStudentParent method");
		}
		return "DesignationHome";
	}

	@RequestMapping(value = "/addDesignation")
	public @ResponseBody String addDesignation(@Valid @ModelAttribute("DesignationHome") DesignationBean objDesignationBean, ModelMap model,
			HttpServletRequest request ,BindingResult bindResult) {
		System.out.println("addDesignation");
		List<DesignationBean> listOrderBeans =null;
		JSONObject jsonObj = new JSONObject();
		ObjectMapper objectMapper ;
		String sJson ="''";
		String message =null;
		try {
			if (bindResult.hasErrors()) {
				//model3.addObject("error", "login fail");
				 request.setAttribute("error", "login fail");
				 jsonObj.put("message", "fill all the fileds");
				 return String.valueOf(jsonObj);
	        }
			if(objDesignationBean != null){
				 message =objDesignationDao.save(objDesignationBean);
				 jsonObj.put("message", message);
				
				listOrderBeans = objDesignationDao.getAllDesignations();
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
			System.out.println("designation name:" + objDesignationBean.getName());
			System.out.println("mail alias:" + objDesignationBean.getMailAlias());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school Homecontroller class viewStudentParent method");
			jsonObj.put("message", e);
		}
		return String.valueOf(jsonObj);
	}
	@RequestMapping(value = "/deleteDesignation ")
	public @ResponseBody String deleteDesignation(@ModelAttribute("packCmd") Proje objDepartmentBean,
			ModelMap model, HttpServletRequest request, HttpSession session)
					throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("deleteDepartment page...");
		List<DesignationBean> listOrderBeans =null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		JSONObject jsonObj = new JSONObject();
		try {
			boolean delete = objDesignationDao.delete(objDepartmentBean.getId());
			if(delete){
				jsonObj.put("message", "successfully deleted");
			}else{
				jsonObj.put("message", " delete fail");
			}
			listOrderBeans = objDesignationDao.getAllDesignations();
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
