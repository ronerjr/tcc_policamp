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

	@Column(name = "criticity")
	private String criticity;

	@Column(name = "quantity")
	private BigDecimal quantity;

	// bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name = "id_product")
	@Id
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((criticity == null) ? 0 : criticity.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result
				+ ((quantity == null) ? 0 : quantity.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		StockControl other = (StockControl) obj;
		if (criticity == null) {
			if (other.criticity != null) {
				return false;
			}
		} else if (!criticity.equals(other.criticity)) {
			return false;
		}
		if (product == null) {
			if (other.product != null) {
				return false;
			}
		} else if (!product.equals(other.product)) {
			return false;
		}
		if (quantity == null) {
			if (other.quantity != null) {
				return false;
			}
		} else if (!quantity.equals(other.quantity)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StockControl [criticity=" + criticity + ", quantity="
				+ quantity + ", product=" + product + "]";
	}

}