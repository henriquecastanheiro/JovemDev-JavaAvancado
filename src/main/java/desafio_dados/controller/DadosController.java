package desafio_dados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import desafio_dados.service.DadosService;

@RestController
@RequestMapping("/aposta")
public class DadosController {

    @Autowired
    private DadosService dadosService;

    @PostMapping("/jogarDados")
    public ResponseEntity<String> verificarDados(
            @RequestParam Integer qtddDados,
            @RequestParam Integer aposta) {
        return dadosService.verificarDados(qtddDados, aposta);
    }
}
