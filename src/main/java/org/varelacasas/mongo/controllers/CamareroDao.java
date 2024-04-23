package org.varelacasas.mongo.controllers;

import org.bson.types.ObjectId;
import org.varelacasas.mongo.models.bar;
import org.varelacasas.mongo.models.camarero;
import com.mongodb.client.MongoCollection;
import org.bson.conversions.Bson;
import org.varelacasas.mongo.utils.ConexionBaseDatos;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;


public class CamareroDao implements DaoInterface<camarero> {

    private final String COLLECTION_NAME = "camareros";
    private final String DATABASE_NAME = "pedidos_app";
    ConexionBaseDatos<camarero> conn = new ConexionBaseDatos<>(DATABASE_NAME, COLLECTION_NAME, camarero.class);
    MongoCollection<camarero> collection = conn.getCollection();

    public camarero getById(ObjectId id){
        Bson equalComp = eq("_id", id);
        return collection.find(equalComp).first();
    }

    @Override
    public camarero get(camarero camarero) {
        return null;
    }

    @Override
    public List<camarero> getAll() {
        return null;
    }

    @Override
    public void save(camarero camarero) {

    }

    @Override
    public void update(camarero camarero, String[] params) {

    }

    @Override
    public void delete(camarero camarero) {

    }
}