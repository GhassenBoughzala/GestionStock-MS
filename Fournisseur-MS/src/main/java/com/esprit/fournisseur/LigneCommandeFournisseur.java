package com.esprit.fournisseur;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;

@Entity
public class LigneCommandeFournisseur implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long idLigneCmdFrn;

	@ManyToOne
    @JoinColumn(name="idCommandeFournisseur")
	private CommandeFournisseur cmdFournisseur;
/*	
	@ManyToOne
	@JoinColumn(name="IdArticle")
	private Article article;
*/	
	public LigneCommandeFournisseur() {
	
	}

	public Long getIdLigneCmdFrn() {
		return idLigneCmdFrn;
	}

	public void setIdLigneCmdFrn(Long idLigneCmdFrn) {
		this.idLigneCmdFrn = idLigneCmdFrn;
	}

	public CommandeFournisseur getCmdFournisseur() {
		return cmdFournisseur;
	}

	public void setCmdFournisseur(CommandeFournisseur cmdFournisseur) {
		this.cmdFournisseur = cmdFournisseur;
	}
/*
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
*/	
	
}
