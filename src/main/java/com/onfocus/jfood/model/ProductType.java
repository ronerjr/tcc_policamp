package com.onfocus.jfood.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name = "id")
	private Integer id;

	@Column(name = "product_type")
	private String productType;

	// bi-directional many-to-one association to Complement
	@OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
	private Set<Complement> complements;

	// bi-directional many-to-one association to Order
	@OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
	private Set<Order> orders;

	// bi-directional many-to-one association to Product
	@OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
	private Set<Product> products;

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

	public Set<Complement> getComplements() {
		return this.complements;
	}

	public void setComplements(Set<Complement> complements) {
		this.complements = complements;
	}

	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
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
				+ ((complements == null) ? 0 : complements.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
		result = prime * result
				+ ((productType == null) ? 0 : productType.hashCode());
		result = prime * result
				+ ((products == null) ? 0 : products.hashCode());
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
		ProductType other = (ProductType) obj;
		if (complements == null) {
			if (other.complements != null) {
				return false;
			}
		} else if (!complements.equals(other.complements)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (orders == null) {
			if (other.orders != null) {
				return false;
			}
		} else if (!orders.equals(other.orders)) {
			return false;
		}
		if (productType == null) {
			if (other.productType != null) {
				return false;
			}
		} else if (!productType.equals(other.productType)) {
			return false;
		}
		if (products == null) {
			if (other.products != null) {
				return false;
			}
		} else if (!products.equals(other.products)) {
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
		return "ProductType [id=" + id + ", productType=" + productType
				+ ", complements=" + complements + ", orders=" + orders
				+ ", products=" + products + "]";
	}

}