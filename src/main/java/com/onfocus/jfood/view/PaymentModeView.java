package com.onfocus.jfood.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.onfocus.jfood.helper.PaymentHelper;
import com.onfocus.jfood.model.PaymentMode;
import com.onfocus.jfood.model.User;
import com.onfocus.jfood.util.DAOFactory;

@ManagedBean(name = "paymentModeView")
@SessionScoped
public class PaymentModeView implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private PaymentMode persistPayment;
	private PaymentMode selectedPaymentMode;
	private PaymentHelper paymentHelper;
	
	
	public PaymentModeView(){
		persistPayment = new PaymentMode();
		paymentHelper = new PaymentHelper();
		selectedPaymentMode = new PaymentMode();
	}

	public PaymentHelper getPaymentHelper() {
		return paymentHelper;
	}
	

	public void setPaymentHelper(PaymentHelper paymentHelper) {
		this.paymentHelper = paymentHelper;
	}
	
	public PaymentMode getPersistPayment() {
		return persistPayment;
	}

	public void setPersistPayment(PaymentMode persistPayment) {
		this.persistPayment = persistPayment;
	}

	public String preparePersist() {
		this.setPersistPayment(new PaymentMode());
		return "/protected/admin/adminPersistPayment.jsf";
	}
	
	public PaymentMode getSelectedPaymentMode() {
		return selectedPaymentMode;
	}
	
	public void setSelectedPaymentMode (PaymentMode selectedPaymentMode) {
		this.selectedPaymentMode = selectedPaymentMode;
	}
	
	public void insert() {
			if (DAOFactory.getService().insertPaymentMode(this.persistPayment) == this.persistPayment) {
				FacesContext.getCurrentInstance().addMessage(
						"paymentMessages",
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Forma de pagamento "
								+ this.persistPayment.getPaymentMode()
								+ " inserido com sucesso!", "SUCESSO"));
				this.persistPayment = new PaymentMode();
			} else {
				FacesContext.getCurrentInstance().addMessage(
						"paymentMessages",
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Erro ao inserir forma de pagamento", "ERRO"));
			}
	}
	
	public String prepareUpdate() {
		this.persistPayment = this.selectedPaymentMode;
		return "/protected/admin/adminPersistPayment.jsf";
	}
	
	public void update() {
			if (DAOFactory.getService().updatePaymentMode(this.persistPayment) == this.persistPayment) {
				FacesContext.getCurrentInstance().addMessage(
						"paymentMessages",
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Forma de pagamento alterado com sucesso!", "SUCESSO"));
				this.persistPayment = new PaymentMode();
			} else {
				FacesContext.getCurrentInstance().addMessage(
						"paymentMessages",
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Erro ao alterar forma de pagamento", "ERROR"));
			}
	} 
	public void enablePaymentMode() {
		this.persistPayment = new PaymentMode();
		this.selectedPaymentMode.setActive(true);
		this.persistPayment = this.selectedPaymentMode;
		update();
	}

	public void disablePaymentMode() {
		this.persistPayment = new PaymentMode();
		this.selectedPaymentMode.setActive(false);
		this.persistPayment = this.selectedPaymentMode;
		update();
	}
	
}

