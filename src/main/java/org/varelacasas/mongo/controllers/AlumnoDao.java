package org.varelacasas.mongo.controllers;

import org.bson.types.ObjectId;
import org.varelacasas.mongo.models.alumno;
import com.mongodb.client.MongoCollection;
import org.bson.conversions.Bson;
import org.varelacasas.mongo.models.pedido;
import org.varelacasas.mongo.utils.ConexionBaseDatos;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;


public class AlumnoDao implements DaoInterface<alumno> {

    private final String COLLECTION_NAME = "alumnos";
    private final String DATABASE_NAME = "pedidos_app";
    ConexionBaseDatos<alumno> conn = new ConexionBaseDatos<>(DATABASE_NAME, COLLECTION_NAME, alumno.class);
    MongoCollection<alumno> collection = conn.getCollection();

    public alumno getById(ObjectId id){
        Bson equalComp = eq("_id", id);
        return collection.find(equalComp).first();
    }


    @Override
    public alumno get(alumno alumno) {
        return null;
    }

    @Override
    public List<alumno> getAll() {
        return null;
    }

    @Override
    public void save(alumno alumno) {

    }

    @Override
    public void update(alumno alumno, String[] params) {

    }

    @Override
    public void delete(alumno alumno) {

    }
}
