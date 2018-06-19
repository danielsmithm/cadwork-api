package br.com.imd.cadwork.core.localizavel.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.imd.cadwork.core.localizacao.domain.Endereco;
import br.com.imd.cadwork.core.service.GoogleService;

/**
 * Classe abstrata para ser base do modelo do item localizavel
 * 
 * @author Igor Barbosa Nogueira
 * @author Miguel
 * @version 0.2
 */
@Entity
@Table(name = "localizavel", schema = "localizavel")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Localizavel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@NotNull
	@Column
	protected String nome;

	@NotNull
	@OneToOne(cascade = CascadeType.REFRESH)
	protected Endereco endereco;

	@NotNull
	@OneToMany(cascade = CascadeType.ALL)
	@Autowired
	protected List<CriterioLocalizacao> criterioLocalizacao;

	
	@Transient
	@Autowired
	protected GoogleService google;
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
	 * Método que retorna o critério de localização
	 * 
	 * @return List<CriterioLocalizacao>  - Critério para buscar o localizavel
	 */
	public List<CriterioLocalizacao> getCriterioLocalizacao() {
		return criterioLocalizacao;
	}

	 /**
	 * Método que modifica o tipo de critério para buscar o localizavel
	 * 
	 * @param criterioLocalizacao
	 *            List<CriterioLocalizacao> - Novo critério para buscar o localizavel
	 */
	public void setCriterioLocalizacao(List<CriterioLocalizacao> criterioLocalizacao) {
		this.criterioLocalizacao = criterioLocalizacao;
	}

	/**
	 * Método que será implentado pelas classes filhas com finalidade
	 *  de validar a existência do localizável
	 * 
	 * @return boolean - Se o localizavel é válido ou não
	 */
	public abstract boolean validaLocalizavel();

}