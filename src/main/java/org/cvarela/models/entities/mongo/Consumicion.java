package org.cvarela.models.entities.mongo;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.cvarela.models.EstadoCobroConsumicion;

public class Consumicion {

    private ObjectId id;
    @BsonProperty(value = "alumno_id")
    private ObjectId alumnoId;
    @BsonProperty(value = "producto_id")
    private ObjectId productoId;
    private Alumno alumno;
    private Producto producto;
    @BsonProperty(value = "estado_cobro")
    private EstadoCobroConsumicion estadoCobroConsumicion;

    public Consumicion(){this.estadoCobroConsumicion = EstadoCobroConsumicion.PENDIENTE;}

    public Consumicion(Alumno alumno, Producto producto) {
        this.alumno = alumno;
        this.producto = producto;
        this.estadoCobroConsumicion = EstadoCobroConsumicion.PENDIENTE;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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

    public ObjectId getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(ObjectId alumnoId) {
        this.alumnoId = alumnoId;
    }

    public ObjectId getProductoId() {
        return productoId;
    }

    public void setProductoId(ObjectId productoId) {
        this.productoId = productoId;
    }
}
