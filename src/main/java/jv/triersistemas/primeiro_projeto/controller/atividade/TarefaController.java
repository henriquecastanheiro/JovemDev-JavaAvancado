package jv.triersistemas.primeiro_projeto.controller.atividade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.primeiro_projeto.atividade.Tarefa;

@RestController
@RequestMapping("/primeira-atividade")
public class TarefaController {
	
	public static List<Tarefa> tarefas = new ArrayList<Tarefa>();
	public static Long contador = 0L;
	
	@GetMapping("/tarefas")
	public List<Tarefa> getAll(){
		return tarefas;
	}
	
	@PostMapping()
	public void cadastraTarefa(@RequestBody Tarefa tarefa) {
		contador++;
		tarefa.setId(contador);
		tarefas.add(tarefa);
	}
	
	@PostMapping("/tarefas/lote")
	public void cadastraTarefasEmLote(@RequestBody List<Tarefa> novasTarefas) {
	    novasTarefas.forEach(tarefa -> {
	        contador++;
	        tarefa.setId(contador);
	        tarefas.add(tarefa);});
	}

	
	@GetMapping("/tarefas/{id}")
	public Tarefa finbById(@PathVariable Long id){
		return tarefas.stream()
				.filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
	}
	
	@PutMapping("/tarefas/{id}")
	public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada){
		Tarefa tarefaEscolhida = tarefas.stream().
				filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
		
		tarefaEscolhida.setTitulo(tarefaAtualizada.getTitulo());
        tarefaEscolhida.setDescricao(tarefaAtualizada.getDescricao());
        tarefaEscolhida.setCompleta(tarefaAtualizada.isCompleta());

        return tarefaEscolhida;
    }
	
	@DeleteMapping("/tarefas/{id}")
    public void removerTarefa(@PathVariable Long id) {
        Tarefa tarefaEscolhida = tarefas.stream()
        		.filter(tarefa -> tarefa.getId().equals(id))
        		.findFirst()
        		.orElse(null);
       
        tarefas.remove(tarefaEscolhida);
    }
}
	
	
	


