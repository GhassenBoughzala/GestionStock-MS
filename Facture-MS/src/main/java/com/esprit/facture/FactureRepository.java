package com.esprit.factures;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FactureRepository extends JpaRepository<Facture, Integer>{
	
	@Query("select c from Facture c where c.nom like :nom")
	public Page<Facture> factureByNom(@Param("nom") String n, Pageable pageable);

}
