package br.com.bb.letscode.artigos.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor()
public class Campo {
    private String nome;
    private Integer qtdArtigos;

    public Campo(String nome) {
        this.nome = nome;
        this.qtdArtigos = 0;
    }

    
}
