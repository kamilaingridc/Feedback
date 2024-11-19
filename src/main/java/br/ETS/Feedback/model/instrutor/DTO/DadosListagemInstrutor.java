package br.ETS.Feedback.model.instrutor.DTO;

import br.ETS.Feedback.model.Curso;
import br.ETS.Feedback.model.instrutor.Instrutor;

public record DadosListagemInstrutor(String nome,
                                     String email,
                                     String edv,
                                     Boolean ferias,
                                     Curso curso) {

    public DadosListagemInstrutor(Instrutor instrutor){
        this(instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getEdv(),
                instrutor.getFerias(),
                instrutor.getCurso());
    }
}
