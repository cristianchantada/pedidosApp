package org.varelacasas.mongo.models;

public enum estado {
    EN_COLA("En cola"),
    EN_PROCESO("En proceso"),
    DESPACHADO("Despachado"),
    CERRADO("Cerrado"),
    EN_MODIFICACION("En modificación");

    private String estado;

    estado(String estado){
        this.estado = estado;
    }

    public String getEstado(){
        return this.estado;
    }

    public boolean isClosed(org.varelacasas.mongo.models.estado estado){
        return estado == CERRADO;
    }

}
