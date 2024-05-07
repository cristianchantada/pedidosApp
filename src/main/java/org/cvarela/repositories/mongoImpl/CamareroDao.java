package org.cvarela.repositories.mongoImpl;

import com.mongodb.client.MongoCollection;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.cvarela.models.entities.Camarero;
import org.cvarela.repositories.CrudRepositoryInterface;
import org.cvarela.utils.ConexionBaseDatos;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;


public class CamareroDao implements CrudRepositoryInterface<Camarero> {

    private final String COLLECTION_NAME = "camareros";
    private final String DATABASE_NAME = "pedidos_app";
    ConexionBaseDatos<Camarero> conn = new ConexionBaseDatos<>(DATABASE_NAME, COLLECTION_NAME, Camarero.class);
    MongoCollection<Camarero> collection = conn.getCollection();

    public Camarero getById(ObjectId id){
        Bson equalComp = eq("_id", id);
        return collection.find(equalComp).first();
    }

    @Override
    public Camarero get(int id) throws Exception {
        return null;
    }

    @Override
    public List<Camarero> getAll() throws Exception {
        return null;
    }

    @Override
    public void save(Camarero camarero) throws Exception {

    }

    @Override
    public void delete(int id) throws Exception {

    }
}