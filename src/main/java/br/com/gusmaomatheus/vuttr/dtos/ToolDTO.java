package br.com.gusmaomatheus.vuttr.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

public record ToolDTO(
        @NotBlank(message = "The 'title' field is required and therefore cannot be blank.")
        @Size(min = 3, max = 20, message = "The 'title' field must be between 3 and 20 characters.")
        String title,
        @NotBlank(message = "The 'link' field is required and therefore cannot be blank.")
        String link,
        @NotBlank(message = "The 'description' field is required and therefore cannot be blank.")
        @Size(min = 5, max = 300, message = "The 'title' field must be between 5 and 300 characters.")
        String description,
        @NotEmpty(message = "The 'tags' field is required ana therefore cannot be empty.")
        List<String> tags
) {
}
