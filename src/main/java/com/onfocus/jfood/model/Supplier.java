package com.onfocus.jfood.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the suppliers database table.
 * 
 */
@Entity
@Table(name="suppliers")
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=250)
	private String address;

	@Column(name="city_register", length=12)
	private String cityRegister;

	@Column(nullable=false, precision=131089)
	private BigDecimal cnpj;

	@Column(name="company_name", nullable=false, length=200)
	private String companyName;

	@Column(name="state_register", length=14)
	private String stateRegister;

	@Column(name="trading_name", nullable=false, length=100)
	private String tradingName;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="supplier")
	private List<Invoice> invoices;

    public Supplier() {
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

	public String getCityRegister() {
		return this.cityRegister;
	}

	public void setCityRegister(String cityRegister) {
		this.cityRegister = cityRegister;
	}

	public BigDecimal getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(BigDecimal cnpj) {
		this.cnpj = cnpj;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStateRegister() {
		return this.stateRegister;
	}

	public void setStateRegister(String stateRegister) {
		this.stateRegister = stateRegister;
	}

	public String getTradingName() {
		return this.tradingName;
	}

	public void setTradingName(String tradingName) {
		this.tradingName = tradingName;
	}

	public List<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}
	
}