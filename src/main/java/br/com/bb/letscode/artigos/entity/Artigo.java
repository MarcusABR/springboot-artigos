package br.com.bb.letscode.artigos.entity;

import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Artigo{
    @Id
    private long id;
    private String codigoArtigo;
    private String codigoUsuario;
    private String titulo;
    private String texto;
    private String lingua;
    private Integer upvote;
    private Integer downvote;
}
