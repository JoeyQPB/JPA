package br.com.joey.DAO.generic;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.joey.DB.EntityManagerAccess;
import br.com.joey.interfaces.IPersistence;

public abstract class GenericDAO<T extends IPersistence, E extends Serializable> implements IGenericDAO<T, E> {
	
	EntityManager entityManager = null;
	
	public Class<T> clazz = getClazz();
	public abstract Class<T> getClazz();
	
	@Override
	public T insert(T entity) {
		entityManager = EntityManagerAccess.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
		    return entity;
		}
		catch (Exception e) {
		    if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
		    throw e;
		}
		finally {
			EntityManagerAccess.closeEntityManager(entityManager);
		}
	}

	@Override
	public T select(E value) {
		entityManager = EntityManagerAccess.getEntityManager();
		try {
			entityManager.getTransaction().begin();

			T entity = entityManager.find(clazz, value);

			entityManager.getTransaction().commit();
			return entity;
		}
		catch (Exception e) {
		    if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
		    throw e;
		}
		finally {
			EntityManagerAccess.closeEntityManager(entityManager);
		}
	}

	@Override
	public List<T> selectAll() {
		entityManager = EntityManagerAccess.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			
	        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
	        Root<T> root = criteriaQuery.from(clazz);
	        criteriaQuery.select(root);

	        TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);
	        List<T> resultList = typedQuery.getResultList();
	        
			entityManager.getTransaction().commit();
		    return resultList;
		}
		catch (Exception e) {
		    if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
		    throw e;
		}
		finally {
			EntityManagerAccess.closeEntityManager(entityManager);
		}
	}

	@Override
	public T update(E value, T entity) {
		entityManager = EntityManagerAccess.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			
			T entityFromBD = entityManager.find(clazz, value);
			entity.setId(entityFromBD.getId());
			entityManager.merge(entity);
			
			entityManager.getTransaction().commit();
			return entity;
		}
		catch (Exception e) {
		    if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
		    throw e;
		}
		finally {
			EntityManagerAccess.closeEntityManager(entityManager);
		}
	}

	@Override
	public Boolean delete(Long value) {
		entityManager = EntityManagerAccess.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			
	        T entity = entityManager.find(clazz, value);
	        if (entity != null) {
	            entityManager.remove(entity);
	        } else {
	            throw new EntityNotFoundException("Entidade com ID " + value + " não encontrada para exclusão.");
	        }
	        
			entityManager.getTransaction().commit();
			return true;
		}
		catch (Exception e) {
		    if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
		    throw e;
		}
		finally {
			EntityManagerAccess.closeEntityManager(entityManager);
		}
	}
}
