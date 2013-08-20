/**
 * 
 */
package com.onfocus.jfood.util;

/**
 * @author Roner
 * 
 */
public class DAOFactory {

	public DAOFactory() {
	}

	/**
	 * Factory de serviços
	 * 
	 * @return interface de serviços
	 */
	public static GenericDAO getService() {
		GenericImplDAO dao = new GenericImplDAO();
		dao.setSession(HibernateUtil.getSessionfactory().getCurrentSession());
		return dao;
	}
}
