package org.varelacasas.models;

public class Consumicion {

    private int id;
    private Alumno alumno;
    private Producto produto;
    private EstadoCobroConsumicion estadoCobroConsumicion;

    public Consumicion(){}

    public Consumicion(Alumno alumno, Producto producto){
        this.alumno = alumno;
        this.produto = producto;
        this.estadoCobroConsumicion = EstadoCobroConsumicion.PENDIENTE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Producto getProduto() {
        return produto;
    }

    public void setProduto(Producto produto) {
        this.produto = produto;
    }

    public EstadoCobroConsumicion getEstadoCobroConsumicion() {
        return estadoCobroConsumicion;
    }

    public void setEstadoCobroConsumicion(EstadoCobroConsumicion estadoCobroConsumicion) {
        this.estadoCobroConsumicion = estadoCobroConsumicion;
    }
}
