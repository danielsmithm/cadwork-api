/**
 * 
 */
package br.com.imd.cadwork.core.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.imd.cadwork.core.localizacao.domain.Endereco;

/**
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

	@Column
	protected String nome;

	@OneToOne(cascade = CascadeType.ALL)
	protected CriterioLocalizacao criterioLocalizacao;

	@OneToOne(cascade = CascadeType.ALL)
	protected Endereco endereco;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	protected abstract boolean validaLocalizavel();

}
