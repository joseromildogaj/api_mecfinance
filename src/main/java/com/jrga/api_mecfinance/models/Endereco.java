package com.jrga.api_mecfinance.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Endereco {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
    private String uf;
	
	@Column(nullable = false)
    private String cidade;
	
	@Column(nullable = false)
    private String bairro;
	
	@Column(nullable = false)
    private String rua;
	
	@Column(nullable = true)
    private int numero;
	
	@Column(nullable = true)
    private String complemento;
	
	@Column(nullable = false)
    private String cep;
    
	public Endereco() {}

	
	public Endereco(int id, String uf, String cidade, String bairro, String rua, int numero, String complemento,
			String cep) {
		this.id = id;
		this.uf = uf;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}

    public Endereco(String uf, String cidade, String bairro, String rua, int numero, String complemento,
			String cep) {
		this.uf = uf;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", uf=" + uf + ", cidade=" + cidade + ", bairro=" + bairro
				+ ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", cep=" + cep + "]";
	}

    
}
