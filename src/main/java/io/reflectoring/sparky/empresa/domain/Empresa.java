package io.reflectoring.sparky.empresa.domain;

import io.reflectoring.sparky.empresaAdmin.domain.EmpresaAdmin;
import io.reflectoring.sparky.restriccion.domain.Restriccion;
import io.reflectoring.sparky.solicitud.domain.Solicitud;
import io.reflectoring.sparky.usuario.domain.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empresas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String ruc;

    @Column(name = "fecha_afiliacion", nullable = false)
    private LocalDate fechaAfiliacion;

    @Column(name = "activo", nullable = false)
    private boolean activo = true;

    // Relación con el administrador principal (OneToOne)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_principal_id", referencedColumnName = "id")
    private EmpresaAdmin adminPrincipal;

    // Relación con usuarios (OneToMany)
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Usuario> usuarios = new ArrayList<>();

    // Relación con restricciones (OneToMany)
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Restriccion> restricciones = new ArrayList<>();

    // Relación con solicitudes (OneToMany)
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Solicitud> solicitudes = new ArrayList<>();

}