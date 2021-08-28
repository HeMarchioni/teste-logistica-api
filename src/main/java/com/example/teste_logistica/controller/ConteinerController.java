package com.example.teste_logistica.controller;

import com.example.teste_logistica.model.DTO.ConteinerDTO;
import com.example.teste_logistica.model.services.ConteinerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/container")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ConteinerController implements ControllerInterface<ConteinerDTO>{


    private final ConteinerService conteinerService;


    @Override
    @GetMapping
    public ResponseEntity<List<ConteinerDTO>> getAll() {
        return ResponseEntity.ok(conteinerService.findAll());
    }

    @Override
    @GetMapping(value = "/info/{id}")
    public ResponseEntity<?> getId(@PathVariable("id") Long id) {
        ConteinerDTO conteinerDTO = conteinerService.findById(id);
        if ( conteinerDTO != null)
            return ResponseEntity.ok(conteinerDTO);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @PostMapping
    public ResponseEntity<ConteinerDTO> create(@RequestBody @Valid ConteinerDTO conteinerDTO) {
        conteinerService.create(conteinerDTO);
        return ResponseEntity.ok(conteinerDTO);
    }

    @Override
    @PutMapping
    public ResponseEntity<?> put(@RequestBody @Valid ConteinerDTO conteinerDTO) {
        if (conteinerService.update(conteinerDTO)) {
            return ResponseEntity.ok(conteinerDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteId(@PathVariable Long id) {
        if (conteinerService.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
