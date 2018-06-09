package br.com.imd.cadwork.core.localizavel.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import br.com.imd.cadwork.core.dao.GenericDomainException;

@MappedSuperclass
@Table(name = "localizavel", schema = "criterio")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class CriterioLocalizacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	protected abstract void validaCriterios() throws GenericDomainException;
}
