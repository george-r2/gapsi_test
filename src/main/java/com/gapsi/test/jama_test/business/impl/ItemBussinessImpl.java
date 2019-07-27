package com.gapsi.test.jama_test.business.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gapsi.test.jama_test.beans.ItemBean;
import com.gapsi.test.jama_test.business.IItemBussiness;
import com.gapsi.test.jama_test.exception.DataAccessException;
import com.gapsi.test.jama_test.exception.JamaException;
import com.gapsi.test.jama_test.exception.NonExistingItemException;
import com.gapsi.test.jama_test.repository.ItemRepository;
import com.gapsi.test.jama_test.repository.model.Item;
import com.gapsi.test.jama_test.util.Utils;

@Service
public class ItemBussinessImpl implements IItemBussiness {

	private static final Logger LOGGER = Logger.getLogger(ItemBussinessImpl.class);
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public ItemBean getItemById(Long id) throws DataAccessException,NonExistingItemException{
		LOGGER.info(this.getClass().getSimpleName()+"_getItemById_START");
		ItemBean i=null ;
		try {
			Item iModel = itemRepository.findById(id);
			i= Utils.itemToItemBean(iModel);
		}catch(Exception e) {
			LOGGER.warn("Error al acceder a la bd");
			DataAccessException ex = new DataAccessException(e.getClass().getSimpleName(),e.getMessage());
			throw ex;
		}
		if(i==null) {
			LOGGER.warn("No se encontro un item con el id:"+id.toString());
			throw new NonExistingItemException();
		}
		return i;
	}

	@Override
	@Transactional
	public void createItem(ItemBean item) throws JamaException {
		LOGGER.info(this.getClass().getSimpleName()+"_createItem_START");
		Item i = Utils.itemBeanToItem(item);
		try {
			itemRepository.save(i);
		}catch(Exception e) {
			LOGGER.warn("Error al acceder a la bd");
			DataAccessException ex = new DataAccessException(e.getClass().getSimpleName(),e.getMessage());
			throw ex;
		}
		
	}

	public void updateItem(ItemBean item) throws JamaException {
		LOGGER.info(this.getClass().getSimpleName()+"_updateItem_START");
		Item iModel ;
		try {
			iModel = itemRepository.findById(item.getId());
		}catch(Exception e) {
			LOGGER.warn("Error al acceder a la bd");
			DataAccessException ex = new DataAccessException(e.getClass().getSimpleName(),e.getMessage());
			throw ex;
		}
		if(iModel==null) {
			LOGGER.warn("No se encontro un item con el id:"+item.getId());
			throw new NonExistingItemException();
		}
	}

}
