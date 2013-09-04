/**
 * 
 */
package com.onfocus.jfood.helper;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.onfocus.jfood.model.ProductType;
import com.onfocus.jfood.util.DAOFactory;

/**
 * @author roner
 * 
 */
public class ProductTypeHelper implements Serializable {

	private static final long serialVersionUID = 1L;

	public boolean validateInsertTipoProduto(ProductType productType) {
		boolean isValid = false;
		if (productType == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Tipo de produto deve ser preenchido!", "ERRO")));
			isValid = false;
		} else if (productType.getProductType() == "" || productType.getProductType() == null) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Descricao do tipo de produto deve ser preenchido!",
							"ERRO")));
			isValid = false;
		} else {
			isValid = true;
		}
		return isValid;
	}

	public List<ProductType> getListProductTypes() {
		return DAOFactory.getService().listAllProductTypes();
	}

}
