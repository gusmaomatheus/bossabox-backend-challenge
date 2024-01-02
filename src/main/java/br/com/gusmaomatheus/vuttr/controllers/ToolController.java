package br.com.gusmaomatheus.vuttr.controllers;

import br.com.gusmaomatheus.vuttr.dtos.ToolDTO;
import br.com.gusmaomatheus.vuttr.models.Tool;
import br.com.gusmaomatheus.vuttr.services.tool.ToolServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuttr/tools")
@Tag(name = "Tools")
public class ToolController {
    @Autowired
    private ToolServiceImpl service;

    @Operation(
            summary = "Endpoint to insert a new tool into the system.",
            description = "An endpoint that makes an HTTP POST request to insert a new tool into the system.",
            parameters = {
                    @Parameter(
                            name = "title",
                            description = "A brief title or name of the inserted tool.",
                            required = true,
                            example = "Notion"
                    ),
                    @Parameter(
                            name = "link",
                            description = "A link related to that tool.",
                            required = true,
                            example = "https://notion.so"
                    ),
                    @Parameter(
                            name = "description",
                            description = "A short description about the tool, whether about its usefulness or features.",
                            required = true,
                            example = "All in one tool to organize teams and ideas. Write, plan, collaborate, and get organized."
                    ),
                    @Parameter(
                            name = "tags",
                            description = "Tags related to that tool.",
                            required = true,
                            example = "[organization, planning, collaboration, writing, calendar]"
                    )
            },
            responses = {
                    @ApiResponse(
                            description = "Success in registering a new tool.",
                            responseCode = "201"
                    ),
                    @ApiResponse(
                            description = "Error creating registering tool.",
                            responseCode = "400"
                    )
            }
    )
    @PostMapping("/insert")
    public ResponseEntity<Tool> insert(@RequestBody @Valid ToolDTO data) {
        Tool entity = service.insert(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @Operation(
            summary = "Endpoint to get all tools in the system.",
            description = "An endpoint that makes a HTTP GET request to get all tools already inserted in the system.",
            responses = {
                    @ApiResponse(
                            description = "Success in obtaining the tools.",
                            responseCode = "200"
                    )
            }
    )
    @GetMapping("/get/all")
    public ResponseEntity<List<Tool>> getAll() {
        List<Tool> allTools = service.getAll();

        return ResponseEntity.status(HttpStatus.OK).body(allTools);
    }

    @Operation(
            summary = "Endpoint to obtain in system a specific tool using its id.",
            description = "An endpoint that makes a HTTP GET request to get a specific tool in system using your id.",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "An integer referring to the id of a tool.",
                            required = true,
                            example = "1",
                            in = ParameterIn.PATH
                    )
            },
            responses = {
                    @ApiResponse(
                            description = "Success in finding the tool.",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Tool not found.",
                            responseCode = "404"
                    )
            }
    )
    @GetMapping("/get/{id}")
    public ResponseEntity<Tool> getById(@PathVariable Long id) {
        Tool entity = service.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @Operation(
            summary = "Endpoint to get tools with a common tag",
            description = "An endpoint that makes a HTTP GET request to get a tools in system using a common tag.",
            parameters = {
                    @Parameter(
                            name = "tag",
                            description = "A string referring to a common tag.",
                            required = true,
                            example = "organization",
                            in = ParameterIn.PATH
                    )
            },
            responses = {
                    @ApiResponse(
                            description = "Success in finding the tool(s).",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Tool not found.",
                            responseCode = "404"
                    )
            }
    )
    @GetMapping("/get")
    public ResponseEntity<List<Tool>> getByTag(@RequestParam("tag") String tag) {
        List<Tool> allTools = service.getByTag(tag);

        return ResponseEntity.status(HttpStatus.OK).body(allTools);
    }

    @Operation(
            summary = "Endpoint to update a tool's information.",
            description = "An endpoint that makes an HTTP PUT request to update information from a tool already registered in the system through its id.",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "An integer referring to the id of a tool.",
                            required = true,
                            example = "1",
                            in = ParameterIn.PATH
                    )
            },
            responses = {
                    @ApiResponse(
                            description = "Success in updating the tool",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Tool not found.",
                            responseCode = "404"
                    )
            }
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<Tool> update(@PathVariable Long id, @RequestBody ToolDTO data) {
        Tool entity = service.update(id, data);

        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @Operation(
            summary = "Endpoint to delete a tool.",
            description = "An endpoint that makes an HTTP DELETE request to remove information from a tool registered in the system using its id.",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "An integer referring to the id of a tool.",
                            required = true,
                            example = "1",
                            in = ParameterIn.PATH
                    )
            },
            responses = {
                    @ApiResponse(
                            description = "Success in deleting the tool",
                            responseCode = "204"
                    ),
                    @ApiResponse(
                            description = "Tool not found.",
                            responseCode = "404"
                    )
            }
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}