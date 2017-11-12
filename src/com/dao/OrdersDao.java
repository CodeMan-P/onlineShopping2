package com.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mod.bean.OrderForm;
import com.mod.bean.Orders;
import com.mod.mapper.OrderFormMapper;
import com.mod.mapper.OrdersMapper;
import com.mod.mapper.ShoppingCarMapper;
import com.util.DbConn;

public class OrdersDao {
	private static OrdersMapper om;
	private static OrderFormMapper ofm;
	private static ShoppingCarMapper sc;
	private static SqlSession session = null;

	static {
		try {
			// 此持久层不自动提交
			// 一批操作完成后再提交
			session = DbConn.getFactory().openSession(false);
			om = session.getMapper(OrdersMapper.class);
			ofm = session.getMapper(OrderFormMapper.class);
			sc = session.getMapper(ShoppingCarMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testMethod(){
		LinkedList<HashMap<String, Object>> list=null;
		list = getOrderList(20171110164436L,1);
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static LinkedList<HashMap<String, Object>> getOrderList(Long oid,Integer uid){
		LinkedList<HashMap<String, Object>> list=null;
		list=ofm.getOrderList(oid, uid);
		return list;
	}
	public static LinkedList<HashMap<String, Object>> getOrderList(String oid,Integer uid){
		LinkedList<HashMap<String, Object>> list=null;
		list=ofm.getOrderList(oid, uid);
		return list;
	}	
	static Logger log = Logger.getLogger(OrdersDao.class.getName());
	public static boolean addOrders(Orders orders, LinkedList<OrderForm> orderlist,LinkedList<Integer> buyCids) {
		int i = 0;
		try {
			i = om.insertSelective(orders);
			if (i > 0) {
				for (OrderForm record : orderlist) {
					i = ofm.insertSelective(record);
					if (i <= 0) {
						session.rollback();
						return false;
					}
				}
				for(Integer cid:buyCids){
					i = sc.deleteByPrimaryKey(cid);
					if (i <= 0) {
						session.rollback();
						return false;
					}
				}
			}
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			log.warn(e.getLocalizedMessage());
			return false;
		}
		// 正常插入完成，提交事务
		if (i > 0) {
			try {
				session.commit();
			} catch (Exception e) {
				session.rollback();
				e.printStackTrace();
				log.warn(e.getLocalizedMessage());
				return false;
			}
			orderLog(orders, orderlist);
			return true;
		}
		return false;
	}
	
	private static void orderLog(Orders orders, LinkedList<OrderForm> orderlist){
		ObjectMapper mapper = new ObjectMapper();
		SerializerProvider sp = mapper.getSerializerProvider();
		//sp.setAttribute(list2, te);
		
		sp.setNullValueSerializer(new JsonSerializer<Object>() {
			@Override
			public void serialize(Object arg0, JsonGenerator arg1, SerializerProvider arg2)
					throws IOException, JsonProcessingException {
				arg1.writeString("待付款");
			}
		});
		try {
			log.info("添加新订单("+orders.getOid()+")："+mapper.writerWithDefaultPrettyPrinter().writeValueAsString(orders));
			log.info("订单详情("+orders.getOid()+")："+mapper.writerWithDefaultPrettyPrinter().writeValueAsString(orderlist));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
	}
}
