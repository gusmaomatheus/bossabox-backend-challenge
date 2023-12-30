package br.com.gusmaomatheus.vuttr.dtos;

import java.util.List;

public record ToolDTO(
        String title,
        String link,
        String description,
        List<String> tags
) {
}
