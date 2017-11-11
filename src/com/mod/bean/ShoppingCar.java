package com.mod.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShoppingCar {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column shoppingcar.cid
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	private Integer cid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column shoppingcar.addGoodsTime
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	@JsonFormat(timezone = "GTM+8", pattern = "yyyy-MM-dd")
	private Date addgoodstime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column shoppingcar.uid
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	private Integer uid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column shoppingcar.gid
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	private Integer gid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column shoppingcar.gnum
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	private Integer gnum;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column shoppingcar.cid
	 * @return  the value of shoppingcar.cid
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	public Integer getCid() {
		return cid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column shoppingcar.cid
	 * @param cid  the value for shoppingcar.cid
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	public void setCid(Integer cid) {
		this.cid = cid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column shoppingcar.addGoodsTime
	 * @return  the value of shoppingcar.addGoodsTime
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	public Date getAddgoodstime() {
		return addgoodstime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column shoppingcar.addGoodsTime
	 * @param addgoodstime  the value for shoppingcar.addGoodsTime
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	public void setAddgoodstime(Date addgoodstime) {
		this.addgoodstime = addgoodstime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column shoppingcar.uid
	 * @return  the value of shoppingcar.uid
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	public Integer getUid() {
		return uid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column shoppingcar.uid
	 * @param uid  the value for shoppingcar.uid
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column shoppingcar.gid
	 * @return  the value of shoppingcar.gid
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	public Integer getGid() {
		return gid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column shoppingcar.gid
	 * @param gid  the value for shoppingcar.gid
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column shoppingcar.gnum
	 * @return  the value of shoppingcar.gnum
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	public Integer getGnum() {
		return gnum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column shoppingcar.gnum
	 * @param gnum  the value for shoppingcar.gnum
	 * @mbggenerated  Fri Nov 10 12:42:34 CST 2017
	 */
	public void setGnum(Integer gnum) {
		this.gnum = gnum;
	}
}