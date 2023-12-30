package br.com.gusmaomatheus.vuttr.models;

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

    public Tool(String title, String link, String description, List<String> tags) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.tags = tags;
    }
}
