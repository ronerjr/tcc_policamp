package com.onfocus.jfood.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.onfocus.jfood.model.MeasureUnity;
import com.onfocus.jfood.util.DAOFactory;

@FacesConverter(forClass=MeasureUnity.class)
public class MeasureUnityConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return DAOFactory.getService().findMeasureUnitById(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return ((MeasureUnity) value).getCode();
	}
}
