package com.onfocus.jfood.helper;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.security.core.context.SecurityContextHolder;

import com.onfocus.jfood.model.Customer;
import com.onfocus.jfood.util.DAOFactory;

public class CustomerHelper implements Serializable {

	private static final long serialVersionUID = 1L;

	public String getCurrentUser() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	public boolean validateInsert(Customer persistCustomer) {
		if (persistCustomer.getCustomerName() == null || persistCustomer.getCustomerLastName() == null
				|| persistCustomer.getAddress() == null) {
			FacesContext.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Deve-se preencher o formulário corretamente", "ERRO"));
			return false;
		} else {
			return true;
		}
	}

	public List<Customer> getListAllCustomers() {
		return DAOFactory.getService().listAllCustomers();
	}

}
