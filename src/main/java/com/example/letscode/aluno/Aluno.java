package com.example.letscode.aluno;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String matricula;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    public Aluno(String nome, String matricula, LocalDate data_nascimento) {
        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = data_nascimento;
    }
}



