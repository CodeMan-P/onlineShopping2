package com.mod.mapper;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mod.bean.Goods;
import com.mod.bean.GoodsWithBLOBs;

public interface GoodsMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods
	 * @mbggenerated  Thu Nov 23 15:42:31 CST 2017
	 */
	int deleteByPrimaryKey(Integer gid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods
	 * @mbggenerated  Thu Nov 23 15:42:31 CST 2017
	 */
	int insert(Goods record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods
	 * @mbggenerated  Thu Nov 23 15:42:31 CST 2017
	 */
	int insertSelective(Goods record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods
	 * @mbggenerated  Thu Nov 23 15:42:31 CST 2017
	 */
	Goods selectByPrimaryKey(Integer gid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods
	 * @mbggenerated  Thu Nov 23 15:42:31 CST 2017
	 */
	int updateByPrimaryKeySelective(Goods record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods
	 * @mbggenerated  Thu Nov 23 15:42:31 CST 2017
	 */
	int updateByPrimaryKey(Goods record);

	LinkedList<LinkedHashMap<String, Object>> getGoddsByTid(@Param("tid") Integer tid);

	@Select("select * from goods where gname like '%${s}%'")
	LinkedList<LinkedHashMap<String, Object>> getGoddsByRegExp(@Param("s") String s);
}