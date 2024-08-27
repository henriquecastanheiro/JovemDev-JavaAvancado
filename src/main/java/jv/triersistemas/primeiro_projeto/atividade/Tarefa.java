package jv.triersistemas.primeiro_projeto.atividade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Tarefa {
	
	private Long id;
	private String titulo;
	private String descricao;
	private boolean completa;
	
	
}


