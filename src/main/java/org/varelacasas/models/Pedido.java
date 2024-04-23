package org.varelacasas.models;

import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

    private int id;
    private LocalDateTime fechaHoraPedido;
    private Grupo grupo;
    private Bar bar;
    private List<Consumicion> listaConsumiciones;
    private Estado estado;
    private EstadoCobro estadoCobro;
    private Camarero camareroResponsable;
    private float importeTotal;
    private LocalDateTime fechaHoraEnProceso;
    private LocalDateTime fechaHoraDespachado;
    private LocalDateTime fechaHoraCerrado;
    private List<LocalDateTime> fechaHoraModificado;
    private LocalDateTime fechaHoraCancelado;

    public Pedido() {}

    public Pedido(Grupo grupo, Bar bar, List<Consumicion> listaConsumiciones) {
        this.fechaHoraPedido = LocalDateTime.now();
        this.grupo = grupo;
        this.bar = bar;
        this.listaConsumiciones = listaConsumiciones;
        this.estado = Estado.EN_COLA;
        this.estadoCobro = EstadoCobro.NADA;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaHoraPedido() {
        return fechaHoraPedido;
    }

    public void setFechaHoraPedido(LocalDateTime fechaHoraPedido) {
        this.fechaHoraPedido = fechaHoraPedido;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
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

    public Camarero getCamareroResponsable() {
        return camareroResponsable;
    }

    public void setCamareroResponsable(Camarero camareroResponsable) {
        this.camareroResponsable = camareroResponsable;
    }

    public float getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(float importeTotal) {
        this.importeTotal = importeTotal;
    }

    public LocalDateTime getFechaHoraEnProceso() {
        return fechaHoraEnProceso;
    }

    public void setFechaHoraEnProceso(LocalDateTime fechaHoraEnProceso) {
        this.fechaHoraEnProceso = fechaHoraEnProceso;
    }

    public LocalDateTime getFechaHoraDespachado() {
        return fechaHoraDespachado;
    }

    public void setFechaHoraDespachado(LocalDateTime fechaHoraDespachado) {
        this.fechaHoraDespachado = fechaHoraDespachado;
    }

    public LocalDateTime getFechaHoraCerrado() {
        return fechaHoraCerrado;
    }

    public void setFechaHoraCerrado(LocalDateTime fechaHoraCerrado) {
        this.fechaHoraCerrado = fechaHoraCerrado;
    }

    public List<LocalDateTime> getFechaHoraModificado() {
        return fechaHoraModificado;
    }

    public void setFechaHoraModificado(List<LocalDateTime> fechaHoraModificado) {
        this.fechaHoraModificado = fechaHoraModificado;
    }

    public LocalDateTime getFechaHoraCancelado() {
        return fechaHoraCancelado;
    }

    public void setFechaHoraCancelado(LocalDateTime fechaHoraCancelado) {
        this.fechaHoraCancelado = fechaHoraCancelado;
    }
}
