package com.example.letscode.questao;

import com.example.letscode.disciplina.Disciplina;
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
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition="TEXT", nullable = false)
    private String enunciado;
    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;

    public Questao(String enunciado, Disciplina disciplina) {
        this.enunciado = enunciado;
        this.disciplina = disciplina;
    }

    @Override
    public String toString(){
        String res = "Questao " + this.id + " da disciplina " + this.disciplina.getNome() + "\n\r" +
                this.enunciado + "\n\r";
        return res;
    }
}
