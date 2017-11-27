package com.mod.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mod.bean.Qrcheck;

public interface QrcheckMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table qrcheck
	 * @mbggenerated  Mon Nov 27 11:55:23 CST 2017
	 */
	int insert(Qrcheck record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table qrcheck
	 * @mbggenerated  Mon Nov 27 11:55:23 CST 2017
	 */
	int insertSelective(Qrcheck record);
	@Select("select * from qrcheck where uuid = #{UUID,jdbcType=VARCHAR}")
    Qrcheck selectByUUID(@Param("UUID")String UUID);
    @Delete("delete from qrcheck where uuid = #{UUID,jdbcType=VARCHAR}")
    int deleteByUUID(@Param("UUID")String UUID);
    @Update("update qrcheck set status = #{status} where uuid = #{UUID,jdbcType=VARCHAR}")
    int changeStatus(@Param("UUID")String UUID,@Param("status")Integer status);
    
    int update(Qrcheck record);
}