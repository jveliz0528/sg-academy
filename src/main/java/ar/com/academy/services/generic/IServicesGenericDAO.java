package ar.com.academy.services.generic;

import java.io.Serializable;
import java.util.List;

public interface IServicesGenericDAO<E> extends Serializable{
	
	public List<E> finAll() throws Exception;	
	
	public E findById(Long id) throws Exception;
	
	public E save(E entity) throws Exception;
	
	public E update(E entity, Long id) throws Exception;
	
	public boolean delete(Long id) throws Exception;	

}