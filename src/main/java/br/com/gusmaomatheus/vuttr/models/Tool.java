package br.com.gusmaomatheus.vuttr.models;

import br.com.gusmaomatheus.vuttr.dtos.ToolDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "tools")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String link;
    private String description;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tool_tags", joinColumns = @JoinColumn(name = "tool_id"))
    @Column(name = "tag")
    private List<String> tags;

    public Tool(ToolDTO data) {
        this.title = data.title();
        this.link = data.link();
        this.description = data.description();
        this.tags = data.tags();
    }
}
