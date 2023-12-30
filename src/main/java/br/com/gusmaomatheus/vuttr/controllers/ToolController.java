package br.com.gusmaomatheus.vuttr.controllers;

import br.com.gusmaomatheus.vuttr.dtos.ToolDTO;
import br.com.gusmaomatheus.vuttr.models.Tool;
import br.com.gusmaomatheus.vuttr.services.tool.ToolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
