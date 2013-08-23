package com.onfocus.jfood.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the order_type database table.
 * 
 */
@Entity
@Table(name="order_type")
public class OrderType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=60)
	private String description;

	@Column(name="order_type_name", nullable=false, length=15)
	private String orderTypeName;

    public OrderType() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrderTypeName() {
		return this.orderTypeName;
	}

	public void setOrderTypeName(String orderTypeName) {
		this.orderTypeName = orderTypeName;
	}

}