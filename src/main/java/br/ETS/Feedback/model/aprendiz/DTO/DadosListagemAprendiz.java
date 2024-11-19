package br.ETS.Feedback.model.aprendiz.DTO;

import br.ETS.Feedback.model.Curso;
import br.ETS.Feedback.model.aprendiz.Aprendiz;
import br.ETS.Feedback.model.aprendiz.informacoes.Informacoes;

public record DadosListagemAprendiz(String nome,
                                     String email,
                                     String edv,
                                     Boolean ferias,
                                     Curso curso,
                                     Informacoes informacoes) {

    public DadosListagemAprendiz(Aprendiz aprendiz) {
        this(aprendiz.getNome(),
                aprendiz.getEmail(),
                aprendiz.getEdv(),
                aprendiz.isFerias(),
                aprendiz.getCurso(),
                aprendiz.getInformacoes());
    }
}
