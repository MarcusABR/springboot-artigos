package br.com.bb.letscode.artigos.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor()
@Entity
public class Campo {
    @Id
    private String nome;
    private Integer qtdArtigos;

    public Campo(String nome) {
        this.nome = nome;
        this.qtdArtigos = 0;
    }

    
}
