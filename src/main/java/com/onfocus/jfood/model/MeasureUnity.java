package com.onfocus.jfood.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the measure_unity database table.
 * 
 */
@Entity
@Table(name="measure_unity")
public class MeasureUnity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false, length=6)
	private String code;

	@Column(nullable=false, length=30)
	private String description;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="measureUnity")
	private List<Product> products;

    public MeasureUnity() {
    }

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}