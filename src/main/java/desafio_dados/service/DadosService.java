package desafio_dados.service;

import java.util.List;

import desafio_dados.dto.DadosDto;

public interface DadosService {

	DadosDto validaDados(DadosDto Dados );
	
	List<DadosDto> numeroSorteado(Integer qtddDados);
	
	DadosDto somaDados(List<DadosDto> numeroSorteado );
	
	DadosDto valorPercentual(DadosDto somaDados, Integer valorAposta);
}
