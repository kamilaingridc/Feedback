package br.ETS.Feedback.model.aprendiz.DTO;

import br.ETS.Feedback.model.Curso;
import br.ETS.Feedback.model.aprendiz.informacoes.DadosInformacoes;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAprendiz(@NotNull int id,
                                        String nome,
                                        String email,
                                        String edv,
                                        Curso curso,
                                        boolean ferias,
                                        DadosInformacoes informacoes
) {



}
