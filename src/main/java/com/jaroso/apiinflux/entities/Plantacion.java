package com.jaroso.apiinflux.entities;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Plantacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    //En el futuro podría ser una relación List<Coordenada>
    private String ubicacion;

    @Column(name = "tipo_producto")
    private String tipoProducto;

    public Plantacion(String nombre, String ubicacion, String tipoProducto) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipoProducto = tipoProducto;
    }
}
