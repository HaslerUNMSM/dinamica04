package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Dinamica;

public interface IDinamicaService {
	
	public List<Dinamica> findAll();
	
	public void save(Dinamica dinamica);
	
	public Dinamica findById(Long id);
	
	public void delete(Dinamica dinamica);

}
