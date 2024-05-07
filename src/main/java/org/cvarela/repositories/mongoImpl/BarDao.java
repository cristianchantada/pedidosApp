package org.cvarela.repositories.mongoImpl;

import com.mongodb.client.MongoCollection;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.cvarela.models.entities.Bar;
import org.cvarela.repositories.CrudRepositoryInterface;
import org.cvarela.utils.ConexionBaseDatos;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;


public class BarDao implements CrudRepositoryInterface<Bar> {

    private final String COLLECTION_NAME = "bares";
    private final String DATABASE_NAME = "pedidos_app";
    ConexionBaseDatos<Bar> conn = new ConexionBaseDatos<>(DATABASE_NAME, COLLECTION_NAME, Bar.class);
    MongoCollection<Bar> collection = conn.getCollection();

    public Bar getById(ObjectId id){
        Bson equalComp = eq("_id", id);
        return collection.find(equalComp).first();
    }

    @Override
    public Bar get(int id) throws Exception {
        return null;
    }

    @Override
    public List<Bar> getAll() throws Exception {
        return null;
    }

    @Override
    public void save(Bar bar) throws Exception {

    }

    @Override
    public void delete(int id) throws Exception {

    }
}