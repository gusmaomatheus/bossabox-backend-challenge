package br.com.gusmaomatheus.vuttr.services.tool;

import br.com.gusmaomatheus.vuttr.dtos.ToolDTO;
import br.com.gusmaomatheus.vuttr.exceptions.customs.ToolNotFoundException;
import br.com.gusmaomatheus.vuttr.models.Tool;
import br.com.gusmaomatheus.vuttr.repositories.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolServiceImpl implements ToolService {
    @Autowired
    private ToolRepository repository;

    @Override
    public Tool insert(ToolDTO data) {
        Tool entity = new Tool(data.title(), data.link(), data.description(), data.tags());
        return repository.save(entity);
    }

    @Override
    public List<Tool> getAll() {
        return repository.findAll();
    }

    @Override
    public Tool getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ToolNotFoundException(String.format("No records found for id '%d'", id)));
    }
}
