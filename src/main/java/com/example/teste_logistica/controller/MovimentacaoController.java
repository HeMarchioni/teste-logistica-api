package com.example.teste_logistica.controller;

import com.example.teste_logistica.model.DTO.MovimentacaoDTO;
import com.example.teste_logistica.model.services.MovimentacaoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/movimentacao")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MovimentacaoController implements ControllerInterface<MovimentacaoDTO>{


    private final MovimentacaoService movimentacaoService;


    @Override
    @GetMapping
    public ResponseEntity<List<MovimentacaoDTO>> getAll() {
        return ResponseEntity.ok(movimentacaoService.findAll());
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getId(@PathVariable("id") Long id) {
        MovimentacaoDTO movimentacaoDTO = movimentacaoService.findById(id);
        if ( movimentacaoDTO != null)
            return ResponseEntity.ok(movimentacaoDTO);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @PostMapping
    public ResponseEntity<MovimentacaoDTO> create(@RequestBody @Valid MovimentacaoDTO movimentacaoDTO) {
        movimentacaoService.create(movimentacaoDTO);
        return ResponseEntity.ok(movimentacaoDTO);
    }

    @Override
    @PutMapping
    public ResponseEntity<?> put(@RequestBody @Valid MovimentacaoDTO movimentacaoDTO) {
        if (movimentacaoService.update(movimentacaoDTO)) {
            return ResponseEntity.ok(movimentacaoDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteId(@PathVariable Long id) {
        if (movimentacaoService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
