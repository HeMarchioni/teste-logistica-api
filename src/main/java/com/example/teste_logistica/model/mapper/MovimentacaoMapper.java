package com.example.teste_logistica.model.mapper;


import com.example.teste_logistica.model.DTO.MovimentacaoDTO;
import com.example.teste_logistica.model.entity.Movimentacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovimentacaoMapper {

    MovimentacaoMapper INSTANCE = Mappers.getMapper(MovimentacaoMapper.class);

    @Mapping(target = "dt_Inicio", source = "dt_Inicio", dateFormat = "dd/MM/yyyy HH:mm:ss")
    @Mapping(target = "dt_Final", source = "dt_Final", dateFormat = "dd/MM/yyyy HH:mm:ss")
    Movimentacao toModel(MovimentacaoDTO movimentacaoDTO);

    MovimentacaoDTO toDto(Movimentacao movimentacao);




}
