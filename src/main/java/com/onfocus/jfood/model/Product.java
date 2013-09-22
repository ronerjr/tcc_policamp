package com.onfocus.jfood.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name = "products")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "active")
	private Boolean active;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_value")
	private BigDecimal productValue;

	// bi-directional many-to-one association to Order
	@OneToMany(mappedBy = "product")
	private List<Order> orders;

	// bi-directional many-to-one association to MeasureUnity
	@ManyToOne
	@JoinColumn(name = "id_measure_unity")
	private MeasureUnity measureUnity;

	// bi-directional many-to-one association to ProductType
	@ManyToOne
	@JoinColumn(name = "id_product_type")
	private ProductType productType;

	// bi-directional many-to-one association to StockControl
	@OneToMany(mappedBy = "product")
	private List<StockControl> stockControls;

	public Product() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getProductValue() {
		return this.productValue;
	}

	public void setProductValue(BigDecimal productValue) {
		this.productValue = productValue;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public MeasureUnity getMeasureUnity() {
		return this.measureUnity;
	}

	public void setMeasureUnity(MeasureUnity measureUnity) {
		this.measureUnity = measureUnity;
	}

	public ProductType getProductType() {
		return this.productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public List<StockControl> getStockControls() {
		return this.stockControls;
	}

	public void setStockControls(List<StockControl> stockControls) {
		this.stockControls = stockControls;
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
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((measureUnity == null) ? 0 : measureUnity.hashCode());
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		result = prime * result + ((productValue == null) ? 0 : productValue.hashCode());
		result = prime * result + ((stockControls == null) ? 0 : stockControls.hashCode());
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
		Product other = (Product) obj;
		if (active == null) {
			if (other.active != null) {
				return false;
			}
		} else if (!active.equals(other.active)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (measureUnity == null) {
			if (other.measureUnity != null) {
				return false;
			}
		} else if (!measureUnity.equals(other.measureUnity)) {
			return false;
		}
		if (orders == null) {
			if (other.orders != null) {
				return false;
			}
		} else if (!orders.equals(other.orders)) {
			return false;
		}
		if (productName == null) {
			if (other.productName != null) {
				return false;
			}
		} else if (!productName.equals(other.productName)) {
			return false;
		}
		if (productType == null) {
			if (other.productType != null) {
				return false;
			}
		} else if (!productType.equals(other.productType)) {
			return false;
		}
		if (productValue == null) {
			if (other.productValue != null) {
				return false;
			}
		} else if (!productValue.equals(other.productValue)) {
			return false;
		}
		if (stockControls == null) {
			if (other.stockControls != null) {
				return false;
			}
		} else if (!stockControls.equals(other.stockControls)) {
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
		return "Product [id=" + id + ", active=" + active + ", productName=" + productName + ", productValue="
				+ productValue + ", orders=" + orders + ", measureUnity=" + measureUnity + ", productType="
				+ productType + ", stockControls=" + stockControls + "]";
	}

}