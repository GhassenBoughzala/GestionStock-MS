package com.esprit.fournisseur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FournisseurRestAPI {
	
	@Autowired
	FournisseurRepository repository;
	
	@GetMapping("/Fournisseurs")
	public List<Fournisseur> getallFo(){
		System.out.println("Get All Fournisseurs...");
		List<Fournisseur> Fournisseurs = new ArrayList<Fournisseur>();
		repository.findAll().forEach(Fournisseurs :: add);
		return Fournisseurs;
	}
	
	@GetMapping("/Fournisseurs/{id}")
	public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable(value = "id") Long FournisseurId)
	throws ResourceNotFoundException {
		Fournisseur Fournisseur = repository.findById(FournisseurId)
				.orElseThrow(() -> new ResourceNotFoundException("Fournisseur not found for this id ::" +FournisseurId));
		return ResponseEntity.ok().body(Fournisseur);
	}
	
	//@PostMapping("/Fournisseurs")
	@RequestMapping(method=RequestMethod.POST, value="/Fournisseurs")
	public Fournisseur addFo(@RequestBody Fournisseur Fournisseur){
		System.out.println("Add +");
		return repository.save(Fournisseur);
	}
	
	@DeleteMapping("/Fournisseurs/{id}")
	public Map<String, Boolean> deleteFournisseur(@PathVariable(value = "id") Long FournisseurId)
		throws ResourceNotFoundException{
		Fournisseur Fournisseur = repository.findById(FournisseurId)
				.orElseThrow(() -> new ResourceNotFoundException("Artocle not found id ::" + FournisseurId));
		repository.delete(Fournisseur);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	
	//@DeleteMapping("/Fournisseurs/delete")
	@RequestMapping(method=RequestMethod.DELETE, value="/Fournisseurs/delete")
	public ResponseEntity<String> deleteAllFournisseurs(){
		System.out.println("Delete All Fournisseurs");
		repository.deleteAll();
		return new ResponseEntity<>("All Fournisseurs have been deleted!", HttpStatus.OK);
	}
	
	
	@PutMapping("/Fournisseurs/{id}")
	public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable("id") long id,
			@RequestBody Fournisseur Fournisseur){
		System.out.println("update Fournisseur with Id =" + id + " .....");
		
		Optional<Fournisseur> FournisseurInfo = repository.findById(id);
		
		if(FournisseurInfo.isPresent()){
			Fournisseur four = FournisseurInfo.get();
			four.setNom(Fournisseur.getNom());
			four.setPrenom(Fournisseur.getPrenom());
			four.setAdresse(Fournisseur.getAdresse());
			four.setPhoto(Fournisseur.getPhoto());
			four.setMail(Fournisseur.getMail());
						
			return new ResponseEntity<>(repository.save(Fournisseur), HttpStatus.OK);	
	
	}else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

}
