package entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "locais_esportivos")
public class LocalEsportivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String endereco;
    private String tipoDeEsporte;

    @Column(name = "preco_por_hora", precision = 10, scale = 2)
    private BigDecimal precoPorHora;

    @ManyToOne
    @JoinColumn(name = "anfitriao_id", nullable = false)
    private Anfitriao anfitriao;


    public LocalEsportivo(String nome, String endereco, String tipoDeEsporte, BigDecimal precoPorHora) {
        this.nome = nome;
        this.endereco = endereco;
        this.tipoDeEsporte = tipoDeEsporte;
        this.precoPorHora = precoPorHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipoDeEsporte() {
        return tipoDeEsporte;
    }

    public void setTipoDeEsporte(String tipoDeEsporte) {
        this.tipoDeEsporte = tipoDeEsporte;
    }

    public BigDecimal getPrecoPorHora() {
        return precoPorHora;
    }

    public void setPrecoPorHora(BigDecimal precoPorHora) {
        this.precoPorHora = precoPorHora;
    }

    public Anfitriao getAnfitriao() {
        return anfitriao;
    }

    public void setAnfitriao(Anfitriao anfitriao) {
        this.anfitriao = anfitriao;
    }
}

