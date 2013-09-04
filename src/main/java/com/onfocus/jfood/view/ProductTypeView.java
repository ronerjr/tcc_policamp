/**
 * 
 */
package com.onfocus.jfood.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
	}

	public void cleanFields() {
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

	public String insert() {
		if (productTypeHelper.validateInsertTipoProduto(persistProductType)) {
			try {
				DAOFactory.getService().insertProductType(persistProductType);
				this.persistProductType = new ProductType();
				return CONSULT_PRODUCT_TYPE;
			} catch (Exception e) {
				return PERSIST_PRODUCT_TYPE;
			}
		} else {
			return PERSIST_PRODUCT_TYPE;
		}
	}

	public String update() {
		if (productTypeHelper.validateInsertTipoProduto(persistProductType)) {
			try {
				DAOFactory.getService().updateProductType(persistProductType);
				this.persistProductType = new ProductType();
				return CONSULT_PRODUCT_TYPE;
			} catch (Exception e) {
				return PERSIST_PRODUCT_TYPE;
			}
		} else {
			return PERSIST_PRODUCT_TYPE;
		}
	}

	public String delete() {
		try {
			DAOFactory.getService().deleteProductType(selectedProductType);
			this.selectedProductType = new ProductType();
			return CONSULT_PRODUCT_TYPE;
		} catch (Exception e) {
			return PERSIST_PRODUCT_TYPE;
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
