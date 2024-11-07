package entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "anfitrioes")
public class Anfitriao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;

    // Associação com os locais esportivos
    @OneToMany(mappedBy = "anfitriao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<LocalEsportivo> locaisEsportivos = new HashSet<>();

    // Construtores, getters e setters
    public Anfitriao() {}

    public Anfitriao(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Set<LocalEsportivo> getLocaisEsportivos() {
        return locaisEsportivos;
    }

    public void setLocaisEsportivos(Set<LocalEsportivo> locaisEsportivos) {
        this.locaisEsportivos = locaisEsportivos;
    }

    public void addLocalEsportivo(LocalEsportivo localEsportivo) {
        locaisEsportivos.add(localEsportivo);
        localEsportivo.setAnfitriao(this);
    }
}

