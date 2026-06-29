package com.wipro.visitor.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.visitor.bean.VisitorBean;
import com.wipro.visitor.service.Administrator;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Administrator admin=new Administrator();
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String addRecord(HttpServletRequest request) {
    	try {
    	VisitorBean bean=new VisitorBean();
    	bean.setVisitorName(request.getParameter("visitorName"));
    	String date=request.getParameter("visitDate");
    	SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd");
    	Date temp=sdf.parse(date);
    	bean.setVisitDate(temp);
    	bean.setPurpose(request.getParameter("purpose"));
    	bean.setContactNo(request.getParameter("contactNo"));
    	bean.setRemarks(request.getParameter("remarks"));
    	return admin.addRecord(bean);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return "FAIL";
    	}
    	
    }
    
    public VisitorBean viewRecord(HttpServletRequest request) {
    	VisitorBean bean=null;
    	try {
    	   String date=request.getParameter("visitDate");
    	   SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
    	   Date temp=sdf.parse(date);
    	   bean= admin.viewRecord(request.getParameter("visitorName"),temp);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return bean;
    	
    }
    
    public List<VisitorBean>viewAllRecords(HttpServletRequest request){
    	return admin.viewAllRecords();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation=request.getParameter("operation");
		if(operation.equals("newRecord")) {
			String res=addRecord(request);
			if(res.equals("FAIL")||
			   res.equals("INVALID INPUT") ||
			   res.equals("INVALID PURPOSE") ||
			   res.equals("INVALID VISITOR NAME") ||
			   res.equals("INVALID CONTACT NUMBER") ||
	           res.equals("ALREADY EXISTS")) {
				response.sendRedirect("error.html");
			}
			else
				response.sendRedirect("success.html");
			
		}
		else if (operation.equals("viewRecord")) {
			VisitorBean bean=viewRecord(request);
				request.setAttribute("visitor",bean);
				RequestDispatcher rd=request.getRequestDispatcher("displayVisitor.jsp");
				rd.forward(request, response);
				}
		
		else if(operation.equals("viewAllRecords")) {
			List<VisitorBean> bean=viewAllRecords(request);
				request.setAttribute("visitor",bean);
				RequestDispatcher rd=request.getRequestDispatcher("displayAllVisitors.jsp");
				rd.forward(request, response);
			}
		}
		
	}

