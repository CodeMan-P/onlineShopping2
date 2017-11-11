package com.dao;


import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mod.bean.Users;
import com.mod.mapper.UsersMapper;
import com.util.DbConn;

public class UsersDao {
    static Logger log = Logger.getLogger(UsersDao.class.getName());
    private static UsersMapper um;
    private static SqlSession session = null;
    static {  
        try {  
            session = DbConn.getFactory().openSession(); 
            um = session.getMapper(UsersMapper.class);
        } catch (Exception e) {  
        	e.printStackTrace();
        	log.warn(e.getLocalizedMessage());
        }  
    }
    @Test
   public void testMethdo(){
    	Users users = new Users("xiaomin","123");
    	users = findUser(users);
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		System.out.println(users);
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(users));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    }
	public static Users findUser(Users users){
    	 Users temp = (Users) um.getUser(users.getUname(),users.getUpwd());
    	 return temp;
	}
	public static String addUser(Users users){
		String res= null;
		try{
			int temp = um.insert(users);
			if(temp >0){
				res="注册成功！";
			}
   	 }catch(Exception e){
   		 res=e.getLocalizedMessage();
   	 }
   		 return res;
   	 
	}
	
}
