package com.mod.mapper;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import org.apache.ibatis.annotations.Param;

import com.mod.bean.Orders;

public interface OrdersMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table orders
	 * 
	 * @mbggenerated Mon Nov 13 11:22:15 CST 2017
	 */
	int insert(Orders record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table orders
	 * 
	 * @mbggenerated Mon Nov 13 11:22:15 CST 2017
	 */
	int insertSelective(Orders record);

	int updateByOUid(@Param("oid") String oid, @Param("uid") Integer uid);

	int updateByOUid(@Param("oid") Long oid, @Param("uid") Integer uid);

	int deleByOUid(@Param("oid") Long oid, @Param("uid") Integer uid);

	LinkedList<LinkedHashMap<String, Object>> getOGViewGoupByOid(@Param("uid") Integer uid);
	// LinkedList<HashMap<String,Object>>
	// getOGViewGoupByOid(@Param("uid")Integer uid);
	// LinkedHashMap<String, Object> getOGViewGoupByOid(@Param("uid")Integer
	// uid);
}