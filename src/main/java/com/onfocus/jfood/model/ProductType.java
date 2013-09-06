package com.onfocus.jfood.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the product_type database table.
 * 
 */
@Entity
@Table(name = "product_type")
public class ProductType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "product_type")
	private String productType;

	// bi-directional many-to-one association to Complement
	@OneToMany(mappedBy = "productType")
	private List<Complement> complements;

	// bi-directional many-to-one association to Order
	@OneToMany(mappedBy = "productType")
	private List<Order> orders;

	// bi-directional many-to-one association to Product
	@OneToMany(mappedBy = "productType")
	private List<Product> products;

	public ProductType() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public List<Complement> getComplements() {
		return this.complements;
	}

	public void setComplements(List<Complement> complements) {
		this.complements = complements;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}