package com.esprit.article;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.article.ResourceNotFoundException;
import com.esprit.article.Article;
import com.esprit.article.ArticleRepository;


@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping("/api")
public class articleController {
	
	@Autowired
	ArticleRepository repository;
	
	@GetMapping("/articles")
	public List<Article> getAllArticles(){
		System.out.println("Get All Articles ....");
		
		List<Article> Articles = new ArrayList<Article>();
		repository.findAll().forEach(Articles :: add);
		return Articles;
	}
	
	@GetMapping("/articles/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable(value = "id") Long articleId)
	throws ResourceNotFoundException {
		Article article = repository.findById(articleId)
				.orElseThrow(() -> new ResourceNotFoundException("Article not found for this id ::"+articleId));
		return ResponseEntity.ok().body(article);
	}
	
	@PostMapping("/articles")
	public Article createArticle( @RequestBody Article article){
		return repository.save(article);
	}
	
	@DeleteMapping("/articles/{id}")
	public Map<String, Boolean> deleteArticle(@PathVariable(value = "id") Long articleId)
		throws ResourceNotFoundException{
		Article artice = repository.findById(articleId)
				.orElseThrow(() -> new ResourceNotFoundException("Artocle not fond id ::"+ articleId));
		repository.delete(artice);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@DeleteMapping("/articles/delete")
	public ResponseEntity<String> deleteAllArticles(){
		System.out.println("Delete All articles");
		repository.deleteAll();
		return new ResponseEntity<>("All articles have been deleted!", HttpStatus.OK);
	}
	
	@PutMapping("/articles/{id}")
	public ResponseEntity<Article> updateArticle(@PathVariable("id") long id,
			@RequestBody Article Article){
		System.out.println("update Article with Id =" + id + " .....");
		
		Optional<Article> articleInfo = repository.findById(id);
		
		if(articleInfo.isPresent()){
			Article article = articleInfo.get();
			article.setCode(article.getCode());
			article.setLibelle(article.getLibelle());

		
			article.setId_cat(article.getId_cat());
			article.setId_scat(article.getId_scat());
			
			return new ResponseEntity<>(repository.save(article), HttpStatus.OK);	
	
	}else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

}
