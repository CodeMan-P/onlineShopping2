package com.mod.mapper;

import com.mod.bean.GoodsType;

public interface GoodsTypeMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goodstype
	 * @mbggenerated  Mon Nov 27 11:55:23 CST 2017
	 */
	int deleteByPrimaryKey(Integer tid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goodstype
	 * @mbggenerated  Mon Nov 27 11:55:23 CST 2017
	 */
	int insert(GoodsType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goodstype
	 * @mbggenerated  Mon Nov 27 11:55:23 CST 2017
	 */
	int insertSelective(GoodsType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goodstype
	 * @mbggenerated  Mon Nov 27 11:55:23 CST 2017
	 */
	GoodsType selectByPrimaryKey(Integer tid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goodstype
	 * @mbggenerated  Mon Nov 27 11:55:23 CST 2017
	 */
	int updateByPrimaryKeySelective(GoodsType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goodstype
	 * @mbggenerated  Mon Nov 27 11:55:23 CST 2017
	 */
	int updateByPrimaryKey(GoodsType record);
}