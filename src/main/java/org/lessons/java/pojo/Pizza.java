package org.lessons.java.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Il nome non può essere null")
	private String nome;
	@NotBlank(message = "La descrizione non può essere null")
	private String descrizione;
	@NotBlank(message = "URL foto non può essere null")
	private String foto;
	@Min(value = 0, message = "Il prezzo non può essere minore di 0")
	private int prezzo;
	
	public Pizza() {}
	public Pizza(String nome, String descrizione, String foto, int prezzo) {
		setNome(nome);
		setDescrizione(descrizione);
		setFoto(foto);
		setPrezzo(prezzo);
	}
	
	//get e set
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public int getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] " + getNome() 
				+ "\nDescrizione: " + getDescrizione()
				+ "\nPrezzo: " + getPrezzo();
	}
}