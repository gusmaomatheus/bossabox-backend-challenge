package br.com.gusmaomatheus.vuttr.repositories;

import br.com.gusmaomatheus.vuttr.models.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {
}
