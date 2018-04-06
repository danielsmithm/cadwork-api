package br.com.imd.cadeduc.domain.exception;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericDAO<T> extends JpaRepository<T, Long> {

}
