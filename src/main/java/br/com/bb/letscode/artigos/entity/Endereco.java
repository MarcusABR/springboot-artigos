package br.com.bb.letscode.artigos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
// import javax.persistence.Entity;
// import javax.persistence.Id;
// import javax.persistence.OneToOne;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uf", length = 2)
    private String uf;
    private String cidade;
    @Column(name = "cep", length = 9)
    private String cep;
    private String bairro;
    private String logradouro;

    @OneToOne(mappedBy = "endereco")
    private Usuario usuario;
}
