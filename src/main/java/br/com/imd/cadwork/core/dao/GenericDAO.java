package br.com.imd.cadwork.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
/**
 * Interface para criação de DAO no sistema
 * @author Welligton Miguel
 *
 * @param <T> - Classe modelo para criar o DAO
 */
@NoRepositoryBean
public interface GenericDAO<T> extends JpaRepository<T, Long> {

}
