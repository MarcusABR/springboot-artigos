package br.com.bb.letscode.artigos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Usuario {
    @Id
    private Long id;
    @NotNull(message = "Insira um nome.")
    private String nome;
    @NotNull(message = "Insira um email.")
    private String email;
    @NotNull(message = "Insira uma senha.")
    private String senha;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    // @JoinColumn(name="usuario_id")
    private List<Artigo> artigos;
}
