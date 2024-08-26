package jv.triersistemas.primeiro_projeto.atividade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Tarefa {
	
	private Long id;
	private String titulo;
	private String descricao;
	private boolean completa;
	
	
}


