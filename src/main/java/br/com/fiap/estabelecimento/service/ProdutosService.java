package br.com.fiap.estabelecimento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.fiap.estabelecimento.domain.Produto;
import br.com.fiap.estabelecimento.repository.ProdutoRepository;

@Service
public class ProdutosService {

	@Autowired
	private ProdutoRepository repository;

	public Page<Produto> list() {
		return repository.findAll(PageRequest.of(0, 3));
	}

	public Produto listProduto(long id) {
		Optional<Produto> produto = repository.findById(id);
		return produto.get();
	}

	public void criarProduto(Produto produto) {
		repository.save(produto);
	}

	public void deletarProduto(long id) {
		repository.deleteById(id);
	}
}