package com.example.letscode.alternativa;

import com.example.letscode.questao.Questao;
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
public class Alternativa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Boolean eh_resposta;
    @ManyToOne
    @JoinColumn(name = "questao_id", nullable = false)
    private Questao questao;
}
