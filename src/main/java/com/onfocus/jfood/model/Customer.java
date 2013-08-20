package com.onfocus.jfood.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name = "customers")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "address")
	private String address;

	@Column(name = "cell_number")
	private BigDecimal cellNumber;

	@Column(name = "cpf")
	private BigDecimal cpf;

	@Column(name = "customer_last_name")
	private String customerLastName;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "email")
	private String email;

	@Column(name = "fone_number")
	private BigDecimal foneNumber;

	@Column(name = "rg")
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
				+ ((cellNumber == null) ? 0 : cellNumber.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime
				* result
				+ ((customerLastName == null) ? 0 : customerLastName.hashCode());
		result = prime * result
				+ ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((foneNumber == null) ? 0 : foneNumber.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
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
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (cellNumber == null) {
			if (other.cellNumber != null) {
				return false;
			}
		} else if (!cellNumber.equals(other.cellNumber)) {
			return false;
		}
		if (cpf == null) {
			if (other.cpf != null) {
				return false;
			}
		} else if (!cpf.equals(other.cpf)) {
			return false;
		}
		if (customerLastName == null) {
			if (other.customerLastName != null) {
				return false;
			}
		} else if (!customerLastName.equals(other.customerLastName)) {
			return false;
		}
		if (customerName == null) {
			if (other.customerName != null) {
				return false;
			}
		} else if (!customerName.equals(other.customerName)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (foneNumber == null) {
			if (other.foneNumber != null) {
				return false;
			}
		} else if (!foneNumber.equals(other.foneNumber)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (rg == null) {
			if (other.rg != null) {
				return false;
			}
		} else if (!rg.equals(other.rg)) {
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
		return "Customer [id=" + id + ", address=" + address + ", cellNumber="
				+ cellNumber + ", cpf=" + cpf + ", customerLastName="
				+ customerLastName + ", customerName=" + customerName
				+ ", email=" + email + ", foneNumber=" + foneNumber + ", rg="
				+ rg + "]";
	}

}