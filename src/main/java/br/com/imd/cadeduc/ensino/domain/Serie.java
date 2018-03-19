package br.com.imd.cadeduc.ensino.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.imd.cadeduc.escola.domain.Escola;

/**
 * 
 * Classe que define o modelo de série
 * 
 * @author Miguel
 * @version 0.1
 */

@Entity
@Table(name = "serie", schema = "ensino")
public class Serie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_serie")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@ManyToMany(mappedBy = "series", cascade = CascadeType.ALL)
	private List<Escola> escolas;

	/**
	 * Método para retorno do id de uma instância de Serie
	 * @return Long - Valor do id
	 */
	
	public Long getId() {
		return id;
	}
	
	/**
	 * Altera o valor do id de uma instância de Serie
	 * @param id Long - Novo valor do id
	 */

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retorna o nome da série
	 * @return String - nome da série
	 */
	
	public String getNome() {
		return nome;
	}

	/**
	 * Modifica o nome da série
	 * @param nome String - novo nome da série
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

}
