package com.kongl.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.kongl.web.model.Cat;

/**
 * Repository -- 是接口 ，不是class.
 */
public interface CatRepository extends CrudRepository<Cat, Integer>{

}
