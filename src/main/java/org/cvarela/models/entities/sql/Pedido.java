package org.cvarela.models.entities.sql;

import jakarta.persistence.*;
import org.cvarela.models.*;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Grupo grupo;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Bar bar;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consumicion> listaConsumiciones;
    private Estado estado;
    @Column(name = "estado_cobro")
    private EstadoCobro estadoCobro;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Camarero camareroResponsable;
    private float importeTotal;
    @Embedded
    private FechaHorasPedidos fechaHorasPedidos = new FechaHorasPedidos();

    @PrePersist
    @PreUpdate
    public void prePersist(){
        this.estado = Estado.EN_COLA;
        this.estadoCobro = EstadoCobro.NADA;
    }

    public Pedido() {}


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
        //importeTotal = listaConsumiciones.stream().reduce((a , b) -> a.getProducto().getPrecio() + b.getProducto().getPrecio()).;
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
