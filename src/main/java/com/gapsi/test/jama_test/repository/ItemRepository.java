package com.gapsi.test.jama_test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gapsi.test.jama_test.repository.model.Item;

public interface ItemRepository extends JpaRepository<Item,Long>{
	Item findById(Long id);
	
//	List<Item> findAll();
}
