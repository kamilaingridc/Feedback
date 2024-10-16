package br.ETS.Feedback.controller;

import br.ETS.Feedback.instrutor.DTO.DadosCadastroInstrutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("instrutor")
public class InstrutorController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroInstrutor dadosCadastroInstrutor){
        System.out.println(dadosCadastroInstrutor);
    }

}
