package com.aurospaces.neighbourhood.controller;

import java.io.IOException;
import java.util.LinkedList;
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

import com.aurospaces.neighbourhood.bean.EmployeeBean;
import com.aurospaces.neighbourhood.bean.GroupsBean;
import com.aurospaces.neighbourhood.bean.Proje;
import com.aurospaces.neighbourhood.db.dao.DepartmentDao;
import com.aurospaces.neighbourhood.db.dao.EmployeeDao;
import com.aurospaces.neighbourhood.db.dao.GroupsDao;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class GroupsController {
	@Autowired GroupsDao groupsDao;
	@Autowired EmployeeDao empDao;
	@Autowired DepartmentDao objDepartmentDao;
	
	private Logger logger = Logger.getLogger(GroupsController.class);
	
	@RequestMapping(value = "/groupsHome")
	public String groupsHome(@ModelAttribute("addGroupForm") GroupsBean objGroupBean,ModelMap model,HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		List<GroupsBean> listGroupBeans = null;
		ObjectMapper objectMapper = null;
		String sJson=null;
		try{
			listGroupBeans = groupsDao.getGroups();
			 objectMapper = new ObjectMapper();
			if (listGroupBeans != null && listGroupBeans.size() > 0) {
				for(GroupsBean groupBean:listGroupBeans){
					List<Map<String,String>> usersList =  groupsDao.getGroupUsers(groupBean.getId());
					groupBean.setUsersList(usersList);
				}
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listGroupBeans);
				request.setAttribute("listGroupBeans", sJson);
			} else {
				objectMapper = new ObjectMapper();
				request.setAttribute("listGroupBeans", "''");
			}
			request.setAttribute("usersList",populateGroupUsers());
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in groupsHome method in GroupsController ");
			return "loginHome1";
			
		}
		return "groupsHome";
	}
	@RequestMapping(value = "/addGroup")
	public @ResponseBody String addGroup( @ModelAttribute("addGroupForm") GroupsBean objGroupBean,ModelMap model,
									HttpServletRequest request,HttpSession session) throws JsonGenerationException, JsonMappingException, IOException {
		List<GroupsBean> listGroupBeans = null;
		JSONObject jsonObj = new JSONObject();
		String message = "";
		try{
 			if(objGroupBean != null){
				
 				String user_ids = objGroupBean.getUserIds();
 				int usersLen = user_ids.split("##").length;
 				
				 message = groupsDao.save(objGroupBean,usersLen);
				 
				 jsonObj.put("message", message);
				
				 listGroupBeans = groupsDao.getGroups();
				if (listGroupBeans != null && listGroupBeans.size() > 0) {
					for(GroupsBean groupBean:listGroupBeans){
						List<Map<String,String>> usersList =  groupsDao.getGroupUsers(groupBean.getId());
						groupBean.setUsersList(usersList);
					}
					jsonObj.put("allGroupsList", listGroupBeans);
				} else {
					jsonObj.put("allGroupsList", "''");
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in addGroup method in GroupsController ");
			return "redirect:groupsHome";
			
		}
		return String.valueOf(jsonObj);
	}
	
	@RequestMapping(value = "/deleteGroup")
	public @ResponseBody String deleteGroup(ModelMap model,HttpServletRequest request)
					throws JsonGenerationException, JsonMappingException, IOException {
		List<GroupsBean> listOfGroups = null; 
		ObjectMapper objectMapper = null;
		String sJson = null;
		JSONObject jsonObj = new JSONObject();
		String group_id = null;
		boolean isDeleted = false;
		try {
			group_id=request.getParameter("group_id");
			if(StringUtils.isNotBlank(group_id)){
				isDeleted = groupsDao.delete(Integer.parseInt(group_id));
			}
			if(isDeleted){
				jsonObj.put("message", "Successfully deleted Group");
			}else{
				jsonObj.put("message", " Delete failed");
			}
			listOfGroups = groupsDao.getGroups();
			objectMapper = new ObjectMapper();
			if(listOfGroups != null && listOfGroups.size() > 0) {
				for(GroupsBean groupBean:listOfGroups){
					List<Map<String,String>> usersList =  groupsDao.getGroupUsers(groupBean.getId());
					groupBean.setUsersList(usersList);
				}
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOfGroups);
				request.setAttribute("listOfGroups", sJson);
				jsonObj.put("listOfGroups", listOfGroups);
				// System.out.println(sJson);
			} else {
				objectMapper = new ObjectMapper();
				sJson = objectMapper.writeValueAsString(listOfGroups);
				request.setAttribute("listOfGroups", "''");
				jsonObj.put("listOfGroups", "''");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in deleteGroup method in GroupsController ");
			return "groupsHome";

		}
		return String.valueOf(jsonObj);
	}

	/*@RequestMapping(value = "/deleteGroup")
	public String deleteGroup(  @ModelAttribute("addGroupForm") GroupsBean objGroupBean,ModelMap model,HttpServletRequest request,HttpSession session,BindingResult objBindingResult) throws JsonGenerationException, JsonMappingException, IOException {
		List<Map<String, String>> listOrderBeans = null;
		JSONObject jsonObj = new JSONObject();
		ObjectMapper objectMapper = null;
		String sJson=null;
		String message = null;
		boolean delete = false;
		try{
 			if(objGroupBean.getId() != 0){
 				delete = objAddGroupDao.delete(objGroupBean.getId());
 				if(delete){
 					jsonObj.put("message", "delete successfully");
 				}else{
 					jsonObj.put("message", "delete fail");
 				}
 			}
 			listOrderBeans = objAddGroupDao.getAddGroup();
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
*/
	
	@ModelAttribute("usersList")
	public List<EmployeeBean> populateGroupUsers() {
		List<EmployeeBean> usersList = new LinkedList<>();
		try {
			usersList = empDao.getallEmployeeDetails(0, null, null, null);
			if(usersList.size()>0){
				for(EmployeeBean employeee:usersList){
					employeee.setFirstName(employeee.getFirstName()+" "+employeee.getLastName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return usersList;
	}
	
	@ModelAttribute("rolesList")
	public List<Proje> populateRoles() {
		List<Proje> usersList = new LinkedList<>();
		try {
			usersList = objDepartmentDao.populate("select id, name from roles");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return usersList;
	}
	
	/*@ModelAttribute("title")
	public Map<Integer, String> populateTitle() {
		Map<Integer, String> statesMap = new LinkedHashMap<Integer, String>();
		try {
			String sSql = "select id,name from designation order by name asc";
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
*/	
}
