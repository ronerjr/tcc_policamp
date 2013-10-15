package com.onfocus.jfood.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.onfocus.jfood.model.ProductType;
import com.onfocus.jfood.util.DAOFactory;

@FacesConverter(forClass = ProductType.class)
public class ProductTypeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return DAOFactory.getService().findProductTypeById(Long.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return ((ProductType) value).getProductType();
	}
}
