package com.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.WeakHashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mod.bean.Goods;
import com.mod.mapper.GoodsAndroidMapper;
import com.mod.mapper.GoodsMapper;
import com.service.GoodsService;
import com.util.DbConn;

@Transactional
@Repository
public class GoodsDao {

	@Autowired
	private GoodsMapper gm;
	@Autowired
	private GoodsAndroidMapper gam;

	@Transactional(readOnly = true)
	public Goods getGoods(int gid) {
		Goods g = null;

		g = gm.selectByPrimaryKey(gid);

		return g;
	}

	@Transactional(readOnly = true)
	public LinkedList<LinkedHashMap<String, Object>> getGoddsByTid(Integer tid) {
		LinkedList<LinkedHashMap<String, Object>> list = null;

		list = gm.getGoddsByTid(tid);

		return list;
	}

	@Transactional(readOnly = true)
	public LinkedList<LinkedHashMap<String, Object>> getGoddsByRegExp(String s) {
		LinkedList<LinkedHashMap<String, Object>> list = null;
		list = gm.getGoddsByRegExp(s);

		return list;
	}

	@Transactional(readOnly = true)
	public LinkedList<LinkedHashMap<String, Object>> getGoddsAnd() {
		LinkedList<LinkedHashMap<String, Object>> list = gam.getGoddsAnd();
		return list;
	};

	PreparedStatement pst = null;
	Connection con = null;
	boolean flog = false;
	ResultSet rs = null;

	@Transactional(readOnly = true)
	public ArrayList<Goods> productList(String st, String st1) {

		ArrayList<Goods> productList = new ArrayList<Goods>();
		con = DbConn.getCon();
		try {
			pst = con.prepareStatement("SELECT gid, gname, tid, price, descption, imgpath,filepath,stock FROM goods"
					+ " where gname like '%" + st + "%' ORDER BY price " + st1);

			rs = pst.executeQuery();

			while (rs.next()) {
				Goods b = new Goods();
				b.setGid(rs.getInt("gid"));
				b.setGname(rs.getString("gname"));
				b.setTid(rs.getInt("tid"));
				b.setPrice(rs.getDouble("price"));
				b.setDescption(rs.getString("descption"));
				b.setImgpath(rs.getString("imgpath"));
				b.setFilepath(rs.getString("filepath"));
				b.setStock(rs.getInt("stock"));
				productList.add(b);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbConn.closeConn(rs, pst, con);
		}
		return productList;

	}
}
