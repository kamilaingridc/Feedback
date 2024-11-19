package br.ETS.Feedback.model.instrutor.DTO;

import br.ETS.Feedback.model.Curso;
import br.ETS.Feedback.model.instrutor.informacoes.DadosInformacoes;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoInstrutor(@NotNull int id,
                                        String nome,
                                        String email,
                                        String edv,
                                        Curso curso,
                                        Boolean ferias,
                                        DadosInformacoes informacoes) {
}
