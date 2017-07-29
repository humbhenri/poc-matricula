package com.unibrasil.sca.matricula;

import java.util.logging.Logger;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class InscricaoValidator implements Validator {
	
	private static Logger logger = Logger.getLogger(InscricaoValidator.class.getName());

	@Override
	public boolean supports(Class<?> clazz) {
		return Inscricao.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Inscricao inscricao = (Inscricao) target;
		Integer somaCreditos = inscricao.getDisciplinas().stream().map(Disciplina::getCreditos).reduce(0, Integer::sum);
		logger.info("Soma de créditos: " + somaCreditos);
		if (somaCreditos > Inscricao.MAX_CREDITOS) {
			errors.rejectValue("disciplinas", null, "O número máximo de créditos por semestre é " + Inscricao.MAX_CREDITOS);
		}
	}

}
