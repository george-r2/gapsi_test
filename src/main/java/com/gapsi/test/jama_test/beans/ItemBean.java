package com.gapsi.test.jama_test.beans;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;


public class ItemBean {
	
	private Long id;
	@NotEmpty(message="el nombre es obligatorio")
	private String name;
	@NotEmpty(message="la descripcion es obligatoria")
	private String desc;
//	@(message="el nombre es obligatorio")
	private BigDecimal price;
	@NotEmpty(message="el modelo es obligatorio")
	private String model;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
}
