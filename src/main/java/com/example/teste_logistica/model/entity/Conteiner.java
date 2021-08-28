package com.example.teste_logistica.model.entity;


import com.example.teste_logistica.model.enums.container.Categoria;
import com.example.teste_logistica.model.enums.container.Status;
import com.example.teste_logistica.model.enums.container.TipoContainer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Conteiner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Gerar o valor automaticamente do id
    private Long id;

    @Column(nullable = false, length = 50)
    private String nm_Cliente;

    @Column(nullable = false, length = 11, unique = true)
    private String cd_Container;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoContainer ds_Tipo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status ds_Status;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Categoria ds_Categoria;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})  // -> campo com relacionamento com outra tabela ele ira criar a tabela de relacionamento (OneTomany 1 para muitos, fetch lazy para performace, casacade para a hora que for cadastrar ja a persona ja cadastrar o telefone.
    private List<Movimentacao> movimentacaos = new ArrayList<>();


}
