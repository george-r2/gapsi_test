package com.gapsi.test.jama_test.rest;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gapsi.test.jama_test.beans.ItemBean;
import com.gapsi.test.jama_test.beans.ItemResult;
import com.gapsi.test.jama_test.beans.ItemResultList;
import com.gapsi.test.jama_test.beans.Response;
import com.gapsi.test.jama_test.business.IItemBussiness;
import com.gapsi.test.jama_test.exception.JamaException;

@RestController
@RequestMapping("item")
public class ItemRest {

	@Autowired
	private IItemBussiness itemBusiness;
	
	private static final Logger LOGGER = Logger.getLogger(ItemRest.class);
	
	@GetMapping("/{id}")
	public ResponseEntity<Response> getItem(@PathVariable Long id) throws JamaException{
		LOGGER.info(this.getClass().getSimpleName()+"_getItem_START");
		ResponseEntity<Response> response =null;
		ItemBean i = itemBusiness.getItemById(id);
		Response responseBean = new Response();	
		responseBean.setSuccess(true);
		ItemResult result = new ItemResult();
		result.setItem(i);
		responseBean.setResult(result);
		response = new ResponseEntity<Response>(responseBean,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/list")
	public ResponseEntity<Response> getList() throws JamaException{
		LOGGER.info(this.getClass().getSimpleName()+"_getList_START");
		ResponseEntity<Response> response =null;
		List<ItemBean> list = itemBusiness.findAll();
		Response responseBean = new Response();	
		responseBean.setSuccess(true);
		ItemResultList result = new ItemResultList();
		result.setList(list);
		responseBean.setResult(result);
		response = new ResponseEntity<Response>(responseBean,HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/")
	public ResponseEntity<Response> saveItem(@Valid @RequestBody ItemBean item) throws JamaException{
		LOGGER.info(this.getClass().getSimpleName()+"_saveItem_START");
		ResponseEntity<Response> response =null;
		itemBusiness.createItem(item);;
		Response responseBean = new Response();	
		responseBean.setSuccess(true);
		response = new ResponseEntity<Response>(responseBean,HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Response> updateItem(@PathVariable Long id,
			@Valid @RequestBody ItemBean item) throws JamaException{
		LOGGER.info(this.getClass().getSimpleName()+"_updateItem_START");
		ResponseEntity<Response> response =null;
		item.setId(id);
		itemBusiness.updateItem(item);;
		Response responseBean = new Response();	
		responseBean.setSuccess(true);
		response = new ResponseEntity<Response>(responseBean,HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response> deleteItem(@PathVariable Long id) throws JamaException{
		LOGGER.info(this.getClass().getSimpleName()+"_deleteItem_START");
		ResponseEntity<Response> response =null;
		itemBusiness.deleteItem(id);;
		Response responseBean = new Response();	
		responseBean.setSuccess(true);
		response = new ResponseEntity<Response>(responseBean,HttpStatus.OK);
		return response;
	}
	
}
