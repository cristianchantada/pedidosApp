package org.varelacasas.mongo.models;

import org.bson.types.ObjectId;

public class consumicion {

    private alumno alumno;
    private producto producto;
    private estadoCobroConsumicion estadoCobro = estadoCobroConsumicion.PENDIENTE;

    public consumicion(){}

}
