package br.com.bb.letscode.artigos.entity;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
public class Comentario {
    private String id;
    private String nomeUsuario;
    private String codigoArtigo;
}
