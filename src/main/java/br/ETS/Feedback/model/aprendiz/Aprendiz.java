package br.ETS.Feedback.model.aprendiz;

import br.ETS.Feedback.model.Curso;
import br.ETS.Feedback.model.aprendiz.DTO.DadosAtualizacaoAprendiz;
import br.ETS.Feedback.model.aprendiz.DTO.DadosCadastroAprendiz;
import br.ETS.Feedback.model.aprendiz.informacoes.Informacoes;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity(name = "Aprendiz")
@Table(name = "tbaprendizes")
public class Aprendiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String edv;
    private boolean ferias;

    @Enumerated(EnumType.STRING)
    private Curso curso;

    @Embedded
    private Informacoes informacoes;

    private boolean ativo;


    public Aprendiz(DadosCadastroAprendiz dadosCadastroAprendiz) {
        this.nome = dadosCadastroAprendiz.nome();
        this.email = dadosCadastroAprendiz.email();
        this.edv = dadosCadastroAprendiz.edv();
        this.curso = dadosCadastroAprendiz.curso();
        this.informacoes = new Informacoes(dadosCadastroAprendiz.informacoes());
        this.ferias = dadosCadastroAprendiz.ferias();
        this.ativo = true;

    }

    public void atualizar(DadosAtualizacaoAprendiz dadosAtualizacaoAprendiz) {
        if (dadosAtualizacaoAprendiz.nome() != null) {
            this.nome = dadosAtualizacaoAprendiz.nome();
        }
        if (dadosAtualizacaoAprendiz.email() != null) {
            this.email = dadosAtualizacaoAprendiz.email();
        }
        if (dadosAtualizacaoAprendiz.edv() != null) {
            this.edv = dadosAtualizacaoAprendiz.edv();
        }
        if (dadosAtualizacaoAprendiz.curso() != null) {
            this.curso = dadosAtualizacaoAprendiz.curso();
        }

        this.ferias = dadosAtualizacaoAprendiz.ferias();

        if (dadosAtualizacaoAprendiz.informacoes() != null) {
            this.informacoes.atualizar(dadosAtualizacaoAprendiz.informacoes());
        }
    }

    public void excluir(){
        this.ativo = false;
    }

}
