package br.com.fiap.estabelecimento.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.estabelecimento.domain.Produto;
import br.com.fiap.estabelecimento.service.ProdutosService;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutosService service;

	@GetMapping()
	public ResponseEntity<Page<Produto>> list() {
		final Page<Produto> produto = service.list().map(Produto::new);
		return ResponseEntity.ok(produto);
	}
	
	@GetMapping(path = "{id}")
	public ResponseEntity<Produto> listProduto(long id) {
		final Produto produto = service.listProduto(id);
		return ResponseEntity.ok(produto);
	}
	
	@PutMapping()
	public ResponseEntity<Produto> criarEstabelecimento(Produto produto) throws URISyntaxException {
		service.criarProduto(produto);
		return ResponseEntity.created(new URI("/produto/"+produto.getNome())).build();
	}
	
	@DeleteMapping(path = "{id}")
	public ResponseEntity<Long> deletarProduto(long id) {
		service.deletarProduto(id);
		return ResponseEntity.ok().build();
	}

}
