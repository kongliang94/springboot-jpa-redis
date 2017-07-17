package com.kongl.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kongl.web.model.Cat;
import com.kongl.web.service.CatService;

@RestController
public class CatController {

	@Autowired
	private CatService catService;
	
	
	@RequestMapping(value = "/cat/{id}", method = RequestMethod.GET)
    public Cat findOne(@PathVariable("id") Integer id) {
		long beginTime=System.currentTimeMillis();
		Cat cat=catService.findOneCat(id);
		long time=System.currentTimeMillis()-beginTime;
		System.out.println(time);
		return cat;
    }
	@RequestMapping(value = "/cat", method = RequestMethod.POST)
    public void createCat(@RequestBody Cat cat) {
		catService.saveCat(cat);
    }
	
	@RequestMapping(value = "/cat/{id}", method = RequestMethod.DELETE)
    public void modifyCity(@PathVariable("id") Integer id) {
		catService.deleteCat(id);
    }
	
}
