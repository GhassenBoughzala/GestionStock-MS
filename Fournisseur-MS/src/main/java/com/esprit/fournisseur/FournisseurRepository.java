package com.esprit.fournisseur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.esprit.fournisseur.Fournisseur;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long>{
	
}
