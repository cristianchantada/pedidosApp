package org.varelacasas.mongo.models;

public enum estadoCobro {

    NADA("Nada"),
    PARCIAL("Parcial"),
    COMPLETO("Completo");

    private String estadoCobro;

    estadoCobro(String estadoCobro){
        this.estadoCobro = estadoCobro;
    }

    public String getEstadoCobro(){
        return estadoCobro;
    }

    public boolean isFinished(org.varelacasas.mongo.models.estadoCobro estadoCobro) {
        return estadoCobro == COMPLETO;
    }

}
