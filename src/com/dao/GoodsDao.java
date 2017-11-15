package com.dao;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mod.bean.Goods;
import com.mod.mapper.GoodsMapper;
import com.util.DbConn;

public class GoodsDao {
	    private static GoodsMapper gm;
	    private static SqlSession session = null;
	    static {  
	        try {  
	            session = DbConn.getFactory().openSession(); 
	            gm = session.getMapper(GoodsMapper.class);
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }
	    static Logger log = Logger.getLogger(GoodsDao.class.getName());
	    public static Goods getGoods(int gid){
	    	Goods g = null;
	    	
			try{
				 g = gm.selectByPrimaryKey(gid);
				if(g ==null){
				log.warn(gid+"<->商品不存在！");
				}
	   	 
			}catch(Exception e){
				log.warn(e.getLocalizedMessage());
	   	 }
			
	    	return g;
	    }
	    public static LinkedList<LinkedHashMap<String,Object>> getGoddsByTid(Integer tid){
	    	LinkedList<LinkedHashMap<String,Object>> list = null;
	    	
	    	try {
				list = gm.getGoddsByTid(1);
	    	} catch (Exception e) {
	    		log.warn(e.getLocalizedMessage());
	    		e.printStackTrace();
			}
	    	
	    	return list;
	    }
	    public static LinkedList<LinkedHashMap<String,Object>> getGoddsByRegExp(String s){
	    	LinkedList<LinkedHashMap<String,Object>> list = null;
	    	try {
				list = gm.getGoddsByRegExp(s);
	    	} catch (Exception e) {
	    		log.warn(e.getLocalizedMessage());
	    		e.printStackTrace();
			}
	    	return list;
	    }
	    @Test
	    public void testMethod(){
	    	LinkedList<LinkedHashMap<String,Object>> list =getGoddsByRegExp("为");
	    	ObjectMapper mapper = new ObjectMapper();
	    	try {
				System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}
