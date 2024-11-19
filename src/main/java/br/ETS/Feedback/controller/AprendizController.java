package br.ETS.Feedback.controller;

import br.ETS.Feedback.model.aprendiz.Aprendiz;
import br.ETS.Feedback.model.aprendiz.AprendizRepository;
import br.ETS.Feedback.model.aprendiz.DTO.DadosAtualizacaoAprendiz;
import br.ETS.Feedback.model.aprendiz.DTO.DadosCadastroAprendiz;
import br.ETS.Feedback.model.aprendiz.DTO.DadosInformacoesCompletasAprendiz;
import br.ETS.Feedback.model.aprendiz.DTO.DadosListagemAprendiz;
import br.ETS.Feedback.model.instrutor.Instrutor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("aprendiz")
public class AprendizController {

    @Autowired
    private AprendizRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemAprendiz> cadastrar(@RequestBody @Valid DadosCadastroAprendiz dadosCadastroAprendiz, UriComponentsBuilder uriComponentsBuilder){
        var aprendiz = new Aprendiz(dadosCadastroAprendiz);
        repository.save(aprendiz);
        var uri = uriComponentsBuilder.path("/aprendiz/{id}").buildAndExpand(aprendiz.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemAprendiz(aprendiz));
    }


    @GetMapping
    public ResponseEntity<Page<DadosListagemAprendiz>> listar(@PageableDefault(size = 10, sort={"nome"})Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemAprendiz::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<DadosListagemAprendiz> atualizar(@RequestBody @Valid DadosAtualizacaoAprendiz dadosAtualizacaoAprendiz){
        var aprendiz = repository.getReferenceById(dadosAtualizacaoAprendiz.id());
        aprendiz.atualizar(dadosAtualizacaoAprendiz);

        return ResponseEntity.ok(new DadosListagemAprendiz(aprendiz));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Instrutor> excluir(@PathVariable int id){
        var aprendiz = repository.getReferenceById(id);
        aprendiz.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosInformacoesCompletasAprendiz> detalharAprendiz(@PathVariable int id){
        var aprendiz = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosInformacoesCompletasAprendiz(aprendiz));
    }

}
