package com.mod.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Goods {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column goods.gid
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	private Integer gid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column goods.gname
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	private String gname;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column goods.tid
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	private Integer tid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column goods.price
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	private Double price;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column goods.descption
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	private String descption;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column goods.imgPath
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	private String imgpath;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column goods.filePath
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	private String filepath;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column goods.stock
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	private Integer stock;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column goods.gid
	 * @return  the value of goods.gid
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	public Integer getGid() {
		return gid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column goods.gid
	 * @param gid  the value for goods.gid
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column goods.gname
	 * @return  the value of goods.gname
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	public String getGname() {
		return gname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column goods.gname
	 * @param gname  the value for goods.gname
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	public void setGname(String gname) {
		this.gname = gname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column goods.tid
	 * @return  the value of goods.tid
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	public Integer getTid() {
		return tid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column goods.tid
	 * @param tid  the value for goods.tid
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	public void setTid(Integer tid) {
		this.tid = tid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column goods.price
	 * @return  the value of goods.price
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column goods.price
	 * @param price  the value for goods.price
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column goods.descption
	 * @return  the value of goods.descption
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	public String getDescption() {
		return descption;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column goods.descption
	 * @param descption  the value for goods.descption
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	public void setDescption(String descption) {
		this.descption = descption;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column goods.imgPath
	 * @return  the value of goods.imgPath
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	public String getImgpath() {
		return imgpath;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column goods.imgPath
	 * @param imgpath  the value for goods.imgPath
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column goods.filePath
	 * @return  the value of goods.filePath
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	public String getFilepath() {
		return filepath;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column goods.filePath
	 * @param filepath  the value for goods.filePath
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column goods.stock
	 * @return  the value of goods.stock
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	public Integer getStock() {
		return stock;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column goods.stock
	 * @param stock  the value for goods.stock
	 * @mbggenerated  Mon Nov 13 11:22:15 CST 2017
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}
}