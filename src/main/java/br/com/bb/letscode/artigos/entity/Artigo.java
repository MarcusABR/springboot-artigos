package br.com.bb.letscode.artigos.entity;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
public class Artigo{
    private String codigoArtigo;
    private String nomeUsuario;
    private String titulo;
    private String texto;
    private String lingua;
    private Integer upvote;
    private Integer downvote;
}
