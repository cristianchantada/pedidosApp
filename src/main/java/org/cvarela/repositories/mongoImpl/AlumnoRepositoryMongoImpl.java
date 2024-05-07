package org.cvarela.repositories.mongoImpl;

import com.mongodb.client.MongoCollection;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.cvarela.models.entities.mongo.Alumno;
import org.cvarela.repositories.CrudRepositoryInterface;
import org.cvarela.util.ConexionBaseDatos;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;


public class AlumnoRepositoryMongoImpl implements CrudRepositoryInterface<Alumno> {

    private final String COLLECTION_NAME = "alumnos";
    private final String DATABASE_NAME = "pedidos_app";
    ConexionBaseDatos<Alumno> conn = new ConexionBaseDatos<>(DATABASE_NAME, COLLECTION_NAME, Alumno.class);
    MongoCollection<Alumno> collection = conn.getCollection();

    public Alumno getById(ObjectId id){
        Bson equalComp = eq("_id", id);
        return collection.find(equalComp).first();
    }

    @Override
    public Alumno get(int id) {
        return null;
    }

    @Override
    public List<Alumno> getAll() {
        return null;
    }

    @Override
    public void save(Alumno alumno) {

    }

    @Override
    public void delete(int id) {

    }
}
