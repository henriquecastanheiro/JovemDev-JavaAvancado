package desafio_dados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio_dados.dto.DadosDto;
import desafio_dados.service.DadosService;

@RestController
@RequestMapping("/desafio")
public class DadosController {

    @Autowired
    private DadosService dadosService;

    @PostMapping
    public ResponseEntity<String> verificarDados(@RequestBody DadosDto dadosDto) {
        return dadosService.verificarDados(dadosDto.getQtddDados(), dadosDto.getValorAposta());
    }
}
