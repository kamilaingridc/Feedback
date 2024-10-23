package br.ETS.Feedback.informacoes;

import br.ETS.Feedback.instrutor.DTO.DadosInformacoes;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter // Faz método GET para todos os atributos
@Setter // Faz método SET para todos os atributos
@AllArgsConstructor // Faz o construtor com todos os atributos
@NoArgsConstructor // Faz o construtor padrão, sem atributos
@EqualsAndHashCode // Faz o método EQUALS e método HASHCODE
@Embeddable
public class Informacoes {
    private String disciplina;
    private String trilha;
    private String faculdade;
    private String turma;

    public Informacoes(DadosInformacoes dadosInformacoes){
        this.disciplina = dadosInformacoes.disciplina();
        this.trilha = dadosInformacoes.trilha();
        this.faculdade = dadosInformacoes.faculdade();
        this.turma = dadosInformacoes.turma();
    }
}
