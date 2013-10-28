package com.onfocus.jfood.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.onfocus.jfood.helper.OrderHelper;
import com.onfocus.jfood.model.Customer;
import com.onfocus.jfood.model.Order;
import com.onfocus.jfood.model.Product;
import com.onfocus.jfood.model.ProductType;
import com.onfocus.jfood.util.DAOFactory;

@ManagedBean(name = "orderView")
@SessionScoped
public class OrderView implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codigoProduto;
	private int codigoCliente;
	private Order persistOrder;
	private Product produto;
	private Customer cliente;
	private ProductType tipoproduto;
	private List<Product> listProducts;

	private OrderHelper orderHelper;

	public OrderView() {
		produto = new Product();
		cliente = new Customer();
		orderHelper = new OrderHelper();
		persistOrder = new Order();
		setTipoproduto(new ProductType());
		listProducts = new ArrayList<>();
		// setListProducts(orderHelper.getProductList(new ProductType()));
	}

	public void atualizaCampoCodigo() {
		try {
			if (this.codigoProduto != 0) {
				Product product = DAOFactory.getService().findProductById(this.codigoProduto);
				if (product != null) {
					Logger.getLogger("LOG").log(Level.INFO, product.toString());
					updateFields(product);
				} else {
					FacesContext.getCurrentInstance().addMessage("productmessage",
							new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto n�o encontrado", "ERROR!"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("productmessage",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "ERROR"));

		}
	}

	public void updateTypeField() {
		if (this.persistOrder.getProductType() != null) {
			this.listProducts = orderHelper.getProductList(this.persistOrder.getProductType());
		}
	}

	public void updateFields(Product product) {
		this.persistOrder.setProduct(product);
		this.persistOrder.setProductType(product.getProductType());
		this.codigoProduto = product.getId().intValue();
	}

	public void atualizaCampoCliente() {
		if (this.codigoCliente != 0) {
			this.cliente = DAOFactory.getService().findCustomerId(this.codigoCliente);
		} else {
			System.out.println("nao foi");
		}
	}

	/**
	 * @return the codigoProduto
	 */
	public int getCodigoProduto() {
		return codigoProduto;
	}

	/**
	 * @param codigoProduto
	 *            the codigoProduto to set
	 */
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	/**
	 * @return the produto
	 */
	public Product getProduto() {
		return produto;
	}

	/**
	 * @param produto
	 *            the produto to set
	 */
	public void setProduto(Product produto) {
		this.produto = produto;
	}

	/**
	 * @return the orderHelper
	 */
	public OrderHelper getOrderHelper() {
		return orderHelper;
	}

	/**
	 * @param orderHelper
	 *            the orderHelper to set
	 */
	public void setOrderHelper(OrderHelper orderHelper) {
		this.orderHelper = orderHelper;
	}

	/**
	 * @return the persistOrder
	 */
	public Order getPersistOrder() {
		return persistOrder;
	}

	/**
	 * @param persistOrder
	 *            the persistOrder to set
	 */
	public void setPersistOrder(Order persistOrder) {
		this.persistOrder = persistOrder;
	}

	public ProductType getTipoproduto() {
		return tipoproduto;
	}

	public void setTipoproduto(ProductType tipoproduto) {
		this.tipoproduto = tipoproduto;
	}

	public List<Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Product> listProducts) {
		this.listProducts = listProducts;
	}
}