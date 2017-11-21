package com.mod.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderForm {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column orderform.oid
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	private String oid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column orderform.gid
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	private Integer gid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column orderform.gnum
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	private Integer gnum;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column orderform.SubTotal
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	private Double subtotal;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column orderform.descption
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	private String descption;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column orderform.uid
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	private Integer uid;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column orderform.oid
	 * @return  the value of orderform.oid
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public String getOid() {
		return oid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column orderform.oid
	 * @param oid  the value for orderform.oid
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public void setOid(String oid) {
		this.oid = oid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column orderform.gid
	 * @return  the value of orderform.gid
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public Integer getGid() {
		return gid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column orderform.gid
	 * @param gid  the value for orderform.gid
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column orderform.gnum
	 * @return  the value of orderform.gnum
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public Integer getGnum() {
		return gnum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column orderform.gnum
	 * @param gnum  the value for orderform.gnum
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public void setGnum(Integer gnum) {
		this.gnum = gnum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column orderform.SubTotal
	 * @return  the value of orderform.SubTotal
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public Double getSubtotal() {
		return subtotal;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column orderform.SubTotal
	 * @param subtotal  the value for orderform.SubTotal
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column orderform.descption
	 * @return  the value of orderform.descption
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public String getDescption() {
		return descption;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column orderform.descption
	 * @param descption  the value for orderform.descption
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public void setDescption(String descption) {
		this.descption = descption;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column orderform.uid
	 * @return  the value of orderform.uid
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public Integer getUid() {
		return uid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column orderform.uid
	 * @param uid  the value for orderform.uid
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
}