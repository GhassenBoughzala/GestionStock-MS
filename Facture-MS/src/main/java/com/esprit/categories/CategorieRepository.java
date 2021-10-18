package com.esprit.categories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategorieRepository extends JpaRepository<Categorie, Integer>{
	
	@Query("select c from Categorie c where c.code like :code")
	public Page<Categorie> factureByCode(@Param("code") String n, Pageable pageable);

}
