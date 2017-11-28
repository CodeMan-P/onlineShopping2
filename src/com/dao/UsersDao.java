package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mod.bean.Address;
import com.mod.bean.Users;
import com.mod.mapper.AddressMapper;
import com.mod.mapper.UsersMapper;
import com.util.DbConn;

public class UsersDao {
	static Logger log = Logger.getLogger(UsersDao.class.getName());
	private static UsersMapper um;
	private static AddressMapper am;
	private static SqlSession session = null;

	static {
		try {
			session = DbConn.getFactory().openSession();
			um = session.getMapper(UsersMapper.class);
			am = session.getMapper(AddressMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
			log.warn(e.getLocalizedMessage());
		}
	}
	public static boolean updateByPrimaryKeySelective(Users record){
		int i = 0;
		try {
			i = um.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		if(i>0){
			return true;
		}
		return false;
	}

	@Test
	public void testMethdo() {
		ObjectMapper mapper = new ObjectMapper();
		LinkedList<Address> list = getAdress(1);
		try {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	public static boolean addAddress(Address address) {
		int i = 0;

		try {
			if(address.getDef()){
				//其他全部设置为非默认
				Connection con = DbConn.getCon();
				PreparedStatement pst = con.prepareStatement("update address set def = 0 where uid = ?");
				pst.setInt(1, address.getUid());
				pst.executeUpdate();
				DbConn.closeConn(null, pst, con);
			}
			i = am.insertSelective(address);
		} catch (Exception e) {
			log.warn(e.getLocalizedMessage());
			e.printStackTrace();
			return false;
		}
		if (i > 0) {
			return true;
		}
		return false;
	}

	public static boolean editAddress(Address address) {
		int i = 0;

		try {
			if(address.getDef()){
				//其他全部设置为非默认
				Connection con = DbConn.getCon();
				PreparedStatement pst = con.prepareStatement("update address set def = 0 where uid = ?");
				pst.setInt(1, address.getUid());
				pst.executeUpdate();
				DbConn.closeConn(null, pst, con);
			}
			i = am.updateByPrimaryKeySelective(address);
		} catch (Exception e) {
			log.warn(e.getLocalizedMessage());
			e.printStackTrace();
			return false;
		}
		if (i > 0) {
			return true;
		}
		return false;
	}

	public static boolean deleAddress(Integer addressId) {
		int i = 0;

		try {
			
			
			Address address = am.selectByPrimaryKey(addressId);
			int uid = address.getUid();
			Connection con = DbConn.getCon();
			PreparedStatement pst = con.prepareStatement("select * from address where def = 1 and uid = ?");
			pst.setInt(1, address.getUid());
			i = am.deleteByPrimaryKey(addressId);
			ResultSet rs = pst.executeQuery();
			if(!rs.next()){
				ResultSet temp = pst.executeQuery("select * from address where uid = "+address.getUid());
				if(temp.next()){
					String sql1="SELECT adressId FROM address WHERE  uid = "+address.getUid()+" ORDER BY adressId LIMIT 1";
					ResultSet temp2 = pst.executeQuery(sql1);
					int aid = -1;
					if(temp2.next()){
						aid = temp2.getInt("adressId");
						Address a = new Address();
						a.setAdressid(aid);
						a.setDef(true);
						a.setUid(uid);
						System.out.println(aid);
						editAddress(a);
					}
					if(temp2!=null){
						temp2.close();
					}
				}
				if(temp != null){
					temp.close();
				}
			}
			DbConn.closeConn(rs, pst, con);
			
		} catch (Exception e) {
			log.warn(e.getLocalizedMessage());
			e.printStackTrace();
			return false;
		}
		if (i > 0) {
			return true;
		}
		return false;
	}

	public static LinkedList<Address> getAdress(Integer uid) {
		LinkedList<Address> list = am.getAdrsListByUid(uid);
		return list;
	}

	public static Users findUser(Users users) {
		Users temp = (Users) um.getUser(users.getUname(), users.getUpwd());
		return temp;
	}

	public static String addUser(Users users) {
		String res = null;
		try {
			int temp = um.insert(users);
			if (temp > 0) {
				res = "注册成功！";
			}
		} catch (Exception e) {
			res = e.getLocalizedMessage();
		}
		return res;

	}

}
