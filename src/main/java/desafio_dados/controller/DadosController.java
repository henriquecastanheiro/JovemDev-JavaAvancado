package desafio_dados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import desafio_dados.service.DadosService;

@RestController
@RequestMapping("/verificaDados")
public class DadosController {

    @Autowired
    private DadosService dadosService;

    @GetMapping("/verificar")
    public ResponseEntity<String> verificarDados(
            @RequestParam Integer qtdDados,
            @RequestParam Integer aposta) {
        return dadosService.verificarDados(qtdDados, aposta);
    }
}
