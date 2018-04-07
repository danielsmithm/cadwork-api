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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.imd.cadeduc.escola.domain.Escola;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * Classe que define o modelo de série
 * 
 * @author Miguel
 * @version 0.3
 */

@Entity
@Table(name = "serie", schema = "ensino")
@ApiModel
public class Serie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_serie")
	@ApiModelProperty(hidden = true, notes = "ID gerado automaticamente pela base de dados")
	private Long id;

	@NotBlank(message = "Campo em branco")
	@NotNull(message = "Campo nulo")
	@Column(name = "nome")
	@ApiModelProperty(notes = "Nome da série", required = true)
	private String nome;

	@ManyToMany(mappedBy = "series", cascade = CascadeType.ALL)
	@ApiModelProperty(notes = "Escolas em que a série é disponibilizada")
	private List<Escola> escolas;

	/**
	 * Método para retorno do id de uma instância de Serie
	 * 
	 * @return Long - Valor do id
	 */

	public Long getId() {
		return id;
	}

	/**
	 * Altera o valor do id de uma instância de Serie
	 * 
	 * @param id
	 *            Long - Novo valor do id
	 */

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retorna o nome da série
	 * 
	 * @return String - nome da série
	 */

	public String getNome() {
		return nome;
	}

	/**
	 * Modifica o nome da série
	 * 
	 * @param nome
	 *            String - novo nome da série
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

}
