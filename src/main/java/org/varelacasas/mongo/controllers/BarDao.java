package org.varelacasas.mongo.controllers;

import org.bson.types.ObjectId;
import org.varelacasas.mongo.models.alumno;
import com.mongodb.client.MongoCollection;
import org.bson.conversions.Bson;
import org.varelacasas.mongo.models.bar;
import org.varelacasas.mongo.utils.ConexionBaseDatos;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;


public class BarDao implements DaoInterface<bar> {

    private final String COLLECTION_NAME = "bares";
    private final String DATABASE_NAME = "pedidos_app";
    ConexionBaseDatos<bar> conn = new ConexionBaseDatos<>(DATABASE_NAME, COLLECTION_NAME, bar.class);
    MongoCollection<bar> collection = conn.getCollection();

    public bar getById(ObjectId id){
        Bson equalComp = eq("_id", id);
        return collection.find(equalComp).first();
    }

    @Override
    public bar get(bar bar) {
        return null;
    }

    @Override
    public List<bar> getAll() {
        return null;
    }

    @Override
    public void save(bar bar) {

    }

    @Override
    public void update(bar bar, String[] params) {

    }

    @Override
    public void delete(bar bar) {

    }
}