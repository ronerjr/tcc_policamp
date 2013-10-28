package com.onfocus.jfood.helper;

import java.io.Serializable;
import java.util.List;

import com.onfocus.jfood.model.Customer;
import com.onfocus.jfood.model.Product;
import com.onfocus.jfood.model.ProductType;
import com.onfocus.jfood.util.DAOFactory;

public class OrderHelper implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public List<Product> getProductList(ProductType productType) {
		if(productType.getId() != null){
			return DAOFactory.getService().listProductByType(productType);			
		}else{
			return DAOFactory.getService().listAllProducts();
		}
	}
	
	public List<Product> getListProducts(){
		return DAOFactory.getService().listAllProducts();
	}
	
	public List<ProductType> getProductTypeList() {
		return DAOFactory.getService().listAllProductTypes();
	}
	
	public List<Customer> getcustomerList() {
		return DAOFactory.getService().listAllCustomers();
	}

}
