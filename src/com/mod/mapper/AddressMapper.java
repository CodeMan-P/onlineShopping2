package com.mod.mapper;

import com.mod.bean.Address;

public interface AddressMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table address
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	int deleteByPrimaryKey(Integer adressid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table address
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	int insert(Address record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table address
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	int insertSelective(Address record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table address
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	Address selectByPrimaryKey(Integer adressid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table address
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	int updateByPrimaryKeySelective(Address record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table address
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	int updateByPrimaryKeyWithBLOBs(Address record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table address
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	int updateByPrimaryKey(Address record);
}