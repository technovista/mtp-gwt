package com.Exam.server;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pos.database.MySQLRdbHelper;

import com.pos.shared.User;
import com.Exam.client.ExamService;
import com.Exam.shared.Test;
import com.Exam.shared.TestObjective;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ExamServiceImpl extends RemoteServiceServlet implements
		ExamService {
	/**
	 * @uml.property  name="session"
	 * @uml.associationEnd  
	 */
	HttpSession session ;
	@Override
	public void myfirstmethod() {
		
		
	}
	public String signIn(String userid, String password)  {
		String result = "";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
		MySQLRdbHelper rdbHelper = (MySQLRdbHelper) ctx.getBean("ManagerExams");
		User user = (User) rdbHelper.getAuthentication(userid, password);
		if(user!=null)
		{
			session=getThreadLocalRequest().getSession(true);
			session.setAttribute("user", user);
			//session.setMaxInactiveInterval(500);
			result = "loggedIn";
		}
		return result;

	}
	@Override
	public ArrayList<Test> fetchTestTypes() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
		MySQLRdbHelper rdbHelper = (MySQLRdbHelper) ctx.getBean("ManagerExams");
		return rdbHelper.fetchTestTypes();
	}
	@Override
	public ArrayList<TestObjective> fetchTestSubTypes(int testId)
			throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
		MySQLRdbHelper rdbHelper = (MySQLRdbHelper) ctx.getBean("ManagerExams");
		return rdbHelper.fetchTestObjectives(testId);
	}
	
	

}
