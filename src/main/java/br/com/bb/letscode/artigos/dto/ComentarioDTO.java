package br.com.bb.letscode.artigos.dto;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class ComentarioDTO {
    private String id;
    private String nomeUsuario;
    private String codigoArtigo;
}
