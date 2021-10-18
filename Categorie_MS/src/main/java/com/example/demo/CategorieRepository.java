package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
	@Query("select c from Categorie c where c.code like :code")
	public Page<Categorie> factureByNom(@Param("code") String n, Pageable pageable);
}
