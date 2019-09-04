package com.bw.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.entity.Brand;
import com.bw.entity.Category;
import com.bw.entity.Goods;
import com.bw.mapper.GoodsDao;

@Service
public class GoodsServiceImpl implements GoodsService{

	@Resource
	private GoodsDao dao;
	
	public List<Goods> findAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.findAll(map);
	}

	public List<Category> findCateGoryAll() {
		// TODO Auto-generated method stub
		return dao.findCateGoryAll();
	}

	public List<Brand> findBrandByCid(Integer cid) {
		// TODO Auto-generated method stub
		return dao.findBrandByCid(cid);
	}

	public boolean InsertOrUpdate(Goods goods) {
		if (goods.getGid() == null) {
			int num = dao.insertGoods(goods);
			if (num>0) {
				return true;
			}
		}else{
			int num = dao.updateGoods(goods);
			if (num>0) {
				return true;
			}
		}
		return false;
	}

	public Goods findGoodByGid(Integer gid) {
		// TODO Auto-generated method stub
		return dao.findGoodByGid(gid);
	}

	public boolean deleteGoods(String[] gid) {
		int num = dao.deleteGoods(gid);
		
		if (num>0) {
			return true;
		}
		return false;
	}

}
