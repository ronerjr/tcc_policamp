/**
 * 
 */
package com.onfocus.jfood.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.onfocus.jfood.model.UserType;
import com.onfocus.jfood.util.DAOFactory;

/**
 * @author Roner
 * 
 */
@FacesConverter(forClass = UserType.class)
public class UserTypeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		return DAOFactory.getService().findUserTypeByType(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return ((UserType) value).getUserType();
	}

}
