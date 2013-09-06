package com.onfocus.jfood.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.onfocus.jfood.helper.CustomerHelper;
import com.onfocus.jfood.model.Customer;
import com.onfocus.jfood.util.DAOFactory;

@ManagedBean(name = "customerView")
@SessionScoped
public class CustomerView implements Serializable {

	private static final long serialVersionUID = 1L;

	private Customer persistCustomer;

	private Customer selectedCustomer;

	private CustomerHelper customerHelper;

	public CustomerView() {
		customerHelper = new CustomerHelper();
	}

	public String preparePersist() {
		this.persistCustomer = new Customer();
		return "/protected/admin/adminPersistCustomer.jsf";
	}

	public String prepareUpdate() {
		this.persistCustomer = this.selectedCustomer;
		return "/protected/admin/adminPersistCustomer.jsf";
	}

	public void update() {
		if (this.customerHelper.validateInsert(this.persistCustomer)) {
			if (DAOFactory.getService().updateCustomer(this.persistCustomer) == this.persistCustomer) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente alterado com sucesso!", "SUCESSO"));
				this.persistCustomer = new Customer();
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao alterar o cliente", "ERROR"));
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao alterar o cliente", "ERROR"));
		}
	}

	public void insert() {
		if (this.customerHelper.validateInsert(this.persistCustomer)) {
			if (DAOFactory.getService().insertCustomers(this.persistCustomer) == this.persistCustomer) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente "
								+ this.persistCustomer.getCustomerName() + " inserido com sucesso!", "SUCESSO"));
				this.persistCustomer = new Customer();
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao inserir Cliente", "ERRO"));
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao inserir Cliente", "ERRO"));
		}
	}

	public void enableCustomer() {
		this.persistCustomer = new Customer();
		this.selectedCustomer.setActive(true);
		this.persistCustomer = this.selectedCustomer;
		update();
	}

	public void disableCustomer() {
		this.persistCustomer = new Customer();
		this.selectedCustomer.setActive(false);
		this.persistCustomer = this.selectedCustomer;
		update();
	}

	public Customer getPersistCustomer() {
		return persistCustomer;
	}

	public void setPersistCustomer(Customer persistCustomer) {
		this.persistCustomer = persistCustomer;
	}

	public Customer getSelectedCustomer() {
		return selectedCustomer;
	}

	public void setSelectedCustomer(Customer selectedCustomer) {
		this.selectedCustomer = selectedCustomer;
	}

	public CustomerHelper getCustomerHelper() {
		return customerHelper;
	}

	public void setCustomerHelper(CustomerHelper customerHelper) {
		this.customerHelper = customerHelper;
	}

}
