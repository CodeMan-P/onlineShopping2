package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mod.bean.RoleBean;
import com.mod.bean.UserBean;
import com.util.DbConn;


public class RoleUserDao {
	
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	boolean flog=false;
	
	public ArrayList<RoleBean> getRoleList() throws ClassNotFoundException, SQLException{
		RoleBean rb;
		
		ArrayList<RoleBean> list=new ArrayList<RoleBean>();
		con=DbConn.getCon();
		String sql="select roleid,rolename from role";
		pst=con.prepareStatement(sql);
		rs=pst.executeQuery();
		while (rs.next()){
			rb=new RoleBean();
			rb.setRoleid(rs.getInt("roleid"));
			rb.setRolename(rs.getString("rolename"));
			
			list.add(rb);	
			
		}
		DbConn.closeConn(rs, pst, con);
		return list;
	}
	public ArrayList<UserBean> getUserList(int id) throws ClassNotFoundException, SQLException{
		
		UserBean ub;
		ArrayList<UserBean> list =new ArrayList<UserBean>();
		con=DbConn.getCon();
		String sql="select userid,username from r_user where roleid=?";
		pst=con.prepareStatement(sql);
		pst.setInt(1, id);
		rs=pst.executeQuery();
		while(rs.next()){
			ub =new UserBean();
			ub.setUserid(rs.getInt("userid"));
			ub.setUsername(rs.getString("username"));
			
			list.add(ub);
		}
		DbConn.closeConn(rs, pst, con);
		return list;
	}
}
