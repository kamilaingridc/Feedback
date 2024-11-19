package br.ETS.Feedback.model.instrutor.DTO;


import br.ETS.Feedback.model.Curso;
import br.ETS.Feedback.model.instrutor.informacoes.DadosInformacoes;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;




public record DadosCadastroInstrutor(@NotBlank String nome,
                                     @NotBlank @Email String email,
                                     @NotBlank @Pattern(regexp = "^\\d{8}$") String edv,
                                     @NotNull Curso curso,
                                     @NotNull @Valid DadosInformacoes informacoes,
                                     @NotNull boolean ferias

) {
}



