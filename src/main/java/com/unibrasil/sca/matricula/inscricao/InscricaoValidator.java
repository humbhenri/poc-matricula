package com.unibrasil.sca.matricula.inscricao;

import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.unibrasil.sca.matricula.disciplina.Disciplina;


public class InscricaoValidator implements Validator {
	
	private static Logger logger = Logger.getLogger(InscricaoValidator.class.getName());

	@Override
	public boolean supports(Class<?> clazz) {
		return Inscricao.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Inscricao inscricao = (Inscricao) target;
		Integer somaCreditos = inscricao.getTurmas().stream().map(t -> t.getDisciplina().getCreditos()).reduce(0, Integer::sum);
		logger.info("Soma de créditos: " + somaCreditos);
		if (somaCreditos > Inscricao.MAX_CREDITOS) {
			errors.rejectValue("turmas", null, "O número máximo de créditos por semestre é " + Inscricao.MAX_CREDITOS);
		}
		validaDisciplinasFeitas(inscricao, errors);
	}

	private void validaDisciplinasFeitas(Inscricao inscricao, Errors errors) {
		inscricao.getTurmas().forEach(turma -> {
			if (!inscricao.getAluno().getDisciplinasFeitas().containsAll(turma.getDisciplina().getRequisitos())) {
				errors.reject(null, "A disciplina " + turma.getDisciplina().getNome() + 
						" não pode ser feita agora porque ela tem requisitos ainda não satisfeitos: " +
						turma.getDisciplina().getRequisitos().stream().map(Disciplina::getNome).collect(Collectors.joining(", ")));
			}
		});
	}

}
