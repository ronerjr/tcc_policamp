package com.onfocus.jfood.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.onfocus.jfood.helper.UserHelper;
import com.onfocus.jfood.model.User;
import com.onfocus.jfood.util.DAOFactory;

@ManagedBean(name = "userView")
@SessionScoped
public class UserView implements Serializable {

	private static final long serialVersionUID = 1L;

	private User persistUser;

	private User selectedUser;

	private UserHelper userHelper;

	public UserView() {
		userHelper = new UserHelper();
	}

	public String preparePersist() {
		this.persistUser = new User();
		return "/protected/admin/adminPersistUser.jsf";
	}

	public String prepareUpdate() {
		this.persistUser = this.selectedUser;
		return "/protected/admin/adminPersistUser.jsf";
	}

	public void update() {
		if (this.userHelper.validateInsert(this.persistUser)) {
			this.userHelper.setAuthorityByType(this.persistUser);
			if (DAOFactory.getService().updateUser(this.persistUser) == this.persistUser) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Usuario alterado com sucesso!", "SUCESSO"));
				this.persistUser = new User();
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Erro ao alterar usuario", "ERROR"));
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erro ao alterar usuario", "ERROR"));
		}
	}

	public void insert() {
		if (this.userHelper.validateInsert(this.persistUser)) {
			this.persistUser.setPermission(this.userHelper.setAuthorityByType(
					this.persistUser).name());
			if (DAOFactory.getService().insertUser(this.persistUser) == this.persistUser) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario "
								+ this.persistUser.getUserName()
								+ " inserido com sucesso!", "SUCESSO"));
				this.persistUser = new User();
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Erro ao inserir usu�rio", "ERRO"));
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erro ao inserir usu�rio", "ERRO"));
		}
	}

	public void enableUser() {
		this.persistUser = new User();
		this.selectedUser.setActive(true);
		this.persistUser = this.selectedUser;
		update();
	}

	public void disableUser() {
		this.persistUser = new User();
		this.selectedUser.setActive(false);
		this.persistUser = this.selectedUser;
		update();
	}

	/**
	 * @return the persistUser
	 */
	public User getPersistUser() {
		return persistUser;
	}

	/**
	 * @param persistUser
	 *            the persistUser to set
	 */
	public void setPersistUser(User persistUser) {
		this.persistUser = persistUser;
	}

	/**
	 * @return the selectedUser
	 */
	public User getSelectedUser() {
		return selectedUser;
	}

	/**
	 * @param selectedUser
	 *            the selectedUser to set
	 */
	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	/**
	 * @return the userHelper
	 */
	public UserHelper getUserHelper() {
		return userHelper;
	}

	/**
	 * @param userHelper
	 *            the userHelper to set
	 */
	public void setUserHelper(UserHelper userHelper) {
		this.userHelper = userHelper;
	}
}