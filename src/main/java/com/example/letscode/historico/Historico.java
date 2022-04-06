package com.example.letscode.historico;

import com.example.letscode.aluno.Aluno;
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
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Double percentual_acerto;
    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    public Historico(Double percentual_acerto, Disciplina disciplina, Aluno aluno) {
        this.percentual_acerto = percentual_acerto;
        this.disciplina = disciplina;
        this.aluno = aluno;
    }
}
