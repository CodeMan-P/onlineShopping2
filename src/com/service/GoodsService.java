package com.service;

import com.dao.GoodsDao;
import com.mod.bean.Goods;

public class GoodsService {
	public static Goods getGoods(int gid) {

		return GoodsDao.getGoods(gid);
	}

}
