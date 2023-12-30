package br.com.gusmaomatheus.vuttr.controllers;

import br.com.gusmaomatheus.vuttr.services.tool.ToolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vuttr/tools")
public class ToolController {
    @Autowired
    private ToolServiceImpl service;

}
