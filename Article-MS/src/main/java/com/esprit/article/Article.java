package com.esprit.article;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "article") 
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String code;
	private String libelle;
	private float stock;
	private String image;
	private long id_cat;
	private long id_scat;
	
	
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Article(Long id, String code, String libelle, float pa, int tva, int fodec, int dc, float pv, float stk_init,
			float stock, String image, long id_cat, long id_scat) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.stock = stock;
		this.image = image;
		this.id_cat = id_cat;
		this.id_scat = id_scat;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getLibelle() {
		return libelle;
	}



	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}




	public float getStock() {
		return stock;
	}



	public void setStock(float stock) {
		this.stock = stock;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public long getId_cat() {
		return id_cat;
	}



	public void setId_cat(long id_cat) {
		this.id_cat = id_cat;
	}



	public long getId_scat() {
		return id_scat;
	}



	public void setId_scat(long id_scat) {
		this.id_scat = id_scat;
	}



	@Override
	public String toString() {
		return "Article [id=" + id + ", code=" + code + ", libelle=" + libelle +    ", stock=" + stock
				+ ", image=" + image + ", id_cat=" + id_cat + ", id_scat=" + id_scat + "]";
	}
	
	

}
