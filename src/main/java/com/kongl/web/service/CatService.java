package com.kongl.web.service;

import java.util.List;

import com.kongl.web.model.Cat;

public interface CatService {

	
	public void saveCat(Cat cat);
	
	public int updateCat(Cat cat);
	
	public void deleteCat(int id);
	
	//查询数据.
	public List<Cat> getCatAll();

	public Cat findOneCat(Integer id);
}
