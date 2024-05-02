package org.varelacasas.models.entities;

import jakarta.persistence.*;
import org.varelacasas.models.*;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Grupo grupo;
    private Bar bar;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consumicion> listaConsumiciones;
    private Estado estado;
    @Column(name = "estado_cobro")
    private EstadoCobro estadoCobro;
    @Column(name = "camarero")
    private Camarero camareroResponsable;
    private float importeTotal;

    @Embedded
    private FechaHorasPedidos fechaHorasPedidos = new FechaHorasPedidos();

    public Pedido() {}

    public Pedido(Grupo grupo, Bar bar, List<Consumicion> listaConsumiciones) {
        this.grupo = grupo;
        this.bar = bar;
        this.listaConsumiciones = listaConsumiciones;
        this.estado = Estado.EN_COLA;
        this.estadoCobro = EstadoCobro.NADA;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public FechaHorasPedidos getFechaHorasPedidos() {
        return fechaHorasPedidos;
    }

    public void setFechaHorasPedidos(FechaHorasPedidos fechaHorasPedidos) {
        this.fechaHorasPedidos = fechaHorasPedidos;
    }
}
