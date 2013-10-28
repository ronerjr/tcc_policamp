package com.onfocus.jfood.helper;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.onfocus.jfood.enums.Permission;
import com.onfocus.jfood.model.PaymentMode;
import com.onfocus.jfood.model.User;
import com.onfocus.jfood.util.DAOFactory;

public class PaymentHelper implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public List<PaymentMode> getListPayment() {
		return DAOFactory.getService().listAllPaymentMode();
	}
	
	public boolean validateInsert(PaymentMode persistPaymentMode) {
		if (persistPaymentMode.getId() == null
				|| persistPaymentMode.getPaymentMode() == null
				|| persistPaymentMode.getTax() == null) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Deve-se preencher o formulário corretamente",
							"ERRO"));
			return false;
		} else {
			return true;
		}
	}
	 
	
}
