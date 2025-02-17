package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.ImportanciaDAO;
import com.uca.capas.domain.Importancia;

@Service
public class ImportanciaServiceImpl implements ImportanciaService{
	@Autowired
	ImportanciaDAO importanciaDao;

	public List<Importancia> findAll() throws DataAccessException {
		return importanciaDao.findAll();
	}

	
	public Importancia findOne(Integer code) throws DataAccessException {
		
		return importanciaDao.findOne(code);
	}
}
