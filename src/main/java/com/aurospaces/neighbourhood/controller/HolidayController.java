package com.aurospaces.neighbourhood.controller;

import java.io.IOException;
import java.util.Date;
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

import com.aurospaces.neighbourhood.bean.HolidayBean;
import com.aurospaces.neighbourhood.bean.UsersBean;
import com.aurospaces.neighbourhood.db.dao.ClientDao;
import com.aurospaces.neighbourhood.db.dao.HolidayDao;
import com.aurospaces.neighbourhood.util.HRMSUtil;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class HolidayController {
	@Autowired
	HolidayDao objHolidayDao;
	@Autowired
	ClientDao objClientDao;
	private Logger logger = Logger.getLogger(HolidayController.class);

	@RequestMapping(value = "/HolidayHome")
	public String HolidayHome(@ModelAttribute("holidayForm") HolidayBean objHolidayBean, ModelMap model,
			HttpServletRequest request, HttpSession session)
					throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("HolidayHome page...");
		List<Map<String, String>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		try {

			listOrderBeans = objHolidayDao.getHolidays();
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
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school DepartmentController class DepartmentHome method  ");
			return "HolidayHome";

		}
		return "HolidayHome";
	}

	@RequestMapping(value = "/addHoliday")
	public @ResponseBody String addHoliday(@Valid @ModelAttribute("holidayForm") HolidayBean objHolidayBean,
			ModelMap model, HttpServletRequest request, HttpSession session, BindingResult objBindingResult)
					throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("HolidayHome page...");
		List<Map<String, String>> listOrderBeans = null;
		JSONObject jsonObj = new JSONObject();
		ObjectMapper objectMapper = null;
		String sJson = null;
		String message = null;
		try {
			if (objBindingResult.hasErrors()) {
				request.setAttribute("error", "login fail");
				jsonObj.put("message", "fill all the fileds");
				return String.valueOf(jsonObj);
			}
			if (objHolidayBean != null) {
				String s = objHolidayBean.getFromDate1();
				Date fromdate = HRMSUtil.dateFormate(objHolidayBean.getFromDate1());
				if (fromdate != null) {
					objHolidayBean.setFromDate(fromdate);
				}
				Date todate = HRMSUtil.dateFormate(objHolidayBean.getToDate1());
				if (todate != null) {
					objHolidayBean.setToDate(todate);
				}
				message = objHolidayDao.save(objHolidayBean);
				jsonObj.put("message", message);

				listOrderBeans = objHolidayDao.getHolidays();
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
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school DepartmentController class DepartmentHome method  ");
			jsonObj.put("message", "excetption" + e);
			return String.valueOf(jsonObj);

		}
		return String.valueOf(jsonObj);
	}

	@RequestMapping(value = "/deleteHoliday")
	public @ResponseBody String deleteHoliday(@ModelAttribute("holidayForm") HolidayBean objHolidayBean, ModelMap model,
			HttpServletRequest request, HttpSession session, BindingResult objBindingResult)
					throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("HolidayHome page...");
		List<Map<String, String>> listOrderBeans = null;
		JSONObject jsonObj = new JSONObject();
		ObjectMapper objectMapper = null;
		String sJson = null;
		String message = null;
		boolean delete = false;
		String sessionUser = null;
		HRMSUtil hrmsUtil = null;
		try {
			hrmsUtil= new HRMSUtil();
			sessionUser = hrmsUtil.sessionChecking(session);
			if (sessionUser != null) {
				if (objHolidayBean.getId() != 0) {
					delete = objHolidayDao.delete(objHolidayBean.getId());
					if (delete) {
						jsonObj.put("message", "delete successfully");
					} else {
						jsonObj.put("message", "delete fail");
					}
				}
				listOrderBeans = objHolidayDao.getHolidays();
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
			}else{
				jsonObj.put("message", "dddd");
				return String.valueOf(jsonObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school DepartmentController class DepartmentHome method  ");
			jsonObj.put("message", "excetption" + e);
			return String.valueOf(jsonObj);

		}
		return String.valueOf(jsonObj);
	}
	@RequestMapping(value = "/getHolidays")
	public @ResponseBody String getHolidays( ModelMap model,
			HttpServletRequest request, HttpSession session)
					throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("HolidayHome page...");
		List<Map<String, String>> listOrderBeans = null;
		List<Map<String, String>> listOrderBeans1 = null;
		JSONObject jsonObj = new JSONObject();
		try {
			listOrderBeans = objHolidayDao.getHolidaysforCalender();
			
			if(session.getAttribute("cacheUserBean") != null){
				UsersBean objuserBean =(UsersBean) session.getAttribute("cacheUserBean");
				if(objuserBean.getEmpId() != 0){
					listOrderBeans1 = objClientDao.getWorkingDetailsCalender(objuserBean.getEmpId());
				}
			}
			jsonObj.put("allOrders1", listOrderBeans);
			jsonObj.put("workingDetails", listOrderBeans1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school DepartmentController class DepartmentHome method  ");
			jsonObj.put("message", "excetption" + e);
			return String.valueOf(jsonObj);

		}
		return String.valueOf(jsonObj);
	}
}
