package org.cvarela.repositories.mongoImpl;

import com.mongodb.client.MongoCollection;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.cvarela.models.entities.mongo.Grupo;
import org.cvarela.repositories.CrudRepositoryInterface;
import org.cvarela.util.ConexionBaseDatos;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;


public class GrupoRepositoryMongoImpl implements CrudRepositoryInterface<Grupo> {

    private final String COLLECTION_NAME = "grupos";
    private final String DATABASE_NAME = "pedidos_app";
    ConexionBaseDatos<Grupo> conn = new ConexionBaseDatos<>(DATABASE_NAME, COLLECTION_NAME, Grupo.class);
    MongoCollection<Grupo> collection = conn.getCollection();

    public Grupo getById(ObjectId id){
        Bson equalComp = eq("_id", id);
        return collection.find(equalComp).first();
    }

    @Override
    public Grupo get(int id) throws Exception {
        return null;
    }

    @Override
    public List<Grupo> getAll() throws Exception {
        return null;
    }

    @Override
    public void save(Grupo grupo) throws Exception {

    }

    @Override
    public void delete(int id) throws Exception {

    }
}