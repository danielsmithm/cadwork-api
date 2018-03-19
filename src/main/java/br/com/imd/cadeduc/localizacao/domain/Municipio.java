package br.com.imd.cadeduc.localizacao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe que define o modelo Municipio
 * @author Miguel
 * @version 0.1
 */

@Entity
@Table(name = "municipio", schema = "localizacao")
public class Municipio {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_municipio")
	private Long id;
	private String nome;

	@Column(name = "tipo_vigencia")
	@Enumerated(EnumType.ORDINAL)
	private EstadosEnum estado;

	/**
	 * Método para retorno do id de uma instância de Municipio
	 * @return Long - Valor do id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Altera o valor do id de uma instância de Municipio
	 * @param id Long - Novo valor do id
	 */
	
	public void setId(Long id) {
		this.id = id;
	}

	
	/**
	 * Retorna o nome do município
	 * @return String - nome do município
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome do município
	 * @param nome String - novo nome do município
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o estado ao qual o município pertence
	 * @return EstadosEnum - estado ao qual o município pertence
	 */
	public EstadosEnum getEstado() {
		return estado;
	}

	/**
	 * Altera o estado ao qual o município pertence
	 * @param estado EstadosEnum - novo estado ao qual o município pertence
	 */
	
	public void setEstado(EstadosEnum estado) {
		this.estado = estado;
	}

}
