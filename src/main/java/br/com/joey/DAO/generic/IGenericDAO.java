package br.com.joey.DAO.generic;

import java.io.Serializable;
import java.util.List;

import br.com.joey.interfaces.IPersistence;

public interface IGenericDAO<T extends IPersistence, E extends Serializable> {

	public T insert(T entity); 
	
	public T select(E value);
	
	public List<T> selectAll();
	
	public T update(E value, T entity);
	
	public Boolean delete(Long value);
}
