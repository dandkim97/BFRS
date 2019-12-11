package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Login;
import com.revature.services.LoginService;
import com.revature.services.hibernate.LoginServiceHibernate;

@Component
public class UserRegistrationDelegate implements FrontControllerDelegate{
	
	private Logger log = Logger.getLogger(UserRegistrationDelegate.class);
	private LoginService ls = new LoginServiceHibernate();
	private ObjectMapper om = new ObjectMapper();
	
	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		log.trace(req.getMethod() + " received by user registration delegate.");
		//HttpSession session = req.getSession();
		switch (req.getMethod()) {
		case "POST":
			addNewCustomer(req, resp);
			break;
		default:
			break;
		}
		
	}

	private void addNewCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		log.trace("Creating new customer!");
		//HttpSession session = req.getSession();
		Login l = new Login();
		String username = req.getParameter("username");
		String pswrd = req.getParameter("pswrd");
		String first_name = req.getParameter("first_name");
		String last_name = req.getParameter("last_name");
		l.setUsername(username);
		l.setPswrd(pswrd);
		l.setFirst_name(first_name);
		l.setLast_name(last_name);
		l.setIs_admin(0);
		l.setLoyalty_status(0);
		ls.addLogin(l);
		if(l.getId() == 0 | l.getId() == null) {
			resp.sendError(HttpServletResponse.SC_CONFLICT, "User with same username already exisits.");
		} else {
			respondWithLogin(resp,l);
		}
		
	}

	private void respondWithLogin(HttpServletResponse resp, Login l) throws IOException {
		resp.setStatus(HttpServletResponse.SC_CREATED);
		String login = om.writeValueAsString(l);
		StringBuilder sb = new StringBuilder("{\"login\":");
		sb.append(login);
		sb.append("}");
		resp.getWriter().write(sb.toString());
		
	}
	
}
