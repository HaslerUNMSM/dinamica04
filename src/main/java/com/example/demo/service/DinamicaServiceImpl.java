package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Dinamica;
import com.example.demo.model.IDinamica;

@Service
public class DinamicaServiceImpl implements IDinamicaService{

	@Autowired
	private IDinamica dinamicaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Dinamica> findAll() {
		return (List<Dinamica>) dinamicaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Dinamica dinamica) {
		dinamicaDao.save(dinamica);
	}

	@Override
	@Transactional(readOnly = true)
	public Dinamica findById(Long id) {
		return dinamicaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Dinamica dinamica) {
		dinamicaDao.delete(dinamica);
		
	}

}
