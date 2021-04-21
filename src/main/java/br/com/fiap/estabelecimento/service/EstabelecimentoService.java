package br.com.fiap.estabelecimento.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.fiap.estabelecimento.domain.Estabelecimento;
import br.com.fiap.estabelecimento.repository.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {

	@Autowired
	private EstabelecimentoRepository repository;

	public Page<Estabelecimento> list() {
		return repository.findAll(PageRequest.of(0, 3));
	}

	public Estabelecimento listEstabelecimento(Integer id) {
		Optional<Estabelecimento> opEstabeleciomento = repository.findById(id);
		return opEstabeleciomento.get();
	}

	public void criarEstabelecimento(Estabelecimento estabelecimento) {
		repository.save(estabelecimento);
	}

	public void deletarEstabelecimento(Integer id) {
		repository.deleteById(id);
	}
}