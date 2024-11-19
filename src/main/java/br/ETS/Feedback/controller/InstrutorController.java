package br.ETS.Feedback.controller;

import br.ETS.Feedback.model.instrutor.DTO.DadosInformacoesCompletas;
import br.ETS.Feedback.model.instrutor.DTO.DadosAtualizacaoInstrutor;
import br.ETS.Feedback.model.instrutor.DTO.DadosCadastroInstrutor;
import br.ETS.Feedback.model.instrutor.DTO.DadosListagemInstrutor;
import br.ETS.Feedback.model.instrutor.Instrutor;
import br.ETS.Feedback.model.instrutor.InstrutorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorRepository repository;

    @PostMapping
    public ResponseEntity<DadosListagemInstrutor> cadastrar(@RequestBody @Valid DadosCadastroInstrutor dadosCadastroInstrutor, UriComponentsBuilder uriComponentsBuilder ){
       var instrutor = new Instrutor(dadosCadastroInstrutor);
       repository.save(instrutor);
       var uri = uriComponentsBuilder.path("/instrutor/{id}").buildAndExpand( instrutor.getId() ).toUri();
       return ResponseEntity.created(uri).body(new DadosListagemInstrutor(instrutor));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemInstrutor>> listar(@PageableDefault( size = 5, sort = {"edv"}) Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemInstrutor::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<DadosListagemInstrutor> atualizar(@RequestBody @Valid DadosAtualizacaoInstrutor dadosAtualizacaoInstrutor){
        var instrutor = repository.getReferenceById(dadosAtualizacaoInstrutor.id());
        instrutor.atualizar(dadosAtualizacaoInstrutor);
        return ResponseEntity.ok(new DadosListagemInstrutor(instrutor));

    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Instrutor> excluir(@PathVariable int id){
        var instrutor = repository.getReferenceById(id);
        instrutor.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosInformacoesCompletas> detalharInstrutor(@PathVariable int id){
        var instrutor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosInformacoesCompletas(instrutor));
    }
}
