package com.example.teste_logistica.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ControllerInterface<T> {

    ResponseEntity<List<T>> getAll();
    ResponseEntity<?> getId(Long id);
    ResponseEntity<T> create(T obj);
    ResponseEntity<?> put(T obj);
    ResponseEntity<?> deleteId(Long id);


}
