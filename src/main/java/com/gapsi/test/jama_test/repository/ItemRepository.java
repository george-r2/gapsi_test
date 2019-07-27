package com.gapsi.test.jama_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gapsi.test.jama_test.repository.model.Item;

public interface ItemRepository extends JpaRepository<Item,Long>{
	Item findById(Long id);
}
