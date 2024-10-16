package br.ETS.Feedback.instrutor.DTO;

public record DadosCadastroInstrutor(String nome,
                                     String email,
                                     String edv,
                                     String curso,
                                     DadosInformacoes informacoes) {
}
