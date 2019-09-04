package com.bw.mapper;

import java.util.List;
import java.util.Map;

import com.bw.entity.Brand;
import com.bw.entity.Category;
import com.bw.entity.Goods;

public interface GoodsDao {

	public List<Goods> findAll(Map<String, Object> map);

	public List<Category> findCateGoryAll();

	public List<Brand> findBrandByCid(Integer cid);

	public int insertGoods(Goods goods);

	public int updateGoods(Goods goods);

	public Goods findGoodByGid(Integer gid);

	public int deleteGoods(String[] gid);

}
