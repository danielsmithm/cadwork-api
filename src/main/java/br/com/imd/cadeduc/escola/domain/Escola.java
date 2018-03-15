package br.com.imd.cadeduc.escola.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.imd.cadeduc.ensino.domain.Serie;
import br.com.imd.cadeduc.localizacao.domain.Endereco;

@Entity
@Table(name = "escola", schema = "escola")
public class Escola {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_escola")
	private Long id;
	private String nome;

	/*@OneToOne
	@Column(name = "id_endereco")*/
	@Transient
	private Endereco endereco;

	@ManyToMany
	private List<Serie> series;

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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
