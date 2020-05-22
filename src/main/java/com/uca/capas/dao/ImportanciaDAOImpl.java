package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Importancia;

@Repository
public class ImportanciaDAOImpl implements ImportanciaDAO{
		
	@PersistenceContext(unitName = "capas")
	EntityManager entityManager;
	
	@Override
	public List<Importancia> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		
		sb.append("SELECT * FROM public.importancia");
		
		Query query = entityManager.createNativeQuery(sb.toString(), Importancia.class);
		
		List<Importancia> res = query.getResultList();
		
		return res;
		
	}

	
	public Importancia findOne(Integer code) throws DataAccessException {
		Importancia i = entityManager.find(Importancia.class, code);
		
		return i;
	}

}
