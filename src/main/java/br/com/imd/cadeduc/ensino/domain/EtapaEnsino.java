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


/**
 * Classe que define o modelo etapa de ensino 
 * @author Miguel
 * @version 0.1
 *
 */

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

	/**
	 * Método para retorno do id de uma instância de Etapa de Ensino
	 * @return Long - Valor do id
	 */
	
	public Long getId() {
		return id;
	}

	/**
	 * Altera o valor do id de uma instância de Etapa de Ensino
	 * @param id Long - Novo valor do id
	 */
	
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retorna o nome da etapa de ensino
	 * @return String - Nome da etapa de ensino
	 */
	
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome da etapa de ensino
	 * @param nome String - Novo nome da etapa de ensino
	 */
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o número de vagas disponíveis
	 * @return int - Número de vagas
	 */
	public int getVagasDisponiveis() {
		return vagasDisponiveis;
	}
	
	/**
	 * Método que atualiza o número de vagas disponíveis
	 * @param vagasDisponiveis int - Novo número de vagas disponíveis
	 */

	public void setVagasDisponiveis(int vagasDisponiveis) {
		this.vagasDisponiveis = vagasDisponiveis;
	}

	/**
	 * Método para retorno do tipo da etapa de ensino
	 * @return TipoEtapaEnsinoEnum - Etapa de ensino
	 */
	
	public TipoEtapaEnsinoEnum getTipoEtapaEnsino() {
		return tipoEtapaEnsino;
	}

	
	/**
	 * Altera a etapa de ensino da instância
	 * @param tipoEtapaEnsino TipoEtapaEnsinoEnum - Etapa de ensino para ser atualizada
	 */
	
	public void setTipoEtapaEnsino(TipoEtapaEnsinoEnum tipoEtapaEnsino) {
		this.tipoEtapaEnsino = tipoEtapaEnsino;
	}

	/**
	 * Método para retorno da lista de séries da etapa de ensino
	 * @return List<Serie> - Retorna a lista de séries atual
	 */
	
	public List<Serie> getSeries() {
		return series;
	}
	
	/**
	 * Atualiza a lista de séries
	 * @param series List<Serie> - Lista de séries a ser atualizada
	 */

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

}
