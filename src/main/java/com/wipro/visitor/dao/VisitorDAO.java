package com.wipro.visitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wipro.visitor.bean.VisitorBean;
import com.wipro.visitor.util.DBUtil;

public class VisitorDAO {
	public String createRecord(VisitorBean bean) {
		
		try {
			Connection con=DBUtil.getDBConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO VISITOR_TB VALUES(?,?,?,?,?,?)");
			ps.setString(1,bean.getVisitorId());
			ps.setString(2,bean.getVisitorName());
			ps.setString(3, bean.getPurpose());
			ps.setDate(4,new java.sql.Date(bean.getVisitDate().getTime()));
			ps.setString(5,bean.getContactNo());
			ps.setString(6,bean.getRemarks());
			
			int rows=ps.executeUpdate();
			con.commit();
			ps.close();
			con.close();
			if(rows>0)
				return bean.getVisitorId();
			else
				return "FAIL";
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "FAIL";
	}
	
	public VisitorBean fetchRecord(String visitorName, Date visitDate) {
		VisitorBean bean=null;
		try {
			Connection con=DBUtil.getDBConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM VISITOR_TB WHERE VISITORNAME=? AND VISITDATE=?");
			ps.setString(1,visitorName);
			ps.setDate(2,new java.sql.Date(visitDate.getTime()));
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				bean=new VisitorBean();
				bean.setVisitorId(rs.getString(1));
				bean.setVisitorName(rs.getString(2));
				bean.setPurpose(rs.getString(3));
				bean.setVisitDate(new java.sql.Date(rs.getDate(4).getTime()));
				bean.setContactNo(rs.getString(5));
				bean.setRemarks(rs.getString(6));
			}
			rs.close();
			ps.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return bean;
	}
	
	public String generateVisitorID(String visitorName, Date visitDate) {
		DateFormat f = new SimpleDateFormat("yyyyMMdd");
		String temp = f.format(visitDate);
		String name=visitorName;
		int seq=0;
		try {
			Connection con=DBUtil.getDBConnection();
			PreparedStatement ps=con.prepareStatement("SELECT VISITOR_SEQ.NEXTVAL FROM DUAL");
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				seq=rs.getInt(1);
			}
			rs.close();
			ps.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return temp+name.substring(0,2).toUpperCase()+seq;
	}
	
	public boolean recordExists(String visitorName, Date visitDate) {
	   try {
		   Connection con=DBUtil.getDBConnection();
		   PreparedStatement ps=con.prepareStatement("SELECT 1 FROM VISITOR_TB WHERE VISITORNAME=? AND VISITDATE=?");
		   ps.setString(1,visitorName);
		   ps.setDate(2, new java.sql.Date(visitDate.getTime()));
		   ResultSet rs=ps.executeQuery();
		   if(rs.next()) {
			   return true;
		   }
		   rs.close();
		   ps.close();
		   con.close();
		   return false;
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   return false;
	}
	
	public List<VisitorBean> fetchAllRecords(){
		List<VisitorBean> list=new ArrayList<>();
		VisitorBean bean=null;
		try {
			Connection con=DBUtil.getDBConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM VISITOR_TB");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				bean=new VisitorBean();
				bean.setVisitorId(rs.getString(1));
				bean.setVisitorName(rs.getString(2));
				bean.setPurpose(rs.getString(3));
				bean.setVisitDate(new java.sql.Date(rs.getDate(4).getTime()));
				bean.setContactNo(rs.getString(5));
				bean.setRemarks(rs.getString(6));
				list.add(bean);				
			}
			rs.close();
			ps.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
}
