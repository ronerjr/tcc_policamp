package com.onfocus.jfood.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	private Boolean active;

	@Column(name="product_name", length=100)
	private String productName;

	@Column(name="product_value", nullable=false, precision=7, scale=2)
	private BigDecimal productValue;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="product")
	private List<Order> orders;

	//bi-directional many-to-one association to MeasureUnity
    @ManyToOne
	@JoinColumn(name="id_measure_unity")
	private MeasureUnity measureUnity;

	//bi-directional many-to-one association to ProductType
    @ManyToOne
	@JoinColumn(name="id_product_type")
	private ProductType productType;

	//bi-directional many-to-one association to StockControl
	@OneToMany(mappedBy="product")
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
	
}