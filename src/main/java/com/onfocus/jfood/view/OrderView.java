package com.onfocus.jfood.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.onfocus.jfood.helper.OrderHelper;
import com.onfocus.jfood.model.Customer;
import com.onfocus.jfood.model.Order;
import com.onfocus.jfood.model.Product;
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
	
	private OrderHelper orderHelper;
	
	public OrderView (){
		produto = new Product();
		cliente = new Customer();
		orderHelper = new OrderHelper();
		persistOrder = new Order(); 
	}

	public void atualizaCampoCodigo() {
		if (this.codigoProduto != 0) {
			this.produto = DAOFactory.getService().findProductById(
					this.codigoProduto);
		}
	}
	
	public void atualizaCampoCliente() {
		if (this.codigoCliente != 0) {
			this.cliente = DAOFactory.getService().findCustomerId(
					this.codigoCliente);
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
	 * @param orderHelper the orderHelper to set
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
	 * @param persistOrder the persistOrder to set
	 */
	public void setPersistOrder(Order persistOrder) {
		this.persistOrder = persistOrder;
	}
}