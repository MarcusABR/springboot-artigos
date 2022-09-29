package br.com.bb.letscode.artigos.entity;

import lombok.Setter;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Artigo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "É necessário um título")
    private String titulo;
    @NotNull(message = "É necessário um texti")
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
