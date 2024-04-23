package org.varelacasas.mongo.controllers;

import org.bson.types.ObjectId;
import org.varelacasas.mongo.models.camarero;
import org.varelacasas.mongo.models.grupo;
import com.mongodb.client.MongoCollection;
import org.bson.conversions.Bson;
import org.varelacasas.mongo.utils.ConexionBaseDatos;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;


public class GrupoDao implements DaoInterface<grupo> {

    private final String COLLECTION_NAME = "camareros";
    private final String DATABASE_NAME = "pedidos_app";
    ConexionBaseDatos<grupo> conn = new ConexionBaseDatos<>(DATABASE_NAME, COLLECTION_NAME, grupo.class);
    MongoCollection<grupo> collection = conn.getCollection();

    public grupo getById(ObjectId id){
        Bson equalComp = eq("_id", id);
        return collection.find(equalComp).first();
    }

    @Override
    public grupo get(grupo grupo) {
        return null;
    }

    @Override
    public List<grupo> getAll() {
        return null;
    }

    @Override
    public void save(grupo grupo) {

    }

    @Override
    public void update(grupo grupo, String[] params) {

    }

    @Override
    public void delete(grupo grupo) {

    }
}