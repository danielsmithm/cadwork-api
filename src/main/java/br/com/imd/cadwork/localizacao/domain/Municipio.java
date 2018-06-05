package br.com.imd.cadwork.localizacao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Classe que define o modelo Municipio
 * 
 * @author Miguel
 * @version 0.5
 */

@Entity
@Table(name = "municipio", schema = "localizacao")
@ApiModel
public class Municipio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_municipio")
	@ApiModelProperty(hidden = true, notes = "ID gerado automaticamente pela base de dados")
	private Long id;

	@NotBlank(message = "Campo em branco")
	@NotNull(message = "Campo nulo")
	@ApiModelProperty(notes = "Nome de um município", required = true)
	private String nome;

	@NotNull(message = "Preencha o campo")
	@Column(name = "estado")
	@Enumerated(EnumType.STRING)
	@ApiModelProperty(notes = "Estado ao qual o municipio pertence", required = true)
	private EstadosEnum estado;

	
	public Municipio() {
		id = new Long(0);
	}
	
	
	/**
	 * Método para retorno do id de uma instância de Municipio
	 * 
	 * @return Long - Valor do id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Altera o valor do id de uma instância de Municipio
	 * 
	 * @param id
	 *            Long - Novo valor do id
	 */

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retorna o nome do município
	 * 
	 * @return String - nome do município
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome do município
	 * 
	 * @param nome
	 *            String - novo nome do município
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o estado ao qual o município pertence
	 * 
	 * @return EstadosEnum - estado ao qual o município pertence
	 */
	public EstadosEnum getEstado() {
		return estado;
	}

	/**
	 * Altera o estado ao qual o município pertence
	 * 
	 * @param estado
	 *            EstadosEnum - novo estado ao qual o município pertence
	 */

	public void setEstado(EstadosEnum estado) {
		this.estado = estado;
	}

}
