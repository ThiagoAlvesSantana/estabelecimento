package br.com.fiap.estabelecimento.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.estabelecimento.domain.Estabelecimento;


@Repository
public interface EstabelecimentoRepository extends PagingAndSortingRepository<Estabelecimento, Long>{

}
