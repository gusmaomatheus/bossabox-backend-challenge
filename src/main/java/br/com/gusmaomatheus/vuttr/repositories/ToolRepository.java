package br.com.gusmaomatheus.vuttr.repositories;

import br.com.gusmaomatheus.vuttr.models.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {

    @Query(value = "SELECT tool FROM Tool tool WHERE :tag MEMBER OF tool.tags")
    List<Tool> findByTag(@RequestParam String tag);
}
