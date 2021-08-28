package com.example.teste_logistica.model.services;


import com.example.teste_logistica.model.DTO.ConteinerDTO;
import com.example.teste_logistica.model.entity.Conteiner;
import com.example.teste_logistica.model.mapper.ConteinerMapper;
import com.example.teste_logistica.model.repository.ConteinerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ConteinerService implements ServiceInterface<ConteinerDTO> {


    private ConteinerRepository conteinerRepository;


    private final ConteinerMapper conteinerMapper = ConteinerMapper.INSTANCE;


    @Override
    public ConteinerDTO create(ConteinerDTO conteinerDTO) {
        var container = conteinerMapper.toModel(conteinerDTO);
        conteinerRepository.save(container);
        return conteinerDTO;
    }

    @Override
    public ConteinerDTO findById(Long id) {
        Optional<ConteinerDTO> conteinerDtoOptional = Optional.ofNullable(conteinerMapper.toDto(conteinerRepository.getById(id)));
        return conteinerDtoOptional.orElse(null);
    }

    @Override
    public List<ConteinerDTO> findAll() {
        List<Conteiner> allConteiner = conteinerRepository.findAll();
        return allConteiner.stream().map(conteinerMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public boolean update(ConteinerDTO conteinerDTO) {
        if (conteinerRepository.existsById(conteinerDTO.getId())) {
            conteinerRepository.save(conteinerMapper.toModel(conteinerDTO));
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (conteinerRepository.existsById(id)) {
            conteinerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
