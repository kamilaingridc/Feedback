package br.ETS.Feedback.model.instrutor.DTO;
import br.ETS.Feedback.model.Curso;
import br.ETS.Feedback.model.instrutor.Instrutor;
import br.ETS.Feedback.model.instrutor.informacoes.Informacoes;


public record DadosInformacoesCompletas(
        int id,
        String nome,
        String email,
        String edv,
        Curso curso,
        boolean ferias,
        boolean ativo,
        Informacoes informacoes){

    public DadosInformacoesCompletas(Instrutor instrutor){
        this(instrutor.getId(),
                instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getEdv(),
                instrutor.getCurso(),
                instrutor.getFerias(),
                instrutor.isAtivo(),
                instrutor.getInformacoes());
    }
}


