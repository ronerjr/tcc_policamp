package com.onfocus.jfood.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Roner
 * 
 */
public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	/**
	 * Método para criar o SessionFactory; Configura uma conexão com o banco de
	 * dados
	 * 
	 * @return SessionFactory
	 */
	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
		try {
			Configuration cfg = new Configuration();
			// busca arquivo de configuração do hibernate
			cfg.configure("hibernate.cfg.xml");
			return cfg.buildSessionFactory();
		} catch (Throwable e) {
			System.out
					.println("Criação inicial do objeto SessionFactory falhou. Erro: "
							+ e);
			throw new ExceptionInInitializerError();
		}
	}

	/**
	 * Método para retornar o SessionFactory
	 * 
	 * @return the sessionfactory
	 */
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
}
