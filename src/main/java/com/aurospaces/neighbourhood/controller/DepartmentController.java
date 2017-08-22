package com.aurospaces.neighbourhood.controller;

import java.io.IOException;
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

import com.aurospaces.neighbourhood.bean.Proje;
import com.aurospaces.neighbourhood.db.dao.DepartmentDao;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class DepartmentController {
	@Autowired
	DepartmentDao objDepartmentDao;

	private Logger logger = Logger.getLogger(DepartmentController.class);

	@RequestMapping(value = "/DepartmentHome")
	public String DepartmentHome( @ModelAttribute("packCmd") Proje objDepartmentBean, ModelMap model,
			HttpServletRequest request, HttpSession session)
					throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("DepartmentHome page...");
		List<Map<String, String>> listOrderBeans = null;
		List<Map<String, String>> listOrderBeans1 = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		try {
			
			listOrderBeans = objDepartmentDao.getAllDepartments();
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

			listOrderBeans1 = objDepartmentDao.getDepartments();
			System.out.println(listOrderBeans1);
			if (listOrderBeans1 != null && listOrderBeans1.size() > 0) {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans1);
				request.setAttribute("allOrders", sJson);
				System.out.println(sJson);
			} else {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans1);
				request.setAttribute("allOrders", "''");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school DepartmentController class DepartmentHome method  ");
			return "loginHome1";

		}
		return "DepartmentHome";
	}

	@RequestMapping(value = "/updateDepartment")
	public @ResponseBody String updateDepartment(@Valid @ModelAttribute("packCmd") Proje objDepartmentBean,
			ModelMap model, HttpServletRequest request, HttpSession session ,BindingResult result1)
					throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("update Department page...");
		List<Map<String, String>> listOrderBeans = null;
		JSONObject jsonObj = new JSONObject();
		ObjectMapper objectMapper = null;
		String sJson = null;
		int parentHead = 0;
		Proje department = null;
		String allParentIds = null;
		List<Proje> departmentnames = null;
		try {
			if (result1.hasErrors()) {
				//model3.addObject("error", "login fail");
				 request.setAttribute("error", "login fail");
				 jsonObj.put("message", "fill all the fileds");
				 return String.valueOf(jsonObj);
	        }
			if (objDepartmentBean.getId() != 0) {
				if (StringUtils.isNotBlank(objDepartmentBean.getParentid())) {
					if (objDepartmentBean.getId() == Integer.parseInt(objDepartmentBean.getParentid())) {
						jsonObj.put("message", "department and parent department is same");
						System.out.println("department and parent department is same");
						return String.valueOf(jsonObj);
					}
				}
			}
			if (StringUtils.isNotBlank(objDepartmentBean.getParentid())) {
				parentHead = Integer.parseInt(objDepartmentBean.getParentid());
				department = objDepartmentDao.testParentId(parentHead);
			}
			if (department != null) {
				if (StringUtils.isNotBlank(department.getAllParentIds())) {
					allParentIds = department.getAllParentIds();
					String[] array = allParentIds.split(",");
					for (int i = 0; i < array.length; i++) {
						
							allParentIds = "'" + array[i] + "'";
							if (objDepartmentBean.getId() == Integer.parseInt(array[i])) {
								jsonObj.put("message", "chaild department  not accepting");
								System.out.println("chaild department  not accepting");
								return String.valueOf(jsonObj);
							}
					}
				}
			}
			String result = objDepartmentDao.save(objDepartmentBean);
			jsonObj.put("message", result);
			listOrderBeans = objDepartmentDao.getAllDepartments();
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
				jsonObj.put("allOrders1", "''");
			}
			departmentnames = objDepartmentDao.getDepartmentNames();
			if (departmentnames != null) {
				jsonObj.put("departnames", departmentnames);
			} else {
				jsonObj.put("departnames", "''");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school DepartmentController class DepartmentHome method  ");
			return "redirect:DepartmentHome";

		}
		return String.valueOf(jsonObj);
	}

	@RequestMapping(value = "/DepartmentHierarchical ")
	public String DepartmentHierarchical(@ModelAttribute("packCmd") Proje objDepartmentBean, ModelMap model,
			HttpServletRequest request, HttpSession session)
					throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("DepartmentHome page...");
		List<Map<String, String>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		try {
			listOrderBeans = objDepartmentDao.getDepartments();
			System.out.println(listOrderBeans);
			if (listOrderBeans != null && listOrderBeans.size() > 0) {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1", sJson);
				System.out.println(sJson);
			} else {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOrderBeans);
				request.setAttribute("allOrders1", "''");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school DepartmentController class DepartmentHome method  ");
			return "DepartmentHierarchical";

		}
		return "DepartmentHierarchical";
	}

	@RequestMapping(value = "/deleteDepartment ")
	public @ResponseBody String deleteDepartment(@ModelAttribute("packCmd") Proje objDepartmentBean,
			ModelMap model, HttpServletRequest request, HttpSession session)
					throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("deleteDepartment page...");
		List<Map<String, String>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		JSONObject jsonObj = new JSONObject();
		List<Proje> listDepartment = null;
		try {
			listDepartment = objDepartmentDao.getChaildDepartments(objDepartmentBean.getId());
			if (listDepartment != null) {
				jsonObj.put("message", "please delete first child department");
			} else {
				boolean delete = objDepartmentDao.delete(objDepartmentBean.getId());
				if (delete) {
					jsonObj.put("message", "Success delete");
				}
			}
			listOrderBeans = objDepartmentDao.getAllDepartments();
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
				jsonObj.put("allOrders1", "''");
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

	@ModelAttribute("department")
	public Map<Integer, String> populateDepartment() {
		Map<Integer, String> statesMap = new LinkedHashMap<Integer, String>();
		try {
			String sSql = "select id,name from department order by name asc";
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
	@ModelAttribute("employee")
	public Map<Integer, String> populateEmployee() {
		Map<Integer, String> statesMap = new LinkedHashMap<Integer, String>();
		try {
			String sSql = "select id, CONCAT(`firstName`, ' ', `lastName`) as name from employee order by name asc";
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
