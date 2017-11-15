package com.mod.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mod.bean.Users;

public interface UsersMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table users
	 * 
	 * @mbggenerated Mon Nov 13 11:22:15 CST 2017
	 */
	int deleteByPrimaryKey(Integer uid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table users
	 * 
	 * @mbggenerated Mon Nov 13 11:22:15 CST 2017
	 */
	int insert(Users record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table users
	 * 
	 * @mbggenerated Mon Nov 13 11:22:15 CST 2017
	 */
	int insertSelective(Users record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table users
	 * 
	 * @mbggenerated Mon Nov 13 11:22:15 CST 2017
	 */
	Users selectByPrimaryKey(Integer uid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table users
	 * 
	 * @mbggenerated Mon Nov 13 11:22:15 CST 2017
	 */
	int updateByPrimaryKeySelective(Users record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table users
	 * 
	 * @mbggenerated Mon Nov 13 11:22:15 CST 2017
	 */
	int updateByPrimaryKeyWithBLOBs(Users record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table users
	 * 
	 * @mbggenerated Mon Nov 13 11:22:15 CST 2017
	 */
	int updateByPrimaryKey(Users record);

	@Select("SELECT * FROM users WHERE uname = #{uname} and upwd = #{upwd}")
	Users getUser(@Param("uname") String uname, @Param("upwd") String upwd);
}