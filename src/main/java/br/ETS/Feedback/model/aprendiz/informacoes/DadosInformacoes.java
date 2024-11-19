package br.ETS.Feedback.model.aprendiz.informacoes;

import jakarta.validation.constraints.NotBlank;

public record DadosInformacoes(
                               @NotBlank String trilha,
                               @NotBlank String faculdade,
                               @NotBlank String turma) {

}
