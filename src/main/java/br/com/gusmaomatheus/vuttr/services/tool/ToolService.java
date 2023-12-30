package br.com.gusmaomatheus.vuttr.services.tool;

import br.com.gusmaomatheus.vuttr.dtos.ToolDTO;
import br.com.gusmaomatheus.vuttr.models.Tool;

import java.util.List;

public interface ToolService {

    Tool insert(ToolDTO data);

    List<Tool> getAll();

    Tool getById(Long id);

    List<Tool> getByTag(String tag);

    Tool update(Long id, ToolDTO data);

    void delete(Long id);
}
