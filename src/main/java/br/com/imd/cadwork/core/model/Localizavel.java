/**
 * 
 */
package br.com.imd.cadwork.core.model;

import br.com.imd.cadwork.localizacao.domain.Endereco;

/**
 * @author Igor Barbosa Nogueira
 * @version 0.1
 */
public abstract class Localizavel {
	
	protected Long id;
	protected String nome;
	protected CriterioLocalizacao criterioLocalizacao;
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
