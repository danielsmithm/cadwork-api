package br.com.imd.cadwork.core.localizavel.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.imd.cadwork.core.localizacao.domain.Endereco;

/**
 * Classe abstrata para ser base do modelo do item localizavel
 * 
 * @author Igor Barbosa Nogueira
 * @author Miguel
 * @version 0.2
 */
@MappedSuperclass
@Table(name = "localizavel", schema = "localizavel")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Localizavel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column
	protected String nome;

	@OneToOne(cascade = CascadeType.ALL)
	protected Endereco endereco;

	/**
	 * Retorna o endereço do localizavel
	 * 
	 * @return Endereco - Endereço da escola
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * Altera o endereço de uma instância de Localizavel
	 * 
	 * @param endereco
	 *            Endereco - Novo endereço
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/**
	 * Método para retorno do id de uma instância de Localizavel
	 * 
	 * @return Long - Valor do id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Altera o valor do id de uma instância de Localizavel
	 * 
	 * @param id
	 *            Long - Novo valor do id
	 */

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método que retorna o nome do localizavel
	 * 
	 * @return String - Nome do localizavel
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método que modifica o nome do localizavel
	 * 
	 * @param nome
	 *            String - Novo nome do localizavel
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método que valida o localizavel
	 * 
	 * @return boolean - Se o localizavel é válido ou não
	 */
	protected abstract boolean validaLocalizavel();

}