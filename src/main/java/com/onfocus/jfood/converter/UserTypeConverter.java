/**
 * 
 */
package com.onfocus.jfood.converter;

import java.util.logging.Level;
import java.util.logging.Logger;

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
		Logger.getLogger("converter").log(Level.INFO, value);
		return DAOFactory.getService().findUserTypeByType(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		Logger.getLogger("converter").log(Level.INFO, value.toString());
		return ((UserType) value).getUserType();
	}
}
