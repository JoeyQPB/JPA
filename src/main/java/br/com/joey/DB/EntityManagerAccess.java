package br.com.joey.DB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerAccess {

	private static EntityManagerFactory entityManagerFactory = null;
	private static EntityManager entityManager = null;
	
	private EntityManagerAccess() {}
	
	public static EntityManager getEntityManager() {
		if (entityManager == null || !entityManager.isOpen()) entityManager = initEntityManager();
		return entityManager;
	}
	private static EntityManager initEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
		return entityManagerFactory.createEntityManager();
	}
	
	public static void closeEntityManager(EntityManager eM) {
		if (eM != null && eM.isOpen()) {
			entityManagerFactory.close();
			eM.close();
		}
	}
}
