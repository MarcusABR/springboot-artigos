package br.com.bb.letscode.artigos.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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

    @ManyToMany
    private List<Artigo> artigos;
}
