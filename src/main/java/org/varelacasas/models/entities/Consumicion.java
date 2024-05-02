package org.varelacasas.models.entities;

import jakarta.persistence.*;
import org.varelacasas.models.EstadoCobroConsumicion;
import org.varelacasas.models.entities.Alumno;
import org.varelacasas.models.entities.Producto;

@Entity
@Table(name = "consumiciones")
public class Consumicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Alumno alumno;
    @OneToOne
    private Producto producto;
    @Column(name = "estado_cobro_consumicion")
    private EstadoCobroConsumicion estadoCobroConsumicion;

    public Consumicion(){}

    public Consumicion(Alumno alumno, Producto producto){
        this.alumno = alumno;
        this.producto = producto;
        this.estadoCobroConsumicion = EstadoCobroConsumicion.PENDIENTE;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto produto) {
        this.producto = produto;
    }

    public EstadoCobroConsumicion getEstadoCobroConsumicion() {
        return estadoCobroConsumicion;
    }

    public void setEstadoCobroConsumicion(EstadoCobroConsumicion estadoCobroConsumicion) {
        this.estadoCobroConsumicion = estadoCobroConsumicion;
    }
}
