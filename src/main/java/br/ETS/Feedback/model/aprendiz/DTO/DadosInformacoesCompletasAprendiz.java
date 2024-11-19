package br.ETS.Feedback.model.aprendiz.DTO;

import br.ETS.Feedback.model.Curso;
import br.ETS.Feedback.model.aprendiz.Aprendiz;
import br.ETS.Feedback.model.aprendiz.informacoes.Informacoes;

public record DadosInformacoesCompletasAprendiz(

        int id,
        String nome,
        String email,
        String edv,
        Curso curso,
        boolean ferias,
        boolean ativo,
       Informacoes informacoes){

    public DadosInformacoesCompletasAprendiz(Aprendiz aprendiz) {
        this(aprendiz.getId(),
                aprendiz.getNome(),
                aprendiz.getEmail(),
                aprendiz.getEdv(),
                aprendiz.getCurso(),
                aprendiz.isFerias(),
                aprendiz.isAtivo(),
                aprendiz.getInformacoes());
    }
}
