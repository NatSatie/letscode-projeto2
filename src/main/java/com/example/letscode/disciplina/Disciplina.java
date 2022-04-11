package com.example.letscode.disciplina;

import com.example.letscode.professor.Professor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    public Disciplina(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
    }

    @Override
    public String toString(){
        String res = "Disciplina " + this.nome + "; id: " + this.id + "\n\r" +
                "Professor responsavel " + this.professor.getNome() + "\n\r";
        return res;
    }
}
