package com.onfocus.jfood.view;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import com.onfocus.jfood.enums.Language;
import com.onfocus.jfood.helper.UserHelper;
import com.onfocus.jfood.model.User;
import com.onfocus.jfood.util.DAOFactory;

@ManagedBean(name = "userView")
@SessionScoped
public class UserView implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String PERSIST_USER = "/protected/admin/adminPersistUser.jsf";

	private static final String CONSULT_USER = "/protected/admin/adminUser.jsf";

	private User persistUser;

	private User selectedUser;

	private UserHelper userHelper;

	private Language language;

	private Locale locale;

	public UserView() {
		userHelper = new UserHelper();
	}

	public String preparePersist() {
		this.persistUser = new User();
		return PERSIST_USER;
	}

	public String prepareUpdate() {
		this.persistUser = this.selectedUser;
		return PERSIST_USER;
	}

	public String update() {
		this.userHelper.setAuthorityByType(this.persistUser);
		if (DAOFactory.getService().updateUser(this.persistUser) == this.persistUser) {
			FacesContext.getCurrentInstance().addMessage("userMessages",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário alterado com sucesso!", "SUCESSO"));
			this.persistUser = new User();
		} else {
			FacesContext.getCurrentInstance().addMessage("userMessages",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao alterar usuário", "ERROR"));
		}
		return CONSULT_USER;
	}

	public void insert() {
		this.persistUser.setPermission(this.userHelper.setAuthorityByType(this.persistUser).name());
		if (DAOFactory.getService().insertUser(this.persistUser) == this.persistUser) {
			FacesContext.getCurrentInstance().addMessage(
					"userMessages",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário " + this.persistUser.getUserName()
							+ " inserido com sucesso!", "SUCESSO"));
			this.persistUser = new User();
		} else {
			FacesContext.getCurrentInstance().addMessage("userMessages",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao inserir usuário", "ERRO"));
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

	public void changeLanguage() {
		try {
			if (this.language.equals(Language.PORTUGUESE)) {
				locale = new Locale("pt", "BR");
			} else if (this.language.equals(Language.ENGLISH)) {
				locale = new Locale("en", "US");
			}
			UIViewRoot viewRoot = new UIViewRoot();
			viewRoot.setLocale(locale);
			FacesContext.getCurrentInstance().setViewRoot(viewRoot);
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	/**
	 * @return the locale
	 */
	public Language getLanguage() {
		return language;
	}

	/**
	 * @param language
	 *            the locale to set
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}

	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * @param locale
	 *            the locale to set
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
}