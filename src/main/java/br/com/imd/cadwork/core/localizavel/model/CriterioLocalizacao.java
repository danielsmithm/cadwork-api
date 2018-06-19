package br.com.imd.cadwork.core.localizavel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.imd.cadwork.core.dao.GenericDomainException;

/**
 * Classe abstrata para ser base do modelo do critério de localização
 * 
 * @author Miguel
 * @version 0.1
 */
@Entity
@Table(name = "criterio", schema = "criterio")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class CriterioLocalizacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	@NotNull
	@Column
	protected String nome;

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
	 * Método que será implementado pelas classes filhas com finalidade de limitar os possíveis
	 * itens localizáveis
	 * @throws GenericDomainException
	 */
	public abstract void validaCriterios() throws GenericDomainException;
}
