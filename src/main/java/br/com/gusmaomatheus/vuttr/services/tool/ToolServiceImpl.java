package br.com.gusmaomatheus.vuttr.services.tool;

import br.com.gusmaomatheus.vuttr.dtos.ToolDTO;
import br.com.gusmaomatheus.vuttr.exceptions.customs.tool.TitleAlreadyExistsException;
import br.com.gusmaomatheus.vuttr.exceptions.customs.tool.ToolNotFoundException;
import br.com.gusmaomatheus.vuttr.models.Tool;
import br.com.gusmaomatheus.vuttr.repositories.ToolRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.FeatureDescriptor;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ToolServiceImpl implements ToolService {
    @Autowired
    private ToolRepository repository;

    @Override
    public Tool insert(ToolDTO data) {
        Tool entity = new Tool(data);

        if (repository.existsByTitle(data.title())) {
            throw new TitleAlreadyExistsException(String.format("A record with title '%s' already exists.", data.title()));
        }

        return repository.save(entity);
    }

    @Override
    public List<Tool> getAll() {
        return repository.findAll();
    }

    @Override
    public Tool getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ToolNotFoundException(String.format("No records found for id '%d'", id)));
    }

    @Override
    public List<Tool> getByTag(String tag) {
        List<Tool> tools = repository.findByTag(tag);

        if (tools.isEmpty()) {
            throw new ToolNotFoundException(String.format("No records found for tag '%s'", tag));
        } else {
            return tools;
        }

    }

    @Override
    @Transactional
    public Tool update(Long id, ToolDTO data) {
        final BeanWrapper beanWrapper = new BeanWrapperImpl(data);

        String[] dataPropertiesNull = Stream.of(beanWrapper.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(name -> beanWrapper.getPropertyValue(name) == null)
                .toArray(String[]::new);

        Tool entity = repository.findById(id).orElseThrow(() -> new ToolNotFoundException(String.format("No records found for id '%d'", id)));

        if (data.title() != null && !data.title().equals(entity.getTitle()) && repository.existsByTitle(data.title())) {
            throw new TitleAlreadyExistsException(String.format("A record with title '%s' already exists.", data.title()));
        }

        BeanUtils.copyProperties(data, entity, dataPropertiesNull);

        return repository.save(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Tool entity = repository.findById(id).orElseThrow(() -> new ToolNotFoundException(String.format("No records found for id '%d'", id)));

        repository.delete(entity);
    }
}
