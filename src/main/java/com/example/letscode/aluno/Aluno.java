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
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    public Aluno(String nome, String matricula, LocalDate dataNascimento) {
        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString(){
        String res = "Aluno " + this.nome + "; id: " + this.id + "; matricula: " + this.matricula + "\n\r" +
                "nascido em " + this.dataNascimento.toString() + "\n\r";
        return res;
    }
}



