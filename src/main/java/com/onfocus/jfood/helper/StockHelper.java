package com.onfocus.jfood.helper;


import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.security.core.context.SecurityContextHolder;
import com.onfocus.jfood.model.StockControl;
import com.onfocus.jfood.util.DAOFactory;

public class StockHelper implements Serializable {

	private static final long serialVersionUID = 1L;

	public String getCurrentStock() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	public boolean validateInsert(StockControl persistStockControl) {
		if (persistStockControl.getProduct() == null
				|| persistStockControl.getQuantity() == null
				|| persistStockControl.getCriticity() == null) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Deve-se preencher os campos corretamente",
							"ERRO"));
			return false;
		} else {
			return true;
		}
	}
	

	public List<StockControl> getListaEstoque() {
		return DAOFactory.getService().listStock();
	}
	

}

