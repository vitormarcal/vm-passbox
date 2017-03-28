package com.vitormarcal.passbox.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "idUsuario")
	private Long id;
	
	private String userName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPessoa", nullable = false)
	private Pessoa pessoa;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<Senha> senhas;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Senha> getSenhas() {
		return senhas;
	}
	public void setSenhas(List<Senha> senhas) {
		this.senhas = senhas;
	}

	
}
