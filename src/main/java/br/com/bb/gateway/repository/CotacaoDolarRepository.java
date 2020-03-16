package br.com.bb.gateway.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.bb.domain.CotacaoDolar;

@Repository
public interface CotacaoDolarRepository extends CrudRepository<CotacaoDolar, Long>{

}
