package com.mod.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column address.adressId
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	private Integer adressid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column address.uid
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	private Integer uid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column address.address
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	private String address;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column address.def
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	@JsonProperty("default")
	private Boolean def;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column address.aphone
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	private String aphone;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column address.aname
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	private String aname;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column address.adressId
	 * @return  the value of address.adressId
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public Integer getAdressid() {
		return adressid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column address.adressId
	 * @param adressid  the value for address.adressId
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public void setAdressid(Integer adressid) {
		this.adressid = adressid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column address.uid
	 * @return  the value of address.uid
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public Integer getUid() {
		return uid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column address.uid
	 * @param uid  the value for address.uid
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column address.address
	 * @return  the value of address.address
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column address.address
	 * @param address  the value for address.address
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column address.def
	 * @return  the value of address.def
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public Boolean getDef() {
		return def;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column address.def
	 * @param def  the value for address.def
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public void setDef(Boolean def) {
		this.def = def;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column address.aphone
	 * @return  the value of address.aphone
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public String getAphone() {
		return aphone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column address.aphone
	 * @param aphone  the value for address.aphone
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public void setAphone(String aphone) {
		this.aphone = aphone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column address.aname
	 * @return  the value of address.aname
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public String getAname() {
		return aname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column address.aname
	 * @param aname  the value for address.aname
	 * @mbggenerated  Tue Nov 21 09:40:17 CST 2017
	 */
	public void setAname(String aname) {
		this.aname = aname;
	}

	public Address() {
		super();
	}

	public Address(Integer uid, Boolean def, String aphone, String aname, String address) {
		super();
		this.uid = uid;
		this.def = def;
		this.aphone = aphone;
		this.aname = aname;
		this.address = address;
	}
}