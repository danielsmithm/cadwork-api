package br.com.imd.cadwork.core.localizavel.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import br.com.imd.cadwork.core.dao.GenericDomainException;

/**
 * Classe abstrata para ser base do modelo do critério de localização
 * 
 * @author Miguel
 * @version 0.1
 */
@MappedSuperclass
@Table(name = "localizavel", schema = "criterio")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class CriterioLocalizacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	/**
	 * Método para retorno do id de uma instância do critério
	 * 
	 * @return Long - Valor do id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Altera o valor do id de uma instância do critério
	 * 
	 * @param id
	 *            Long - Novo valor do id
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * Método que será implementado pelas classes filhas com finalidade de limitar os possíveis
	 * itens localizáveis
	 * @throws GenericDomainException
	 */
	protected abstract void validaCriterios() throws GenericDomainException;
}
