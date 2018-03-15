package br.com.imd.cadeduc.ensino.domain;

public class EtapaEnsino {

	private Long id;
	private String nome;
	private Serie serie;
	private int vagasDisponiveis;
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

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
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

}
