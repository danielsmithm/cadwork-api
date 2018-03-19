package br.com.imd.cadeduc.localizacao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "municipio", schema = "localizacao")
public class Municipio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_municipio")
	private Long id;
	private String nome;

	@Column(name = "id_estado")
	@Enumerated(EnumType.ORDINAL)
	private EstadosEnum estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EstadosEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadosEnum estado) {
		this.estado = estado;
	}

}
