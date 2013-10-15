package com.onfocus.jfood.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.onfocus.jfood.helper.ProductHelper;
import com.onfocus.jfood.model.Product;
import com.onfocus.jfood.util.DAOFactory;

/**
 * @author Jo�o
 * 
 */
@ManagedBean(name = "productView")
@SessionScoped
public class ProductView implements Serializable {

	private static final long serialVersionUID = 1L;

	private Product persistProduct;

	private Product selectedProduct;

	private ProductHelper productHelper;

	public ProductView() {
		this.productHelper = new ProductHelper();
	}

	public String preparePersist() {
		this.persistProduct = new Product();
		return "/protected/admin/adminPersistProduct.jsf";
	}

	public String prepareUpdate() {
		this.persistProduct = this.selectedProduct;
		return "/protected/admin/adminPersistProduct.jsf";
	}

	public void update() {
		try {
			DAOFactory.getService().updateProduct(persistProduct);
			FacesContext.getCurrentInstance().addMessage("productMessages",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "ALTERADO COM SUCESSO", "SUCCESS!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("productMessages",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "ERROR"));
		}
	}

	public void insert() {
		try {
			DAOFactory.getService().insertProduct(persistProduct);
			this.persistProduct = new Product();
			FacesContext.getCurrentInstance().addMessage("productMessages",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "INSERIDO COM SUCESSO", "SUCCESS!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("productMessages",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "ERROR"));
		}
	}

	public void enableProduct() {
		this.persistProduct = new Product();
		this.selectedProduct.setActive(true);
		this.persistProduct = this.selectedProduct;
		update();
	}

	public void disableProduct() {
		this.persistProduct = new Product();
		this.selectedProduct.setActive(false);
		this.persistProduct = this.selectedProduct;
		update();
	}

	/**
	 * @return the persistProduct
	 */
	public Product getPersistProduct() {
		return persistProduct;
	}

	/**
	 * @param persistProduct
	 *            the persistProduct to set
	 */
	public void setPersistProduct(Product persistProduct) {
		this.persistProduct = persistProduct;
	}

	/**
	 * @return the selectedProduct
	 */
	public Product getSelectedProduct() {
		return selectedProduct;
	}

	/**
	 * @param selectedProduct
	 *            the selectedProduct to set
	 */
	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	/**
	 * @return the productHelper
	 */
	public ProductHelper getProductHelper() {
		return productHelper;
	}

	/**
	 * @param productHelper
	 *            the productHelper to set
	 */
	public void setProductHelper(ProductHelper productHelper) {
		this.productHelper = productHelper;
	}
}