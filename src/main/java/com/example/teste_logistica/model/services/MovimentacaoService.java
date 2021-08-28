package com.example.teste_logistica.model.services;

import com.example.teste_logistica.model.DTO.MovimentacaoDTO;
import com.example.teste_logistica.model.entity.Movimentacao;
import com.example.teste_logistica.model.mapper.MovimentacaoMapper;
import com.example.teste_logistica.model.repository.MovimentacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MovimentacaoService implements ServiceInterface<MovimentacaoDTO>{

    private MovimentacaoRepository movimentacaoRepository;

    private final MovimentacaoMapper movimentacaoMapper = MovimentacaoMapper.INSTANCE;

    @Override
    public MovimentacaoDTO create(MovimentacaoDTO movimentacaoDTO) {
        var container = movimentacaoMapper.toModel(movimentacaoDTO);
        movimentacaoRepository.save(container);
        return movimentacaoDTO;
    }

    @Override
    public MovimentacaoDTO findById(Long id) {
        Optional<MovimentacaoDTO> movimentacaoDtoOptional = Optional.ofNullable(movimentacaoMapper.toDto(movimentacaoRepository.getById(id)));
        return movimentacaoDtoOptional.orElse(null);
    }

    @Override
    public List<MovimentacaoDTO> findAll() {
        List<Movimentacao> allMovimentacao = movimentacaoRepository.findAll();
        return allMovimentacao.stream().map(movimentacaoMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public boolean update(MovimentacaoDTO movimentacaoDTO) {
        if (movimentacaoRepository.existsById(movimentacaoDTO.getId())) {
            movimentacaoRepository.save(movimentacaoMapper.toModel(movimentacaoDTO));
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (movimentacaoRepository.existsById(id)) {
            movimentacaoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}



