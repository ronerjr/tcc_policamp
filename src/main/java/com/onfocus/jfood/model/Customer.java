package com.onfocus.jfood.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name="customers")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=250)
	private String address;

	@Column(name="cell_number", precision=11)
	private BigDecimal cellNumber;

	@Column(nullable=false, precision=11)
	private BigDecimal cpf;

	@Column(name="customer_last_name", nullable=false, length=50)
	private String customerLastName;

	@Column(name="customer_name", nullable=false, length=20)
	private String customerName;

	@Column(length=50)
	private String email;

	@Column(name="fone_number", nullable=false, precision=11)
	private BigDecimal foneNumber;

	@Column(precision=10)
	private BigDecimal rg;

    public Customer() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getCellNumber() {
		return this.cellNumber;
	}

	public void setCellNumber(BigDecimal cellNumber) {
		this.cellNumber = cellNumber;
	}

	public BigDecimal getCpf() {
		return this.cpf;
	}

	public void setCpf(BigDecimal cpf) {
		this.cpf = cpf;
	}

	public String getCustomerLastName() {
		return this.customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getFoneNumber() {
		return this.foneNumber;
	}

	public void setFoneNumber(BigDecimal foneNumber) {
		this.foneNumber = foneNumber;
	}

	public BigDecimal getRg() {
		return this.rg;
	}

	public void setRg(BigDecimal rg) {
		this.rg = rg;
	}

}