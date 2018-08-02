package com.praksa.ivan.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.praksa.ivan.model.Igrac;
@Repository
public interface IgracRepository extends JpaRepository<Igrac, Long>{

	List<Igrac> findByKlubId(Long klubId);

	@Query("SELECT i FROM Igrac i WHERE "
			+ "(:klubid IS NULL or i.klub.id = :klubid ) AND "
			+ "(:ime IS NULL OR i.ime like :ime  ) AND "
			+ "(:prezime IS NULL OR i.prezime like :prezime  ) AND "
			+ "(:pozicija IS NULL OR i.pozicija like :pozicija  ) "
			)
	Page<Igrac> pretraga(
			@Param("klubid") Long klubid, 
			@Param("ime") String ime, 
			@Param("prezime") String prezime, 
			@Param("pozicija") String pozicija, Pageable pageRequest);
}
