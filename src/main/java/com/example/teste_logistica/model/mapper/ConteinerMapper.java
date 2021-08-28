package com.example.teste_logistica.model.mapper;

import com.example.teste_logistica.model.DTO.ConteinerDTO;
import com.example.teste_logistica.model.entity.Conteiner;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConteinerMapper {

    ConteinerMapper INSTANCE = Mappers.getMapper(ConteinerMapper.class);


    Conteiner toModel(ConteinerDTO conteinerDTO);

    ConteinerDTO toDto(Conteiner conteiner);



}
