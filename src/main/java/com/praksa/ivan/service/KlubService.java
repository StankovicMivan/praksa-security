package com.praksa.ivan.service;



import java.util.List;

import com.praksa.ivan.model.Klub;

public interface KlubService {

	
	Klub findOne(Long id);
	Klub save(Klub klub);
	void remove(Long id);
	List<Klub> findAll();
}
