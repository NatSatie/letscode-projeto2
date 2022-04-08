package com.example.letscode.data;

import com.example.letscode.alternativa.Alternativa;
import com.example.letscode.questao.Questao;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QuestaoAlternativaTupla {
    private List<Questao> listaQuestao;
    private List<Alternativa> listaAlternativa;
}
