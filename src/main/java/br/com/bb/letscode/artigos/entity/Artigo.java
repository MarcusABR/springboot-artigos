package br.com.bb.letscode.artigos.entity;

import lombok.Setter;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Artigo{
    @Id
    private long id;
    private String titulo;
    private String texto;
    private String lingua;
    private Integer upvote;
    private Integer downvote;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artigo")
    // @JoinColumn(name="comentario_id")
    private List<Comentario> comentarios;

    @ManyToOne
    private Usuario usuario;
    
    @ManyToMany
    @JoinTable(
        name = "artigo_campos",
        // joinColumns = @JoinColumn(name = "campo_nome", referencedColumnName = ""),
        joinColumns = @JoinColumn(name = "campo_nome"),
        // inverseJoinColumns = @JoinColumn(name = "artigo_id", referencedColumnName = "id")
        inverseJoinColumns = @JoinColumn(name = "artigo_id")
    )

    private Set<Campo> campos;
}
