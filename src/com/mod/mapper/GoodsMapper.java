package com.mod.mapper;

import java.util.LinkedHashMap;
import java.util.LinkedList;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import com.mod.bean.Goods;
@MapperScan
public interface GoodsMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods
	 * @mbggenerated  Mon Nov 27 11:55:23 CST 2017
	 */
	int deleteByPrimaryKey(Integer gid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods
	 * @mbggenerated  Mon Nov 27 11:55:23 CST 2017
	 */
	int insert(Goods record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods
	 * @mbggenerated  Mon Nov 27 11:55:23 CST 2017
	 */
	int insertSelective(Goods record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods
	 * @mbggenerated  Mon Nov 27 11:55:23 CST 2017
	 */
	Goods selectByPrimaryKey(Integer gid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods
	 * @mbggenerated  Mon Nov 27 11:55:23 CST 2017
	 */
	int updateByPrimaryKeySelective(Goods record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table goods
	 * @mbggenerated  Mon Nov 27 11:55:23 CST 2017
	 */
	int updateByPrimaryKey(Goods record);

	LinkedList<LinkedHashMap<String, Object>> getGoddsByTid(@Param("tid") Integer tid);

	@Select("select * from goods where gname like '%${s}%'")
	LinkedList<LinkedHashMap<String, Object>> getGoddsByRegExp(@Param("s") String s);
}