package com.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.WeakHashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mod.bean.Goods;
import com.mod.mapper.GoodsAndroidMapper;
import com.mod.mapper.GoodsMapper;
import com.service.GoodsService;
import com.util.DbConn;

public class GoodsDao {
	private static GoodsMapper gm;
	private static SqlSession session = null;
	private static GoodsAndroidMapper gam;
	static {
		try {
			session = DbConn.getFactory().openSession();
			gm = session.getMapper(GoodsMapper.class);
			gam = session.getMapper(GoodsAndroidMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static Logger log = Logger.getLogger(GoodsDao.class.getName());

	public static Goods getGoods(int gid) {
		Goods g = null;

		try {
			g = gm.selectByPrimaryKey(gid);
			if (g == null) {
				log.warn(gid + "<->商品不存在！");
			}

		} catch (Exception e) {
			log.warn(e.getLocalizedMessage());
		}

		return g;
	}

	public static LinkedList<LinkedHashMap<String, Object>> getGoddsByTid(Integer tid) {
		LinkedList<LinkedHashMap<String, Object>> list = null;

		try {
			list = gm.getGoddsByTid(tid);
		} catch (Exception e) {
			log.warn(e.getLocalizedMessage());
			e.printStackTrace();
		}

		return list;
	}

	public static LinkedList<LinkedHashMap<String, Object>> getGoddsByRegExp(String s) {
		LinkedList<LinkedHashMap<String, Object>> list = null;
		try {
			list = gm.getGoddsByRegExp(s);
		} catch (Exception e) {
			log.warn(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return list;
	}

	@Test
	public void testMethod() {
		LinkedList<LinkedHashMap<String, Object>> list = GoodsService.getGoddsAnd();
		LinkedHashMap<String, Object> result = new LinkedHashMap<String, Object>();
		result.put("code", 0);
		result.put("message", "OK");
		result.put("total", 100);
		result.put("page_size", 6);
		result.put("data", list);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		String json;
		try {
			String path = System.getProperty("user.dir")+File.separatorChar+"123.json";
			File file = new File(path);
			file.createNewFile();
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
			FileWriter fw = new FileWriter(file);
			fw.write(json.toCharArray());
			fw.close();
			WeakHashMap<String, Object> whm = mapper.readValue(json, WeakHashMap.class);
			json = mapper.writeValueAsString(whm);
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result));
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		LinkedList<LinkedHashMap<String, Object>> list = getGoddsAnd();
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.setSerializationInclusion(Include.NON_NULL);
//		try {
//			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list));
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//		LinkedList<LinkedHashMap<String, Object>> list = getGoddsByRegExp("为");
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list));
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public static LinkedList<LinkedHashMap<String, Object>> getGoddsAnd(){
		LinkedList<LinkedHashMap<String, Object>> list =gam.getGoddsAnd();
		return list;
	};
	
	static PreparedStatement pst=null;
	static Connection con=null;
	static boolean flog=false;
	static ResultSet rs=null;
    public static ArrayList<Goods> productList(String st,String st1){
    	
    	ArrayList<Goods> productList=new ArrayList<Goods>();
    con=	DbConn.getCon();
    try {
		pst=con.prepareStatement("SELECT gid, gname, tid, price, descption, imgpath,filepath,stock FROM goods" +
                " where gname like '%"+st+"%' ORDER BY price "+st1);
	
   rs= pst.executeQuery();
   
     while(rs.next()){
    	 Goods b=new Goods();
    	  b.setGid(rs.getInt("gid"));
		   b.setGname(rs.getString("gname"));
		   b.setTid(rs.getInt("tid"));
		   b.setPrice(rs.getDouble("price"));
		   b.setDescption(rs.getString("descption"));
		   b.setImgpath(rs.getString("imgpath"));
		   b.setFilepath(rs.getString("filepath"));
		   b.setStock(rs.getInt("stock"));
    	 productList.add(b);
     }
    
    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    finally{
    	DbConn.closeConn(rs, pst, con);
    }
    	return productList;
    	
    	
    }
}
