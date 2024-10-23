package br.ETS.Feedback.instrutor.DTO;

import br.ETS.Feedback.instrutor.Curso;

public record DadosCadastroInstrutor(String nome,
                                     String email,
                                     String edv,
                                     Curso curso,
                                     DadosInformacoes informacoes) {
}
