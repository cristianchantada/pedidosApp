package org.varelacasas.mongo.controllers;

import com.mongodb.client.MongoCollection;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.varelacasas.mongo.models.pedido;
import org.varelacasas.mongo.utils.ConexionBaseDatos;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class PedidoDao implements DaoInterface<pedido> {

    private final String COLLECTION_NAME = "pedido";
    private final String DATABASE_NAME = "pedidos_app";
    ConexionBaseDatos<pedido> conn = new ConexionBaseDatos<>(DATABASE_NAME, COLLECTION_NAME, pedido.class);
    MongoCollection<pedido> collection = conn.getCollection();

    public PedidoDao(){}

    public pedido getById(ObjectId id){
        Bson equalComp = eq("_id", id);
        return collection.find(equalComp).first();
    }

    @Override
    public pedido get(pedido apedido) {
    return null;
    }

    @Override
    public List<pedido> getAll() {
        return collection.find().into(new ArrayList<pedido>());
    }

    @Override
    public void save(pedido pedido) {

    }

    @Override
    public void update(pedido pedido, String[] params) {

    }

    @Override
    public void delete(pedido pedido) {

    }
}
