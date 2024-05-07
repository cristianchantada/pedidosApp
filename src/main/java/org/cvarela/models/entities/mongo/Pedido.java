package org.cvarela.models.entities.mongo;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.cvarela.models.Estado;
import org.cvarela.models.EstadoCobro;

import java.util.Date;
import java.util.List;

public class Pedido {

    private ObjectId id;
    @BsonProperty(value = "fecha_hora_pedido")
    private Date fechaHoraPedido;
    @BsonProperty(value = "grupo_id")
    private ObjectId grupoId;
    @BsonProperty(value = "bar_id")
    private ObjectId barId;
    @BsonProperty(value = "consumiciones")
    private List<Consumicion> listaConsumiciones;
    private Estado estado;
    @BsonProperty(value = "estado_cobro")
    private EstadoCobro estadoCobro;
    @BsonProperty(value = "camarero_id")
    private ObjectId camareroId;
    private float importeTotal;
    @BsonProperty(value = "fecha_hora_en_proceso")
    private Date fechaHoraEnProceso;
    @BsonProperty(value = "fecha_hora_despachado")
    private Date fechaHoraDespachado;
    @BsonProperty(value = "fecha_hora_cerrado")
    private Date fechaHoraCerrado;
    @BsonProperty(value = "fecha_hora_modificado")
    private Date fechaHoraModificado;
    @BsonProperty(value = "fecha_hora_cancelado")
    private Date fechaHoraCancelado;
    private Bar bar;
    private Camarero camareroResponsable;
    private Alumno alumno;
    private Grupo grupo;

    public Pedido() {
        this.estado = estado.EN_COLA;
        this.estadoCobro = estadoCobro.NADA;
    }

    public Pedido(ObjectId grupoId, ObjectId barId, List<Consumicion> listaConsumiciones) {
        this.fechaHoraPedido = new Date();
        this.grupoId = grupoId;
        this.barId = barId;
        this.listaConsumiciones = listaConsumiciones;
        this.estado = estado.EN_COLA;
        this.estadoCobro = estadoCobro.NADA;
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

    public List<Consumicion> getListaConsumiciones() {
        return listaConsumiciones;
    }

    public void setListaConsumiciones(List<Consumicion> listaConsumiciones) {
        this.listaConsumiciones = listaConsumiciones;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public EstadoCobro getEstadoCobro() {
        return estadoCobro;
    }

    public void setEstadoCobro(EstadoCobro estadoCobro) {
        this.estadoCobro = estadoCobro;
    }

    public ObjectId getCamareroId() {
        return camareroId;
    }

    public void setCamareroId(ObjectId camareroId) {
        this.camareroId = camareroId;
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

    public Date getFechaHoraModificado() {
        return fechaHoraModificado;
    }

    public void setFechaHoraModificado(Date fechaHoraModificado) {
        this.fechaHoraModificado = fechaHoraModificado;
    }

    public Date getFechaHoraCancelado() {
        return fechaHoraCancelado;
    }

    public void setFechaHoraCancelado(Date fechaHoraCancelado) {
        this.fechaHoraCancelado = fechaHoraCancelado;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public Camarero getCamareroResponsable() {
        return camareroResponsable;
    }

    public void setCamareroResponsable(Camarero camareroResponsable) {
        this.camareroResponsable = camareroResponsable;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "pedido{" +
                "id=" + id +
                ", fechaHoraPedido=" + fechaHoraPedido +
                ", listaConsumiciones=" + listaConsumiciones +
                ", estado=" + estado +
                ", estadoCobro=" + estadoCobro +
                ", importeTotal=" + importeTotal +
                ", fechaHoraEnProceso=" + fechaHoraEnProceso +
                ", fechaHoraDespachado=" + fechaHoraDespachado +
                ", fechaHoraCerrado=" + fechaHoraCerrado +
                ", fechaHoraModificado=" + fechaHoraModificado +
                ", fechaHoraCancelado=" + fechaHoraCancelado +
                ", aBar=" + bar +
                ", camarero=" + camareroResponsable +
                ", aAlumno=" + alumno +
                ", aGrupo=" + grupo +
                '}';
    }
}
