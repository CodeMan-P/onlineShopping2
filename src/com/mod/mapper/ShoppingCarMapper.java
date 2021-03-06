package com.mod.mapper;

import java.util.HashMap;
import java.util.LinkedList;

import org.apache.ibatis.annotations.Param;

import com.mod.bean.ShoppingCar;

public interface ShoppingCarMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table shoppingcar
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	int deleteByPrimaryKey(Integer cid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table shoppingcar
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	int insert(ShoppingCar record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table shoppingcar
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	int insertSelective(ShoppingCar record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table shoppingcar
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	ShoppingCar selectByPrimaryKey(Integer cid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table shoppingcar
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	int updateByPrimaryKeySelective(ShoppingCar record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table shoppingcar
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	int updateByPrimaryKey(ShoppingCar record);

	LinkedList<ShoppingCar> getCarListByUid(@Param("uid") Integer uid);

	LinkedList<HashMap<String, Object>> getCarView(@Param("uid") Integer uid);

	ShoppingCar selectByUGid(@Param("uid") Integer uid, @Param("gid") Integer gid);

	int queryCarNum(@Param("uid") Integer uid);
}