package com.onfocus.jfood.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.onfocus.jfood.model.Product;
import com.onfocus.jfood.util.DAOFactory;

@FacesConverter(forClass=Product.class)
public class ProductConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		return DAOFactory.getService().findProductByName(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {		
		return ((Product) value).getProductName();
	}

}
