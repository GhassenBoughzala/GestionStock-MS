package com.esprit.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.esprit.article.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{
	
}
