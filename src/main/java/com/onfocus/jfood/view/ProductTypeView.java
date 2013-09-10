/**
 * 
 */
package com.onfocus.jfood.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.onfocus.jfood.helper.ProductTypeHelper;
import com.onfocus.jfood.model.ProductType;
import com.onfocus.jfood.util.DAOFactory;

/**
 * @author roner
 * 
 */
@ManagedBean(name = "productTypeView")
@SessionScoped
public class ProductTypeView implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String CONSULT_PRODUCT_TYPE = "/protected/admin/adminProductType.jsf";

	private static final String PERSIST_PRODUCT_TYPE = "/protected/admin/adminPersistProductType.jsf";

	private ProductType persistProductType;

	private ProductType selectedProductType;

	private ProductTypeHelper productTypeHelper;

	public ProductTypeView() {
		this.productTypeHelper = new ProductTypeHelper();
		this.persistProductType = new ProductType();
		this.selectedProductType = new ProductType();
	}

	public String prepareInsert() {
		this.persistProductType = new ProductType();
		return PERSIST_PRODUCT_TYPE;
	}

	public String prepareUpdate() {
		this.persistProductType = this.selectedProductType;
		return PERSIST_PRODUCT_TYPE;
	}

	public void insert() {
		if (productTypeHelper.validateInsertTipoProduto(persistProductType)) {
			try {
				DAOFactory.getService().insertProductType(persistProductType);
				persistProductType = new ProductType();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo de produto inserido com sucesso", "ERROR"));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao inserir tipo de produto", "ERROR"));
			}
		}
	}

	public void update() {
		if (productTypeHelper.validateInsertTipoProduto(persistProductType)) {
			try {
				DAOFactory.getService().updateProductType(persistProductType);
				this.persistProductType = new ProductType();
				FacesContext.getCurrentInstance()
						.addMessage(
								null,
								new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo de produto alterado com sucesso",
										"SUCESSO"));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao alterar usuario", "ERROR"));
			}
		}
	}

	public void delete() {
		try {
			DAOFactory.getService().deleteProductType(selectedProductType);
			this.selectedProductType = new ProductType();
			new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo de produto excluido com sucesso", "SUCESSO");
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir tipo de produto", "ERROR"));
		}
	}

	/**
	 * @return the persistProductType
	 */
	public ProductType getPersistProductType() {
		return persistProductType;
	}

	/**
	 * @param persistProductType
	 *            the persistProductType to set
	 */
	public void setPersistProductType(ProductType persistProductType) {
		this.persistProductType = persistProductType;
	}

	/**
	 * @return the selectedProductType
	 */
	public ProductType getSelectedProductType() {
		return selectedProductType;
	}

	/**
	 * @param selectedProductType
	 *            the selectedProductType to set
	 */
	public void setSelectedProductType(ProductType selectedProductType) {
		this.selectedProductType = selectedProductType;
	}

	/**
	 * @return the productTypeHelper
	 */
	public ProductTypeHelper getProductTypeHelper() {
		return productTypeHelper;
	}

	/**
	 * @param productTypeHelper
	 *            the productTypeHelper to set
	 */
	public void setProductTypeHelper(ProductTypeHelper productTypeHelper) {
		this.productTypeHelper = productTypeHelper;
	}
}
