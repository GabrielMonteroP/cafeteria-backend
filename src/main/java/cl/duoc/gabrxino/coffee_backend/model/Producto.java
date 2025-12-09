package cl.duoc.gabrxino.coffee_backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "productos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    @Column(nullable = false)
    private Integer precio;

    @Column(nullable = false)
    private Integer stock;

    private String imagen;

    private String categoria;

    private Boolean destacado;


}