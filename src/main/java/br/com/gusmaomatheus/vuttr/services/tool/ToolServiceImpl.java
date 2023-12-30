package br.com.gusmaomatheus.vuttr.services.tool;

import br.com.gusmaomatheus.vuttr.repositories.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolServiceImpl implements ToolService {
    @Autowired
    private ToolRepository repository;

}
