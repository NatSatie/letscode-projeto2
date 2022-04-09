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
    @Column(columnDefinition="TEXT", nullable = false)
    private String descricao;
    @Column(name = "eh_resposta", nullable = false)
    private Boolean ehResposta;
    @ManyToOne
    @JoinColumn(name = "questao_id", nullable = false)
    private Questao questao;

    public Alternativa(String descricao, Boolean ehResposta, Questao questao) {
        this.descricao = descricao;
        this.ehResposta = ehResposta;
        this.questao = questao;
    }
}
