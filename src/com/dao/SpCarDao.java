package com.dao;

import java.util.HashMap;
import java.util.LinkedList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mod.bean.ShoppingCar;
import com.mod.mapper.ShoppingCarMapper;
import com.util.DbConn;

@Transactional
@Repository
public class SpCarDao {
	@Autowired
	private ShoppingCarMapper scm;

	public boolean deleGoods(Integer cid) {
		int i = 0;

		try {
			i = scm.deleteByPrimaryKey(cid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (i > 0) {
			return true;
		}
		return false;
	}

	@Transactional(readOnly = true)
	public LinkedList<HashMap<String, Object>> getCarView(Integer uid) {
		LinkedList<HashMap<String, Object>> list = null;
		try {
			list = scm.getCarView(uid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Transactional(readOnly = true)
	public LinkedList<ShoppingCar> getCarListByUid(Integer uid) {
		LinkedList<ShoppingCar> list = null;
		try {
			list = scm.getCarListByUid(uid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Transactional(readOnly = true)
	public int getCarNum(Integer uid) {
		int i = 0;

		i = scm.queryCarNum(uid);

		return i;
	}

	public boolean updateByPrimaryKeySelective(ShoppingCar car) {
		int i = 0;
		try {
			i = scm.updateByPrimaryKeySelective(car);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("更新失败");
		}
		if (i > 0) {
			return true;
		} else {
			throw new RuntimeException("更新失败");
		}
	}

	public boolean addGoods(ShoppingCar car) {
		int i = 0;
		ShoppingCar temp = null;
		try {
			temp = scm.selectByUGid(car.getUid(), car.getGid());
		} catch (Exception e) {
			throw new RuntimeException("添加失败");
		}

		try {
			if (temp != null && temp.getGnum() != 0) {
				// 购物车表去重复
				car.setGnum(car.getGnum() + temp.getGnum());
				// 设置主键，主键自增，增加时不用设置
				car.setCid(temp.getCid());
				i = scm.updateByPrimaryKey(car);
			} else {
				i = scm.insertSelective(car);
			}
		} catch (Exception e) {
			throw new RuntimeException("添加失败");
		}
		if (i > 0) {
			return true;
		}
		return false;
	}
}
