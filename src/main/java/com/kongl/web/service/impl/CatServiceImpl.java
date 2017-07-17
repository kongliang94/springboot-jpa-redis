package com.kongl.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.kongl.web.model.Cat;
import com.kongl.web.repository.CatRepository;
import com.kongl.web.service.CatService;

@Service
public class CatServiceImpl implements CatService{

	@Autowired
	private CatRepository catRepository;
	//与@Cacheable不同的是使用@CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
	@CachePut(value="baseCatInfo")
	public void saveCat(Cat cat) {
		catRepository.save(cat);
	}

	@Override
	public int updateCat(Cat cat) {
		// TODO Auto-generated method stub
		return 0;
	}

	//@CacheEvict是用来标注在需要清除缓存元素的方法或类上的。当标记在一个类上时表示其中所有的方法的执行都会触发缓存的清除操作
	@CacheEvict(value="cat")
	public void deleteCat(int id) {
		System.out.println(id);
		
	}

	@Override
	public List<Cat> getCatAll() {	
		return (List<Cat>) catRepository.findAll();
	}

	@Cacheable(value="cat", keyGenerator = "accountKeyGenerator")
	@Override
	public Cat findOneCat(Integer id) {
		System.out.println("开始查询.....");
        try {
            Thread.sleep(3 * 1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("查询结束......");
		Cat cat=catRepository.findOne(id);
		
		return cat;
	}

}
