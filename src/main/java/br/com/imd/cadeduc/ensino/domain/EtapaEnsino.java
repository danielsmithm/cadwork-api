package br.com.imd.cadeduc.ensino.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "etapa_ensino", schema = "ensino")
public class EtapaEnsino {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_etapa_ensino")
	private Long id;
	
	private String nome;

	@Column(name = "vagas_disponiveis")
	private int vagasDisponiveis;

	@OneToMany(cascade = CascadeType.ALL)	
	private List<Serie> series;

	@Column(name = "tipo_etapa_ensino")
	@Enumerated(EnumType.ORDINAL)
	private TipoEtapaEnsinoEnum tipoEtapaEnsino;

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

	public int getVagasDisponiveis() {
		return vagasDisponiveis;
	}

	public void setVagasDisponiveis(int vagasDisponiveis) {
		this.vagasDisponiveis = vagasDisponiveis;
	}

	public TipoEtapaEnsinoEnum getTipoEtapaEnsino() {
		return tipoEtapaEnsino;
	}

	public void setTipoEtapaEnsino(TipoEtapaEnsinoEnum tipoEtapaEnsino) {
		this.tipoEtapaEnsino = tipoEtapaEnsino;
	}

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

}
