package com.praksa.ivan.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.praksa.ivan.model.Igrac;
import com.praksa.ivan.repository.IgracRepository;
import com.praksa.ivan.service.IgracService;


@Service
public class JpaIgracServiceImpl implements IgracService{

	@Autowired
	private IgracRepository igracRepository;
	
	
	public List<Igrac> findAll() {
		return igracRepository.findAll();
	}
	public Igrac findOne(Long id) {
		
		return igracRepository.findOne(id);
	}

	public void save(Igrac igrac) {
	
		igracRepository.save(igrac);
		
	}

	public void remove(Long id) {
		igracRepository.delete(id);
		
	}

	public List<Igrac> findByKlubId(Long klubId) {
		
		return igracRepository.findByKlubId(klubId);
	}
	@Override
	public Page<Igrac> findAll(int pageNum, int pPoStrani) {
		
		return igracRepository.findAll(new PageRequest(pageNum, pPoStrani ));
	}
	@Override
	public Page<Igrac> pretraga(Long klubid, String ime, String prezime,String pozicija,int pPoStrani, int page) {
		if(ime != null) {
			ime = "%" + ime + "%";
		}
		if(prezime != null) {
			prezime = "%" + prezime + "%";
		}
		if(pozicija != null) {
			pozicija = "%" + pozicija + "%";
		}
		return igracRepository.pretraga(klubid, ime, prezime, pozicija, new PageRequest(page, pPoStrani));
	}

}
