package com.gapsi.test.jama_test.util;

import com.gapsi.test.jama_test.beans.ItemBean;
import com.gapsi.test.jama_test.beans.Response;
import com.gapsi.test.jama_test.repository.model.Item;

public class Utils {

	public static Response createFailedResponse(String code,String message) {
		Response response = new Response();
		com.gapsi.test.jama_test.beans.BeanError error = new com.gapsi.test.jama_test.beans.BeanError();
		error.setCode(code);
		error.setDescription(message);
		response.setSuccess(false);
		response.setError(error);
	
		return response;
	}
	
	public static ItemBean itemToItemBean (Item i) {
		if(i==null)
			return null;
		ItemBean bean = new ItemBean();
		bean.setId(i.getId());
		bean.setDesc(i.getDescr());
		bean.setName(i.getPName());
		bean.setModel(i.getModel());
		bean.setPrice(i.getPrice());
		return bean;
	}
	
	public static Item itemBeanToItem (ItemBean i) {
		if(i==null)
			return null;
		Item bean = new Item();
		bean.setId(i.getId());
		bean.setDescr(i.getDesc());
		bean.setPName(i.getName());
		bean.setModel(i.getModel());
		bean.setPrice(i.getPrice());
		return bean;
	}
}
