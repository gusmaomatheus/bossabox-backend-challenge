package br.com.gusmaomatheus.vuttr.controllers;

import br.com.gusmaomatheus.vuttr.dtos.ToolDTO;
import br.com.gusmaomatheus.vuttr.models.Tool;
import br.com.gusmaomatheus.vuttr.services.tool.ToolServiceImpl;
import jakarta.validation.Valid;
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

    @PostMapping("/insert")
    public ResponseEntity<Tool> insert(@RequestBody @Valid ToolDTO data) {
        Tool entity = service.insert(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Tool>> getAll() {
        List<Tool> allTools = service.getAll();

        return ResponseEntity.status(HttpStatus.OK).body(allTools);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Tool> getById(@PathVariable Long id) {
        Tool entity = service.getById(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(entity);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Tool>> getByTag(@RequestParam("tag") String tag) {
        List<Tool> allTools = service.getByTag(tag);

        return ResponseEntity.status(HttpStatus.FOUND).body(allTools);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Tool> update(@PathVariable Long id, @RequestBody @Valid ToolDTO data) {
        Tool entity = service.update(id, data);

        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
