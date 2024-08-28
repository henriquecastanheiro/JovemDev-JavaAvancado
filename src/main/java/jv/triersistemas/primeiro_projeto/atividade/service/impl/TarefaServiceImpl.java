package jv.triersistemas.primeiro_projeto.atividade.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.primeiro_projeto.atividade.service.TarefaService;
import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.entity.TarefaEntity;
import jv.triersistemas.primeiro_projeto.repository.TarefaRepository;


@Service
public class TarefaServiceImpl implements TarefaService {
    
    @Autowired
    private TarefaRepository repository;
    
	@Override
	public List<TarefaDto> getTodasTarefas() {
		List<TarefaEntity> tarefas = repository.findAll();
        List<TarefaDto> tarefaDtos = new ArrayList<>();
        for (TarefaEntity tarefa : tarefas) {
            tarefaDtos.add(new TarefaDto(tarefa));
        }
        return tarefaDtos;
	}
	
	@Override
	public Optional<TarefaDto> findById(Long id) {
    	Optional<TarefaEntity> tarefaEntity =  repository.findById(id);
    	return tarefaEntity.map(TarefaDto::new);
    }

	@Override
	public TarefaDto adicionarTarefa(TarefaDto novaTarefaDto) {
		var tarefaEntity = new TarefaEntity(novaTarefaDto);
        TarefaEntity entidadePersistida = repository.save(tarefaEntity);
        return new TarefaDto(entidadePersistida);
	}

	@Override
	public TarefaDto atualizarTarefa(Long id, TarefaDto tarefaAtualizada) {
		Optional<TarefaEntity> tarefaEntityOption= repository.findById(id);
        if (tarefaEntityOption.isPresent()) {
        	TarefaEntity tarefaEntity = tarefaEntityOption.get();
            tarefaEntity.setTitulo(tarefaAtualizada.getTitulo());
            tarefaEntity.setDescricao(tarefaAtualizada.getDescricao());
            tarefaEntity.setCompleta(tarefaAtualizada.getCompleta());
            TarefaEntity tarefaAtualizadaEntity = repository.save(tarefaEntity);
            return new TarefaDto(tarefaAtualizadaEntity);
        }
        return null;
	}

	@Override
	public void removerTarefa(Long id) {
		repository.deleteById(id);
	}
}
	
	
