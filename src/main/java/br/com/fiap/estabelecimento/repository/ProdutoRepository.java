package br.com.fiap.estabelecimento.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.estabelecimento.domain.Produto;

@Repository
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long>{

}
