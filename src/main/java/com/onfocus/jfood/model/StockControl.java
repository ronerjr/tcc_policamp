package com.onfocus.jfood.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the stock_control database table.
 * 
 */
@Entity
@Table(name = "stock_control")
public class StockControl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 50)
	private String criticity;

	@Column(nullable = false, precision = 4)
	private BigDecimal quantity;

	// bi-directional many-to-one association to Product
	@Id
	@ManyToOne
	@JoinColumn(name = "id_product", nullable = false)
	private Product product;

	public StockControl() {
	}

	public String getCriticity() {
		return this.criticity;
	}

	public void setCriticity(String criticity) {
		this.criticity = criticity;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}