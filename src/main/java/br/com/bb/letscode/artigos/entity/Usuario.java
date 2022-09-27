package br.com.bb.letscode.artigos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
// import javax.persistence.Entity;
// import javax.persistence.Id;
// import javax.persistence.OneToOne;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
// @Entity
public class Usuario {
    // @Id
    private Long id;
    private String nome;
    private String email;
    private String senha;
    // @OneToOne
    private Endereco endereco;
}
