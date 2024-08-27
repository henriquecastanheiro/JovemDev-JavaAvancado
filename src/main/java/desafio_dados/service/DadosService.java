package desafio_dados.service;

import org.springframework.http.ResponseEntity;

public interface DadosService {

	ResponseEntity<String> verificarDados(Integer qtddDados, Integer valorAposta);
}
