package entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "usuario_id", nullable = false)
    private User usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "local_esportivo_id", nullable = false)

    private LocalEsportivo localEsportivo;

    private LocalDateTime dataHora;

    public Reserva() {}

    public Reserva(User usuario, LocalEsportivo localEsportivo, LocalDateTime dataHora) {
        this.usuario = usuario;
        this.localEsportivo = localEsportivo;
        this.dataHora = dataHora;
    }

    public Long getId() {
        return id;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public LocalEsportivo getLocalEsportivo() {
        return localEsportivo;
    }

    public void setLocalEsportivo(LocalEsportivo localEsportivo) {
        this.localEsportivo = localEsportivo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

}
