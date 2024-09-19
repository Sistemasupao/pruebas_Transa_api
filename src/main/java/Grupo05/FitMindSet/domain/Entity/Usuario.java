package Grupo05.FitMindSet.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", nullable = true, length = 100)
    private String nombre;

    @Column(name = "Apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "Correo", nullable = false, unique = true)
    private String correo;

    @Column(name = "Contraseña", nullable = false)
    private String contrasena;

    @Column(name = "Edad")
    private int edad;

    @Column(name = "Genero")
    private String genero;

    @Column(name = "Roles", nullable = false)
    private String role;

    @ManyToOne
    @JoinColumn(name = "SuscripcionID")
    private Suscripcion suscripcion;

    @OneToMany(mappedBy = "usuario")
    private List<Habito> habitos;

    @OneToMany(mappedBy = "usuario")
    private List<Grupo> Grupos;

    @OneToMany(mappedBy = "usuario")
    private List<GestorDeGrupo> gruposGestionados; // Relación con GestorDeGrupos

    @Column(name = "NotificationFrequency")
    private String notificationFrequency;

    @Column(name = "Peso")
    private Double peso;

    @Column(name = "Altura")
    private Double altura;

    @OneToOne(mappedBy = "usuario")
    private Comentario comentario;

    // Método para calcular el IMC
    public Double calcularIMC() {
        if (peso != null && altura != null && altura > 0) {
            return peso / (altura * altura);
        }
        return null;
    }

    // Constructor sin argumentos
    public Usuario() {
    }

    public Usuario(String correo) {
        this.correo = correo;
    }
}
