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

import br.com.fiap.estabelecimento.domain.Estabelecimento;
import br.com.fiap.estabelecimento.service.EstabelecimentoService;

@RestController
@RequestMapping("/estabelecimentos")
public class EstabeleciomentoController {
	
	@Autowired
	private EstabelecimentoService service;

	@GetMapping()
	public ResponseEntity<Page<Estabelecimento>> list() {
		final Page<Estabelecimento> estabelecimento = service.list().map(Estabelecimento::new);
		return ResponseEntity.ok(estabelecimento);
	}
	
	@GetMapping(path = "{id}")
	public ResponseEntity<Estabelecimento> listEstabelecimento(long id) {
		final Estabelecimento estabelecimento = service.listEstabelecimento(id);
		return ResponseEntity.ok(estabelecimento);
	}
	
	@PutMapping()
	public ResponseEntity<Estabelecimento> criarEstabelecimento(Estabelecimento estabelecimento) throws URISyntaxException {
		service.criarEstabelecimento(estabelecimento);
		return ResponseEntity.created(new URI("/estabelecimento/"+estabelecimento.getNome())).build();
	}
	
	@DeleteMapping(path = "{id}")
	public ResponseEntity<Long> deletarEstabelecimento(long id) {
		service.deletarEstabelecimento(id);
		return ResponseEntity.ok().build();
	}
}
