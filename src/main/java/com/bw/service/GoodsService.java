package com.bw.service;

import java.util.List;
import java.util.Map;

import com.bw.entity.Brand;
import com.bw.entity.Category;
import com.bw.entity.Goods;

public interface GoodsService {

	public List<Goods> findAll(Map<String, Object> map);

	public List<Category> findCateGoryAll();

	public List<Brand> findBrandByCid(Integer cid);

	public boolean InsertOrUpdate(Goods goods);

	public Goods findGoodByGid(Integer gid);

	public boolean deleteGoods(String[] gid);

}
