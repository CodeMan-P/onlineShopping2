package com.mod.mapper;

import com.mod.bean.ShoppingCar;

public interface ShoppingCarMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table shoppingcar
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	int deleteByPrimaryKey(Integer cid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table shoppingcar
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	int insert(ShoppingCar record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table shoppingcar
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	int insertSelective(ShoppingCar record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table shoppingcar
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	ShoppingCar selectByPrimaryKey(Integer cid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table shoppingcar
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	int updateByPrimaryKeySelective(ShoppingCar record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table shoppingcar
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	int updateByPrimaryKey(ShoppingCar record);
}