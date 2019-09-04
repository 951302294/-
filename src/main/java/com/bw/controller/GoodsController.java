package com.bw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.entity.Brand;
import com.bw.entity.Category;
import com.bw.entity.Goods;
import com.bw.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class GoodsController {

	@Resource
	private GoodsService service;
	
	@RequestMapping("list.do")
	public String list(Model model,@RequestParam(defaultValue="1") Integer pageNum,String gname,Integer cid){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gname", gname);
		map.put("cid", cid);
		
		PageHelper page = new PageHelper();
		page.startPage(pageNum, 2);
		List<Goods> list = service.findAll(map);
		List<Category> clist = service.findCateGoryAll();	
		PageInfo<Goods> info = new PageInfo<Goods>(list);
		model.addAttribute("info", info);
		model.addAttribute("clist", clist);
		
		return "list";
	}
	
	@RequestMapping("findCateGoryAll.do")
	@ResponseBody
	public List<Category> findCateGoryAll(){
		List<Category> clist = service.findCateGoryAll();
		
		return clist;
	}
	
	@RequestMapping("findBrandByCid.do")
	@ResponseBody
	public List<Brand> findBrandByCid(Integer cid){
		List<Brand> blist = service.findBrandByCid(cid);
		
		return blist;
	}
	
	@RequestMapping("InsertOrUpdate.do")
	@ResponseBody
	public boolean InsertOrUpdate(Goods goods){
		boolean flag = service.InsertOrUpdate(goods);
		
		return flag;
	}
	
	@RequestMapping("findGoodByGid.do")
	@ResponseBody
	public Map<String, Object> findGoodByGid(Integer gid){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Category> clist = service.findCateGoryAll();	
		Goods goods = service.findGoodByGid(gid);
		List<Brand> blist = service.findBrandByCid(goods.getCid());
		
		map.put("clist", clist);
		map.put("goods", goods);
		map.put("blist", blist);
		
		return map;
	}
	
	@RequestMapping("deleteGoods.do")
	@ResponseBody
	public boolean deleteGoods(String ids){
		String[] gid = ids.split(",");
		
		boolean flag = service.deleteGoods(gid);
		
		return flag;
	}
}
