package com.mod.mapper;

import java.util.LinkedList;

import org.apache.ibatis.annotations.Param;

import com.mod.bean.Address;
import com.mod.bean.ShoppingCar;

public interface AddressMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table address
	 * @mbggenerated  Sun Nov 12 12:54:50 CST 2017
	 */
	int deleteByPrimaryKey(Integer adressid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table address
	 * @mbggenerated  Sun Nov 12 12:54:50 CST 2017
	 */
	int insert(Address record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table address
	 * @mbggenerated  Sun Nov 12 12:54:50 CST 2017
	 */
	int insertSelective(Address record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table address
	 * @mbggenerated  Sun Nov 12 12:54:50 CST 2017
	 */
	Address selectByPrimaryKey(Integer adressid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table address
	 * @mbggenerated  Sun Nov 12 12:54:50 CST 2017
	 */
	int updateByPrimaryKeySelective(Address record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table address
	 * @mbggenerated  Sun Nov 12 12:54:50 CST 2017
	 */
	int updateByPrimaryKeyWithBLOBs(Address record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table address
	 * @mbggenerated  Sun Nov 12 12:54:50 CST 2017
	 */
	int updateByPrimaryKey(Address record);

	LinkedList<Address> getAdrsListByUid(@Param("uid")Integer uid);
}