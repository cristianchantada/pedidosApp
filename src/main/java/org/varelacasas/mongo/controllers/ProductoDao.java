package org.varelacasas.mongo.controllers;


import com.mongodb.client.MongoCollection;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.varelacasas.mongo.models.grupo;
import org.varelacasas.mongo.models.producto;
import org.varelacasas.mongo.utils.ConexionBaseDatos;
import java.util.ArrayList;
import java.util.List;
import static com.mongodb.client.model.Filters.eq;


public class ProductoDao implements DaoInterface<producto> {

    private final String COLLECTION_NAME = "camareros";
    private final String DATABASE_NAME = "pedidos_app";
    ConexionBaseDatos<producto> conn = new ConexionBaseDatos<>(DATABASE_NAME, COLLECTION_NAME, producto.class);
    MongoCollection<producto> collection = conn.getCollection();

    public producto getById(ObjectId id){
        Bson equalComp = eq("_id", id);
        return collection.find(equalComp).first();
    }

    @Override
    public producto get(producto producto) {
        return null;
    }

    @Override
    public List<producto> getAll() {
        return null;
    }

    @Override
    public void save(producto producto) {

    }

    @Override
    public void update(producto producto, String[] params) {

    }

    @Override
    public void delete(producto producto) {

    }
}
