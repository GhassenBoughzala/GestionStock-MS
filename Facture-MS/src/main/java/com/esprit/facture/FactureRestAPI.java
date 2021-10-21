package com.esprit.facture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class FactureRestAPI {
	@Autowired
	FactureRepository repository;
	
	@GetMapping("/Factures")
	public List<Facture> getAllFactures(){
		System.out.println("Get All Factures ....");
		
		List<Facture> Factures = new ArrayList<Facture>();
		repository.findAll().forEach(Factures :: add);
		return Factures;
	}
	
	@GetMapping("/Factures/{id}")
	public ResponseEntity<Facture> getFactureById(@PathVariable(value = "id") long FactureId)
	throws ResourceNotFoundException {
		Facture Facture = repository.findById(FactureId)
				.orElseThrow(() -> new ResourceNotFoundException("Facture not found for this id ::" +FactureId));
		return ResponseEntity.ok().body(Facture);
	}
	
	@PostMapping("/Factures")
	public Facture createFacture( @RequestBody Facture Facture){
		return repository.save(Facture);
	}
	
	@DeleteMapping("/Factures/{id}")
	public Map<String, Boolean> deleteFacture(@PathVariable(value = "id") long FactureId)
		throws ResourceNotFoundException{
		Facture Facture = repository.findById(FactureId)
				.orElseThrow(() -> new ResourceNotFoundException("Artocle not found id ::" + FactureId));
		repository.delete(Facture);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@DeleteMapping("/Factures/delete")
	public ResponseEntity<String> deleteAllFactures(){
		System.out.println("Delete All Factures");
		repository.deleteAll();
		return new ResponseEntity<>("All Factures have been deleted!", HttpStatus.OK);
	}
	
	
	@PutMapping("/Factures/{id}")
	public ResponseEntity<Facture> updateFacture (@PathVariable("id") long id,
			@RequestBody Facture Facture){
		System.out.println("update Facture with Id =" + id + " .....");
		
		Optional<Facture> FacturesInfo = repository.findById(id);
		
		if(FacturesInfo.isPresent()){
			Facture fact = FacturesInfo.get();
			fact.setCode(Facture.getCode());
			fact.setTel(Facture.getTel());
			fact.setAdresse(Facture.getAdresse());
			fact.setEmail(Facture.getEmail());
			fact.setMatfisc(Facture.getMatfisc());
			fact.setPrix(Facture.getPrix());
			fact.setQuantite(Facture.getQuantite());
			
			return new ResponseEntity<>(repository.save(Facture), HttpStatus.OK);	
	
	}else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
}
