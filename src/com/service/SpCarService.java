package com.service;

import com.dao.SpCarDao;
import com.mod.bean.ShoppingCar;

public class SpCarService {
	public static boolean addGoods(ShoppingCar car){
		return SpCarDao.addGoods(car);
	}
	public static int getCarNum(Integer uid){
		return SpCarDao.getCarNum(uid);
	}
}
