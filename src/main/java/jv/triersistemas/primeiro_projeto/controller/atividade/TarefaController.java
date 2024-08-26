package jv.triersistemas.primeiro_projeto.controller.atividade;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.primeiro_projeto.atividade.Tarefa;

@RestController
@RequestMapping("/primeira-atividade")
public class TarefaController {
	
	public static List<Tarefa> tarefas = new ArrayList<Tarefa>();
	public static Long contador;
	
	@GetMapping("/tarefas")
	public List<Tarefa> getAll(){
		return tarefas;
	}
	
	@PostMapping()
	public void cadastraTarefa(@RequestBody Tarefa tarefa) {
		tarefas.add(tarefa);
	}
	
	@GetMapping("/tarefas/{contador}")
	public static ResponseEntity<Stream<Tarefa>> finbById(@PathVariable Long contador){
		return ResponseEntity.ok().body(tarefas.stream().filter(s -> s.getId()==contador));
	}
}
	
	


