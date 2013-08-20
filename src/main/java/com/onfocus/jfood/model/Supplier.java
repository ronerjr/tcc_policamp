package com.onfocus.jfood.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the suppliers database table.
 * 
 */
@Entity
@Table(name = "suppliers")
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "address")
	private String address;

	@Column(name = "city_register")
	private String cityRegister;

	@Column(name = "cnpj")
	private BigDecimal cnpj;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "state_register")
	private String stateRegister;

	@Column(name = "trading_name")
	private String tradingName;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((cityRegister == null) ? 0 : cityRegister.hashCode());
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result
				+ ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((stateRegister == null) ? 0 : stateRegister.hashCode());
		result = prime * result
				+ ((tradingName == null) ? 0 : tradingName.hashCode());
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
		Supplier other = (Supplier) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (cityRegister == null) {
			if (other.cityRegister != null) {
				return false;
			}
		} else if (!cityRegister.equals(other.cityRegister)) {
			return false;
		}
		if (cnpj == null) {
			if (other.cnpj != null) {
				return false;
			}
		} else if (!cnpj.equals(other.cnpj)) {
			return false;
		}
		if (companyName == null) {
			if (other.companyName != null) {
				return false;
			}
		} else if (!companyName.equals(other.companyName)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (stateRegister == null) {
			if (other.stateRegister != null) {
				return false;
			}
		} else if (!stateRegister.equals(other.stateRegister)) {
			return false;
		}
		if (tradingName == null) {
			if (other.tradingName != null) {
				return false;
			}
		} else if (!tradingName.equals(other.tradingName)) {
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
		return "Supplier [id=" + id + ", address=" + address
				+ ", cityRegister=" + cityRegister + ", cnpj=" + cnpj
				+ ", companyName=" + companyName + ", stateRegister="
				+ stateRegister + ", tradingName=" + tradingName + "]";
	}

}