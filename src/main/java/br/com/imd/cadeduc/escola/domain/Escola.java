package br.com.imd.cadeduc.escola.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.imd.cadeduc.ensino.domain.Serie;
import br.com.imd.cadeduc.localizacao.domain.Endereco;

/**
 * 
 * Classe que define o modelo Escola
 * 
 * @author Miguel
 * @version 0.1
 *
 */

@Entity
@Table(name = "escola", schema = "escola")
public class Escola {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_escola")
	private Long id;
	private String nome;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	@ManyToMany
	@JoinColumn(name = "id_serie")
	private List<Serie> series;
	
	
	/**
	 * Método para retorno do id de uma instância de Escola
	 * @return Long - Valor do id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Altera o valor do id de uma instância de Escola
	 * @param id Long - Novo valor do id
	 */
	
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método que retorna o nome da escola
	 * @return String - Nome da escola
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método que modifica o nome da escola
	 * @param nome String - Novo nome da escola
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o endereço da escola
	 * @return Endereco - Endereço da escola
	 */
	public Endereco getEndereco() {
		return endereco;
	}
	
	/**
	 * Altera o endereço de uma instância de Escola
	 * @param endereco Endereco - Novo endereço
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
