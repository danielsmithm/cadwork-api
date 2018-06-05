package br.com.imd.cadwork.localizavel.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.imd.cadwork.criterio.domain.Serie;
import br.com.imd.cadwork.localizacao.domain.Endereco;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * Classe que define o modelo Escola
 * 
 * @author Miguel
 * @version 0.3
 *
 */

@Entity
@Table(name = "escola", schema = "escola")
@ApiModel
public class Escola {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_escola")
	@ApiModelProperty(hidden = true, notes = "ID gerado automaticamente pela base de dados")
	private Long id;

	@NotBlank(message = "Campo em branco")
	@NotNull(message = "Campo nulo")
	@ApiModelProperty(notes = "Nome da instituição", required = true)
	private String nome;

	@ApiModelProperty(notes = "Telefone da instituição")
	private String telefone;

	@NotNull(message = "Campo nulo")
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_endereco")
	@ApiModelProperty(notes = "Endereço da Instituição", required = true)
	private Endereco endereco;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_serie")
	@ApiModelProperty(notes = "Séries da instituição")
	private List<Serie> series;

	public Escola() {
		id = new Long(0);
	}

	/**
	 * Método para retorno do id de uma instância de Escola
	 * 
	 * @return Long - Valor do id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Altera o valor do id de uma instância de Escola
	 * 
	 * @param id
	 *            Long - Novo valor do id
	 */

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método que retorna o nome da escola
	 * 
	 * @return String - Nome da escola
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método que modifica o nome da escola
	 * 
	 * @param nome
	 *            String - Novo nome da escola
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o endereço da escola
	 * 
	 * @return Endereco - Endereço da escola
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * Altera o endereço de uma instância de Escola
	 * 
	 * @param endereco
	 *            Endereco - Novo endereço
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/**
	 * Método para retorno o telefone da escola
	 * 
	 * @return String - Telefone da escola
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Altera o telefone de uma instância de Escola
	 * 
	 * @param telefone
	 *            String - Novo Telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Método para retornar as séries de uma escola
	 * 
	 * @return List<Serie> series da escola
	 */
	public List<Serie> getSeries() {
		return series;
	}

	/**
	 * Altera as séries de uma instância de Escola
	 * 
	 * @param series
	 *            String - Novo Telefone
	 */
	public void setSeries(List<Serie> series) {
		this.series = series;
	}

}
