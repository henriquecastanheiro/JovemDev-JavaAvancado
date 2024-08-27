package desafio_dados.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import desafio_dados.service.DadosService;

@Service
public class DadosServiceImpl implements DadosService{

	@Override
	public ResponseEntity<String> verificarDados(Integer qtddDados, Integer valorAposta) {
		if( qtddDados < 1 || qtddDados > 4) {
			 return ResponseEntity.badRequest().body("A quantidade de dados deve ser entre 1 e 4.");
		}
		if (valorAposta <= 0) {
            return ResponseEntity.badRequest().body("O valor da aposta deve ser positivo.");
        }
        Map<Integer, Integer> mapaDados = lancarDados(qtddDados);
        int somaDosDados = somarDados(mapaDados);
        double percentual = calcularPercentual(valorAposta, somaDosDados);
        String body = gerarBody(mapaDados, somaDosDados, percentual);
        return ResponseEntity.ok(body);
    }
	
	private Map<Integer, Integer> lancarDados(Integer qtddDados){
		Map<Integer, Integer> mapaDados = new HashMap<>();
		Random numeroAleatorio = new Random();
		for(int i = 1; i <= qtddDados; i++) {
			mapaDados.put(i, numeroAleatorio.nextInt(6)+1);
		}
		return mapaDados;
	}
	
	private int somarDados(Map<Integer, Integer> mapaDados) {
		return mapaDados.values().stream().mapToInt(Integer::intValue).sum();	
	}
	
	private Double calcularPercentual(Integer valorAposta,int somaDosDados) {
		return ((double)(somaDosDados/valorAposta))*100;
	}
	
	private String gerarBody(Map<Integer, Integer> mapaDados, int somaDosDados, double percentual) {
        StringBuilder sb = new StringBuilder();
        sb.append("Resultados dos Dados: \n");
        
        for (Map.Entry<Integer, Integer> entry : mapaDados.entrySet()) {
            sb.append("Dado ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        
        sb.append("Soma dos Resultados: ").append(somaDosDados).append("\n");
        sb.append("Percentual da Aposta: ").append(String.format("%.2f", percentual)).append("%");
        
        return sb.toString();
    }
}
