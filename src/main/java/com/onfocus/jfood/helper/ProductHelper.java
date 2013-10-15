package com.onfocus.jfood.helper;

import java.io.Serializable;
import java.util.List;

import com.onfocus.jfood.model.MeasureUnity;
import com.onfocus.jfood.model.Product;
import com.onfocus.jfood.model.ProductType;
import com.onfocus.jfood.util.DAOFactory;

public class ProductHelper implements Serializable {

	private static final long serialVersionUID = 1L;

	public List<MeasureUnity> getMeasureUnitiesList() {
		return DAOFactory.getService().listAllMeasureUnits();
	}
	public List<ProductType> getProductTypesList(){
		return DAOFactory.getService().listAllProductTypes();	
	}
	public List<Product> getProductList(){
		return DAOFactory.getService().listAllProducts();
	}
}
