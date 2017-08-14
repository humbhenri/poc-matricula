package com.unibrasil.sca.matricula.inscricao;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.unibrasil.sca.matricula.disciplina.Disciplina;
import com.unibrasil.sca.matricula.turma.Horario;
import com.unibrasil.sca.matricula.turma.Turma;

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
        validaRequisitosDisciplinas(inscricao, errors);
        validaHorarios(inscricao, errors);
    }

    private void validaRequisitosDisciplinas(Inscricao inscricao, Errors errors) {
        inscricao.getTurmas().forEach(turma -> {
            if (!inscricao.getAluno().getDisciplinasFeitas().containsAll(turma.getDisciplina().getRequisitos())) {
                errors.reject(null, "A disciplina " + turma.getDisciplina().getNome()
                        + " não pode ser feita agora porque ela tem requisitos ainda não satisfeitos: "
                        + turma.getDisciplina().getRequisitos().stream().map(Disciplina::getNome).collect(Collectors.joining(", ")));
            }
        });
    }

    private void validaHorarios(Inscricao inscricao, Errors errors) {
        for (Turma t1 : inscricao.getTurmas()) {
            for (Turma t2 : inscricao.getTurmas()) {
                if (t1.getId() < t2.getId()
                        && // evita mensagem de erro quando t1 e t2 trocarem de lugar no loop
                        temHorariosConflitantes(t1, t2)) {
                    errors.reject(null, String.format("Os horários das disciplinas %s e %s conflitam", t1.getDisciplina().getNome(), t2.getDisciplina().getNome()));
                }
            }
        }
    }

    private boolean temHorariosConflitantes(Turma t1, Turma t2) {
        Set<Horario> comum = new HashSet<>(t1.getHorarios());
        comum.retainAll(t2.getHorarios());
        return !comum.isEmpty();
    }

}
