package br.com.gusmaomatheus.vuttr.controllers;

import br.com.gusmaomatheus.vuttr.dtos.ToolDTO;
import br.com.gusmaomatheus.vuttr.models.Tool;
import br.com.gusmaomatheus.vuttr.services.tool.ToolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuttr/tools")
public class ToolController {
    @Autowired
    private ToolServiceImpl service;

    @PostMapping
    public ResponseEntity<Tool> insert(@RequestBody ToolDTO data) {
        Tool entity = service.insert(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @GetMapping
    public ResponseEntity<List<Tool>> getAll() {
        List<Tool> allTools = service.getAll();

        return ResponseEntity.status(HttpStatus.OK).body(allTools);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tool> getById(@PathVariable Long id) {
        Tool entity = service.getById(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(entity);
    }
}
