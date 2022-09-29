package br.com.bb.letscode.artigos.entity;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.bb.letscode.artigos.entity.enums.TipoComentario;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Comentario {
    @Id
    private Long id;
    private String nomeUsuario;
    private String codigoArtigo;
    @Enumerated(EnumType.STRING)
    private TipoComentario tipo;

    @ManyToOne
    private Artigo artigo;
}
