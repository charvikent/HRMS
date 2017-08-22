package com.aurospaces.neighbourhood.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aurospaces.neighbourhood.bean.TimeSheetBean;
import com.aurospaces.neighbourhood.db.dao.TimeSheetDao;


@Controller
public class TimeSheetController {
	
	@Autowired TimeSheetDao timeSheetDao;
	
	private Logger logger = Logger.getLogger(TimeSheetController.class);
	
	@RequestMapping(value = "/timeSheetHome")
	public String displaTimeSheetHome(@ModelAttribute("packCmd") TimeSheetBean timeSheetBean, ModelMap model,HttpServletRequest request) {
		System.out.println("in displaTimeSheetHome....");
		try{
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			logger.error(e);
			logger.fatal("error in displaTimeSheetHome method in TimeSheetController class");
		}
		return "timeSheetHome";
	}
	@RequestMapping(value = "/addTimeSheet")
	public String addTimeSheet(@ModelAttribute("packCmd") TimeSheetBean timeSheetBean, ModelMap model,HttpServletRequest request,HttpSession session)  {
		System.out.println(" in addTimeSheet...");
		try{
			System.out.println("proj name:"+timeSheetBean.getPeriod());
			System.out.println("job name:"+timeSheetBean.getEmpName());
			System.out.println("job name:"+timeSheetBean.getClients());
			System.out.println("job name:"+timeSheetBean.getProjects());
			System.out.println("job name:"+timeSheetBean.getJobs());
			System.out.println("job name:"+timeSheetBean.getBillableStatus());
			
			timeSheetDao.saveOrUpdate(timeSheetBean);
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}

		return "redirect:timeSheetHome";
	}
}
