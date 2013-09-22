package com.onfocus.jfood.helper;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.security.core.context.SecurityContextHolder;

import com.onfocus.jfood.enums.Permission;
import com.onfocus.jfood.model.User;
import com.onfocus.jfood.model.UserType;
import com.onfocus.jfood.util.DAOFactory;

public class UserHelper implements Serializable {

	private static final long serialVersionUID = 1L;

	public String getCurrentUser() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	public boolean validateInsert(User persistUser) {
		if (persistUser.getUserName() == null || persistUser.getUserPassword() == null
				|| persistUser.getUserType() == null) {
			FacesContext.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Deve-se preencher o formulário corretamente", "ERRO"));
			return false;
		} else {
			return true;
		}
	}

	public Permission setAuthorityByType(User user) {
		switch (user.getUserType().getUserType()) {
			case "Administrador":
				return Permission.ROLE_ADMINISTRATOR;
			case "Gerente":
				return Permission.ROLE_MANAGER;
			default:
				return Permission.ROLE_USER;
		}
	}

	public List<UserType> getUserTypeList() {
		return DAOFactory.getService().listAllUserTypes();
	}

	public List<User> getUserList() {
		return DAOFactory.getService().listAllUsers();
	}
}
