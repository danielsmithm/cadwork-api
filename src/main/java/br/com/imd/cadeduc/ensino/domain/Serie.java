package br.com.imd.cadeduc.ensino.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.imd.cadeduc.escola.domain.Escola;

@Entity
@Table(name = "serie", schema = "ensino")
public class Serie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_serie")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@ManyToMany(mappedBy = "series", cascade = CascadeType.ALL)
	private List<Escola> escolas;

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

}
