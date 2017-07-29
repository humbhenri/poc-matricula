package com.unibrasil.sca.matricula;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/inscricao")
public class InscricaoController {

	@Autowired
	private InscricaoRepository repo;

	private final Logger logger = LoggerFactory.getLogger(InscricaoController.class);

	@RequestMapping(path="/{username}", method = RequestMethod.GET)
	Inscricao get(@PathVariable String username) {
		return repo.findFirstByAluno_Username(username);
	}

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody Inscricao inscricao) {
		try {
			Inscricao result = repo.save(inscricao);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(path = "/{inscricaoId}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateExist(@RequestBody Inscricao inscricao, @PathVariable int inscricaoId) {
		try {
			inscricao.setId(inscricaoId);
			repo.save(inscricao);
			return ResponseEntity.noContent().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@RequestMapping(path = "/{inscricaoId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable int inscricaoId) {
		try {
			repo.delete(inscricaoId);
			return ResponseEntity.noContent().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
