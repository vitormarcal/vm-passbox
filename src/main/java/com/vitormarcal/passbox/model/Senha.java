package com.vitormarcal.passbox.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "senha")
public class Senha implements Serializable {

	private static final long serialVersionUID = -7870217310906599035L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "idSenha")
	private Long id;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String palavraPasse;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idLocalCredenciado", nullable = false)
	private LocalCredenciado localCredenciado;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPalavraPasse() {
		return palavraPasse;
	}
	public void setPalavraPasse(String palavraPasse) {
		this.palavraPasse = palavraPasse;
	}

	public LocalCredenciado getLocalCredenciado() {
		return localCredenciado;
	}
	
	public void setLocalCredenciado(LocalCredenciado localCredenciado) {
		this.localCredenciado = localCredenciado;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((palavraPasse == null) ? 0 : palavraPasse.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Senha other = (Senha) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (palavraPasse == null) {
			if (other.palavraPasse != null)
				return false;
		} else if (!palavraPasse.equals(other.palavraPasse))
			return false;
		return true;
	}


	
	
	
	

}
