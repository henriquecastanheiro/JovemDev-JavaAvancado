package desafio_dados.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface DadosService {

	ResponseEntity<String> verificarDados(@RequestBody Integer qtddDados, @RequestBody Integer valorAposta);
}
