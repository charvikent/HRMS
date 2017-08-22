package com.aurospaces.neighbourhood.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aurospaces.neighbourhood.bean.EmployeeBean;
import com.aurospaces.neighbourhood.bean.Proje;
import com.aurospaces.neighbourhood.db.dao.ClientDao;
import com.aurospaces.neighbourhood.db.dao.DepartmentDao;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
/*seLECT employeeId,
YEAR(created_time) AS `YEAR`, 
MONTHNAME(created_time) AS `MONTH`, 
COUNT( DISTINCT IF(Dayname(created_time) not in( 'Sunday' )
                  and Date(created_time) not in (select date(fromDate) from holiday)
                  AND employeeId=71, 
                  Date(created_time), NULL)) as TOTAL_WORKING_DAYS,
COUNT(DISTINCT IF(status != '0' 
                  
                  AND employeeId=71, 
                  Date(created_time), NULL)) as TOTAL_PRESENT
FROM employeecheckin where employeeId=71
GROUP BY `YEAR`, MONTH(created_time) ;*/
@Controller
public class AttendanceController {
	@Autowired
	DepartmentDao objDepartmentDao;
	@Autowired ClientDao objClientDao;
	private Logger logger = Logger.getLogger(AttendanceController.class);

	@RequestMapping(value = "/AttendanceHome")
	public String HolidayHome(@ModelAttribute("attendanceForm") EmployeeBean objEmployeeBean, ModelMap model,HttpServletRequest request, HttpSession session)
					throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("AttendanceHome page...");
		List<Map<String, String>> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = null;
		try {

			/*listOrderBeans = objHolidayDao.getHolidays();
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
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school DepartmentController class DepartmentHome method  ");
			return "AttendanceHome";

		}
		return "AttendanceHome";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/searchWorkingEmployee")
	public @ResponseBody String addHoliday(  EmployeeBean objEmployeeBean,
			ModelMap model, HttpServletRequest request, HttpSession session)
					throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("HolidayHome page...");
		List<Map<String, String>> listOrderBeans = null;
		JSONObject jsonObj = new JSONObject();
		ObjectMapper objectMapper = null;
		String sJson = null;
		try {
				listOrderBeans = objClientDao.getWorkingDetails(objEmployeeBean.getId());
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
			jsonObj.put("message", "excetption" + e);
			return String.valueOf(jsonObj);

		}
		return String.valueOf(jsonObj);
	}

	/*@RequestMapping(value = "/deleteHoliday")
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
*/

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
