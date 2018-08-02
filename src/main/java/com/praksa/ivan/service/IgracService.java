package com.praksa.ivan.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.praksa.ivan.model.Igrac;

public interface IgracService {
	
	List<Igrac> findAll();
	Page<Igrac> findAll(int pageNum,int pPoStrani );
	Igrac findOne(Long id);
	void save(Igrac ucesnik);
	void remove(Long id);
	List<Igrac> findByKlubId(Long klubId);
	
	Page<Igrac> pretraga(
			@Param("klubid") Long klubid, 
			@Param("ime") String ime,
			@Param("prezime") String prezime,
			@Param("pozicija") String pozicija,
			@Param("pozicija") int pPoStrani,
			int page);
}
