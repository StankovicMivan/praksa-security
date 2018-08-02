package com.praksa.ivan.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praksa.ivan.model.Klub;
import com.praksa.ivan.repository.KlubRepository;
import com.praksa.ivan.service.KlubService;


@Service
public class JpaKlubServiceImpl implements KlubService{

	
	
	@Autowired
	private KlubRepository repo;
	
	public Klub findOne(Long id) {
	
		return repo.findOne(id);
	}

	public Klub save(Klub klub) {
		
		return repo.save(klub);
	}

	public void remove(Long id) {
		repo.delete(id);
		
	}

	@Override
	public List<Klub> findAll() {
	
		return repo.findAll();
	}

	

}
