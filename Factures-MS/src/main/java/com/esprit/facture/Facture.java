package com.esprit.facture;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Facture implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String code;
	private String adresse;
	private String tel;
	private String email;
	private String matfisc;
	private float prix;
	private int quantite;
	
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatfisc() {
		return matfisc;
	}

	public void setMatfisc(String matfisc) {
		this.matfisc = matfisc;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Facture(String code, String adresse, String tel, String email, String matfisc, float prix, int quantite) {
		super();
		this.code = code;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.matfisc = matfisc;
		this.prix = prix;
		this.quantite = quantite;
	}
	
	

	public Facture(String adresse, String tel, String email) {
		super();
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Facture [id=" + id + ", code=" + code + ", adresse=" + adresse + ", tel=" + tel + ", email=" + email
				+ ", matfisc=" + matfisc + ", prix=" + prix + ", quantite=" + quantite + "]";
	}

	
	
	

}
