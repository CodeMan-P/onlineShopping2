package com.mod.mapper;

import com.mod.bean.Goods;

public interface GoodsMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	int deleteByPrimaryKey(Integer gid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	int insert(Goods record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	int insertSelective(Goods record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	Goods selectByPrimaryKey(Integer gid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	int updateByPrimaryKeySelective(Goods record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	int updateByPrimaryKey(Goods record);
}