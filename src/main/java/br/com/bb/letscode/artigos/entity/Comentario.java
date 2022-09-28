package br.com.bb.letscode.artigos.entity;
import lombok.Setter;
import br.com.bb.letscode.artigos.entity.enums.TipoComentario;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
public class Comentario {
    private Long id;
    private String nomeUsuario;
    private String codigoArtigo;
    private TipoComentario tipo;
}
