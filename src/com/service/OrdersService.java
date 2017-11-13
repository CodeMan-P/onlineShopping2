package com.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import com.dao.OrdersDao;
import com.mod.bean.OrderForm;
import com.mod.bean.Orders;

public class OrdersService {
	public static boolean addOrders(Orders orders, LinkedList<OrderForm> orderlist, LinkedList<Integer> buyCids) {
		return OrdersDao.addOrders(orders, orderlist, buyCids);
	}

	public static LinkedList<HashMap<String, Object>> getOrderList(Long oid, Integer uid) {
		return OrdersDao.getOrderList(oid, uid);
	}

	public static LinkedList<HashMap<String, Object>> getOrderList(String oid, Integer uid) {
		return OrdersDao.getOrderList(oid, uid);
	}

	public static boolean updateByOUid(String oid, Integer uid) {
		return OrdersDao.updateByOUid(oid, uid);
	}

	public static boolean updateByOUid(Long oid, Integer uid) {
		return OrdersDao.updateByOUid(oid, uid);
	}

	public static boolean addOrders(Orders orders, OrderForm orderform) {
		return OrdersDao.addOrders(orders, orderform);
	}

	public static LinkedList<LinkedHashMap<String, Object>> getOGViewGoupByOid(Integer uid) {

		return OrdersDao.getOGViewGoupByOid(uid);
	}
}
