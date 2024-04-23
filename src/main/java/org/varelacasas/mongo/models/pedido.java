package org.varelacasas.mongo.models;

import java.util.Date;
import java.util.List;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

// Meter el nombre de la collección de mongo si no funciona correctame
public class pedido {

    private ObjectId id;
    @BsonProperty(value = "fecha_hora_pedido")
    private Date fechaHoraPedido;
    @BsonProperty(value = "grupo_id")
    private ObjectId grupoId;
    @BsonProperty(value = "bar_id")
    private ObjectId barId;
    @BsonProperty(value = "consumiciones")
    private List<consumicion> listaConsumiciones;
    private estado estado;
    @BsonProperty(value = "estado_cobro")
    private estadoCobro estadoCobro;
    @BsonProperty(value = "camarero")
    private camarero camareroResponsable;
    private float importeTotal;
    @BsonProperty(value = "fecha_hora_en_proceso")
    private Date fechaHoraEnProceso;
    @BsonProperty(value = "fecha_hora_despachado")
    private Date fechaHoraDespachado;
    @BsonProperty(value = "fecha_hora_cerrado")
    private Date fechaHoraCerrado;
    @BsonProperty(value = "fecha_hora_modificado")
    private List<Date> fechaHoraModificado;
    @BsonProperty(value = "fecha_hora_cancelado")
    private Date fechaHoraCancelado;

    public pedido() {}

    public pedido(ObjectId grupoId, ObjectId barId, List<consumicion> listaConsumiciones) {
        this.fechaHoraPedido = new Date();
        this.grupoId = grupoId;
        this.barId = barId;
        this.listaConsumiciones = listaConsumiciones;
        this.estado = org.varelacasas.mongo.models.estado.EN_COLA;
        this.estadoCobro = org.varelacasas.mongo.models.estadoCobro.NADA;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getFechaHoraPedido() {
        return fechaHoraPedido;
    }

    public void setFechaHoraPedido(Date fechaHoraPedido) {
        this.fechaHoraPedido = fechaHoraPedido;
    }

    public ObjectId getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(ObjectId grupoId) {
        this.grupoId = grupoId;
    }

    public ObjectId getBarId() {
        return barId;
    }

    public void setBarId(ObjectId barId) {
        this.barId = barId;
    }

    public List<consumicion> getListaConsumiciones() {
        return listaConsumiciones;
    }

    public void setListaConsumiciones(List<consumicion> listaConsumiciones) {
        this.listaConsumiciones = listaConsumiciones;
    }

    public org.varelacasas.mongo.models.estado getEstado() {
        return estado;
    }

    public void setEstado(org.varelacasas.mongo.models.estado estado) {
        this.estado = estado;
    }

    public org.varelacasas.mongo.models.estadoCobro getEstadoCobro() {
        return estadoCobro;
    }

    public void setEstadoCobro(org.varelacasas.mongo.models.estadoCobro estadoCobro) {
        this.estadoCobro = estadoCobro;
    }

    public camarero getCamareroResponsable() {
        return camareroResponsable;
    }

    public void setCamareroResponsable(camarero camareroResponsable) {
        this.camareroResponsable = camareroResponsable;
    }

    public float getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(float importeTotal) {
        this.importeTotal = importeTotal;
    }

    public Date getFechaHoraEnProceso() {
        return fechaHoraEnProceso;
    }

    public void setFechaHoraEnProceso(Date fechaHoraEnProceso) {
        this.fechaHoraEnProceso = fechaHoraEnProceso;
    }

    public Date getFechaHoraDespachado() {
        return fechaHoraDespachado;
    }

    public void setFechaHoraDespachado(Date fechaHoraDespachado) {
        this.fechaHoraDespachado = fechaHoraDespachado;
    }

    public Date getFechaHoraCerrado() {
        return fechaHoraCerrado;
    }

    public void setFechaHoraCerrado(Date fechaHoraCerrado) {
        this.fechaHoraCerrado = fechaHoraCerrado;
    }

    public List<Date> getFechaHoraModificado() {
        return fechaHoraModificado;
    }

    public void setFechaHoraModificado(List<Date> fechaHoraModificado) {
        this.fechaHoraModificado = fechaHoraModificado;
    }

    public Date getFechaHoraCancelado() {
        return fechaHoraCancelado;
    }

    public void setFechaHoraCancelado(Date fechaHoraCancelado) {
        this.fechaHoraCancelado = fechaHoraCancelado;
    }
}
