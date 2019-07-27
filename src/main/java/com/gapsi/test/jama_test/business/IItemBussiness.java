package com.gapsi.test.jama_test.business;

import com.gapsi.test.jama_test.beans.ItemBean;
import com.gapsi.test.jama_test.exception.DataAccessException;
import com.gapsi.test.jama_test.exception.JamaException;
import com.gapsi.test.jama_test.exception.NonExistingItemException;
import com.gapsi.test.jama_test.repository.model.Item;

public interface IItemBussiness {

	ItemBean getItemById(Long id) throws DataAccessException,NonExistingItemException;
	
	void createItem(ItemBean item) throws JamaException;
	
	void updateItem(ItemBean item) throws JamaException;
	
}
