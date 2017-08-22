package com.aurospaces.neighbourhood.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aurospaces.neighbourhood.bean.EmployeeCheckInBean;
import com.aurospaces.neighbourhood.bean.UsersBean;
import com.aurospaces.neighbourhood.db.dao.DepartmentDao;
import com.aurospaces.neighbourhood.db.dao.EmployeeCheckInDao;
import com.aurospaces.neighbourhood.db.dao.UsersDao;
import com.aurospaces.neighbourhood.util.MiscUtils;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
@PropertySource("classpath:hrms.properties")
public class LoginController {
	@Autowired
	UsersDao objUsersDao;
	@Autowired
	DepartmentDao objDepartmentDao;
	@Autowired
	EmployeeCheckInDao objEmployeeCheckInDao;
	@Autowired
	private Environment env;
	private Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(value = "/LoginHome")
	public String DepartmentHome(Map<String, Object> model1, ModelMap model, HttpServletRequest request,
			HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("LoginHome page...");
		UsersBean user = new UsersBean();
		model.put("userForm", user);
		String ss = env.getProperty("username1");
		System.out.println(ss);
		try {
			UsersBean objuserBean = (UsersBean) session.getAttribute("cacheUserBean");
			if (objuserBean != null) {
				int rolId = Integer.parseInt(objuserBean.getRolId());
				if (rolId == 1 || rolId == 2 || rolId == 3) {
					return "redirect:DepartmentHome.htm";
				}else{
					return "redirect:logoutHome.htm";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school DepartmentController class DepartmentHome method  ");
			return "login";

		}
		return "login";
	}

	@RequestMapping(value = "/loginAction")
	public @ResponseBody String loginAction(@Valid @ModelAttribute("userForm") UsersBean userObj, BindingResult result,
			ModelMap model, HttpServletRequest request, HttpSession session, HttpServletResponse responses)
					throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("loginAction page...");
		UsersBean objUserBean = null;
		JSONObject obj = new JSONObject();
		String object1 = null;
		try {
			String url = MiscUtils.getBaseUrl(request);
			System.out.println(url);
			if (result.hasErrors()) {
				// model3.addObject("error", "login fail");
				request.setAttribute("error", "login fail");
			}
			objUserBean = objUsersDao.getUserDetails(userObj);
			if (objUserBean != null) {
				session.setAttribute("cacheUserBean", objUserBean);
				session.setAttribute("rolId", objUserBean.getRolId());
				session.setAttribute("userName", objUserBean.getName());
				obj.put("message", "success");
			} else {
				obj.put("message", "fail");
			}
			object1 = obj.toString();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school DepartmentController class DepartmentHome method  ");

		}
		return object1;
	}

	@RequestMapping(value = "/logoutHome")
	public String logoutHome(ModelMap model, HttpServletRequest request, HttpSession objSession,
			HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("logout page...");
		try {

			HttpSession session = request.getSession(false);
			if (session != null) {
				session.removeAttribute("cacheUserBean");
				session.removeAttribute("rolId");
				session.removeAttribute("userName");
				session.invalidate();
				response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");// HTTP
																							// 1.1
				response.setHeader("Pragma", "no-cache"); // HTTP 1.0
				response.setDateHeader("Expires", -1); // prevents caching at
														// the proxy server
				// String baseUrl = MiscUtils.getBaseUrl(request);
				// System.out.println(baseUrl);
				// response.sendRedirect(baseUrl+"/LoginHome1.htm" );
				response.sendRedirect(request.getContextPath() + "/LoginHome");
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school Homecontroller class logoutHome method  ");
		}
		return null;
	}

	@RequestMapping(value = "/checkIn")
	public @ResponseBody String checkIn(ModelMap model, HttpServletRequest request, HttpSession objSession,
			HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("logout page...");
		JSONObject jsonObj = new JSONObject();
		ObjectMapper objectMapper= null;
		String sJson = null;
		try {

			if (objSession.getAttribute("cacheUserBean") != null) {
				UsersBean usersBean = (UsersBean) objSession.getAttribute("cacheUserBean");
				if (usersBean.getEmpId() != 0) {
					List<EmployeeCheckInBean> checkInBean = objEmployeeCheckInDao.getByEmployeeId(usersBean.getEmpId());
					if (checkInBean == null) {
						EmployeeCheckInBean objEmployeeCheckInBean = new EmployeeCheckInBean();
						objEmployeeCheckInBean.setEmployeeId(usersBean.getEmpId());
						objEmployeeCheckInBean.setActive(1);
						objEmployeeCheckInDao.save(objEmployeeCheckInBean);
					} else {
						for(EmployeeCheckInBean check : checkInBean)
						if (check.getActive() == 1) {
							EmployeeCheckInBean objEmployeeCheckInBean = new EmployeeCheckInBean();
							objEmployeeCheckInBean.setId(check.getId());
							objEmployeeCheckInBean.setEmployeeId(usersBean.getEmpId());
							objEmployeeCheckInBean.setActive(0);
							objEmployeeCheckInDao.save(objEmployeeCheckInBean);
						} else {
							EmployeeCheckInBean objEmployeeCheckInBean = new EmployeeCheckInBean();
							objEmployeeCheckInBean.setEmployeeId(usersBean.getEmpId());
							objEmployeeCheckInBean.setActive(1);
							objEmployeeCheckInDao.save(objEmployeeCheckInBean);
						}

					}
					List<EmployeeCheckInBean> checkInBean1 = objEmployeeCheckInDao.getByEmployeeId(usersBean.getEmpId());
					if(checkInBean1 != null){
						objectMapper = new ObjectMapper();
						sJson = objectMapper.writeValueAsString(checkInBean1);
						jsonObj.put("data", sJson);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school Homecontroller class logoutHome method  ");
		}
		return String.valueOf(jsonObj);
	}

	@RequestMapping(value = "/loginCheck")
	public @ResponseBody String loginCheck(ModelMap model, HttpServletRequest request, HttpSession objSession,
			HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {
		JSONObject jsonObj = new JSONObject();
		try {

			if (objSession.getAttribute("cacheUserBean") != null) {
				UsersBean usersBean = (UsersBean) objSession.getAttribute("cacheUserBean");
				if (usersBean.getEmpId() != 0) {
					List<EmployeeCheckInBean> checkInBean = objEmployeeCheckInDao.getByEmployeeId(usersBean.getEmpId());
					if (checkInBean == null) {
						jsonObj.put("message", "not login");
					}else{
						for(EmployeeCheckInBean check : checkInBean){
						jsonObj.put("loginTime", check.getCreatedTime());
						if(check.getActive() == 0){
						jsonObj.put("message", "not login");
						}else{
							jsonObj.put("message", "login");
						}
					}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school Login class loginCheck method  ");
		}
		return String.valueOf(jsonObj);
	}

	@RequestMapping(value = "/Calendar")
	public String Calendar(Map<String, Object> model1, ModelMap model, HttpServletRequest request, HttpSession session)
			throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("Calendar page...");
		try {

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in userLogin method in school Login Controller class DepartmentHome method  ");
			return "CalendarHome";

		}
		return "CalendarHome";
	}
}
