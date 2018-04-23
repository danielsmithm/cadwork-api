package br.com.imd.cadeduc.ensino.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Classe que define o modelo etapa de ensino
 * 
 * @author Miguel
 * @version 0.2
 *
 */

@Entity
@Table(name = "etapa_ensino", schema = "ensino")
@ApiModel
public class EtapaEnsino {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_etapa_ensino")
	@ApiModelProperty(hidden = true, notes = "ID gerado automaticamente pela base de dados")
	private Long id;

	@NotNull
	@ApiModelProperty(notes = "Nome da Etapa de Ensino", required = true)
	private String nome;

	@NotNull
	@Column(name = "vagas_disponiveis")
	@ApiModelProperty(notes = "Quantidade de vagas disponíveis", required = true)
	private int vagasDisponiveis;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@ApiModelProperty(notes = "séries da etapa de ensino")
	private List<Serie> series;

	@NotNull
	@Column(name = "tipo_etapa_ensino")
	@Enumerated(EnumType.STRING)
	@ApiModelProperty(notes = "Tipo da etapa de ensino", required = true)
	private TipoEtapaEnsinoEnum tipoEtapaEnsino;

	public EtapaEnsino() {
		id = new Long(0);
	}

	/**
	 * Método para retorno do id de uma instância de Etapa de Ensino
	 * 
	 * @return Long - Valor do id
	 */

	public Long getId() {
		return id;
	}

	/**
	 * Altera o valor do id de uma instância de Etapa de Ensino
	 * 
	 * @param id
	 *            Long - Novo valor do id
	 */

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retorna o nome da etapa de ensino
	 * 
	 * @return String - Nome da etapa de ensino
	 */

	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome da etapa de ensino
	 * 
	 * @param nome
	 *            String - Novo nome da etapa de ensino
	 */

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o número de vagas disponíveis
	 * 
	 * @return int - Número de vagas
	 */
	public int getVagasDisponiveis() {
		return vagasDisponiveis;
	}

	/**
	 * Método que atualiza o número de vagas disponíveis
	 * 
	 * @param vagasDisponiveis
	 *            int - Novo número de vagas disponíveis
	 */

	public void setVagasDisponiveis(int vagasDisponiveis) {
		this.vagasDisponiveis = vagasDisponiveis;
	}

	/**
	 * Método para retorno do tipo da etapa de ensino
	 * 
	 * @return TipoEtapaEnsinoEnum - Etapa de ensino
	 */

	public TipoEtapaEnsinoEnum getTipoEtapaEnsino() {
		return tipoEtapaEnsino;
	}

	/**
	 * Altera a etapa de ensino da instância
	 * 
	 * @param tipoEtapaEnsino
	 *            TipoEtapaEnsinoEnum - Etapa de ensino para ser atualizada
	 */

	public void setTipoEtapaEnsino(TipoEtapaEnsinoEnum tipoEtapaEnsino) {
		this.tipoEtapaEnsino = tipoEtapaEnsino;
	}

	/**
	 * Método para retorno da lista de séries da etapa de ensino
	 * 
	 * @return List<Serie> - Retorna a lista de séries atual
	 */

	public List<Serie> getSeries() {
		return series;
	}

	/**
	 * Atualiza a lista de séries
	 * 
	 * @param series
	 *            List<Serie> - Lista de séries a ser atualizada
	 */

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

}
