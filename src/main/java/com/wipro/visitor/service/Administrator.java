package com.wipro.visitor.service;
import java.util.Date;
import java.util.List;

import com.wipro.visitor.bean.VisitorBean;
import com.wipro.visitor.dao.VisitorDAO;

public class Administrator {
	public String addRecord(VisitorBean	bean) {
		VisitorDAO dao=new VisitorDAO();
		if(bean!=null &&
		   bean.getVisitorName()!=null &&
		   bean.getPurpose()!=null &&
		   bean.getContactNo()!=null &&
		   bean.getVisitDate()!=null) {
		   if(bean.getVisitorName().length()<2) {
			   return "INVALID VISITOR NAME";
		   }
		   if(bean.getPurpose().length()<2) {
			   return "INVALID PURPOSE";
		   }
		   if(bean.getContactNo().length()<10) {
			   return "INVALID CONTACT NUMBER";
		   }
		   if(dao.recordExists(bean.getVisitorName(),bean.getVisitDate())) {
			   return "ALREADY EXISTS";
		   }
		   String id=dao.generateVisitorID(bean.getVisitorName(),bean.getVisitDate());
		   bean.setVisitorId(id);
		   return dao.createRecord(bean);
	
		}
		else {
			return "INVALID INPUT";
		}
	}
	
	public VisitorBean	viewRecord(String visitorName, Date visitDate) {
		VisitorDAO dao=new VisitorDAO();
		return dao.fetchRecord(visitorName, visitDate);
	}
	
	public List<VisitorBean>viewAllRecords(){
		VisitorDAO dao=new VisitorDAO();
		return dao.fetchAllRecords();
	}
	
}