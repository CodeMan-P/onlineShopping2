package com.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.mod.bean.Goods;
import com.mod.mapper.GoodsMapper;
import com.tests.log4jExample;
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
}
