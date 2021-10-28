package com.esprit.client;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Client  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String code;
	private String libelle;
	private String contact;
	private String adresse;
	private String tel;
	private String email;
	private String matfisc;
	private String pwd;
	private String timbre;
	private float soldeinit;
	private float solde;
	private String login;
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub	
	}


	public Client(int id, String code, String libelle, String contact, String adresse, String tel, String email,
			String matfisc, String pwd, String timbre, float soldeinit, float solde, String login) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.contact = contact;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.matfisc = matfisc;
		this.pwd = pwd;
		this.timbre = timbre;
		this.soldeinit = soldeinit;
		this.solde = solde;
		this.login = login;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
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


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
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


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTimbre() {
		return timbre;
	}


	public void setTimbre(String timbre) {
		this.timbre = timbre;
	}


	public float getSoldeinit() {
		return soldeinit;
	}


	public void setSoldeinit(float soldeinit) {
		this.soldeinit = soldeinit;
	}


	public float getSolde() {
		return solde;
	}


	public void setSolde(float solde) {
		this.solde = solde;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	@Override
	public String toString() {
		return "Client [id=" + id + ", code=" + code + ", libelle=" + libelle + ", contact=" + contact + ", adresse="
				+ adresse + ", tel=" + tel + ", email=" + email + ", matfisc=" + matfisc + ", pwd=" + pwd +
				 ", timbre=" + timbre + ", soldeinit=" + soldeinit + ", solde=" + solde + ", login=" + login
				+ "]";
	}


	public Client( String libelle, String tel, String email, String pwd, String login) {
		super();
	
		this.libelle = libelle;
		this.tel = tel;
		this.email = email;
		this.pwd = pwd;
		this.login = login;
	}
	
	
	
}
