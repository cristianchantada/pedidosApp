package org.cvarela.repositories.mongoImpl;


import com.mongodb.client.MongoCollection;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;
import org.cvarela.repositories.CrudRepositoryInterface;
import org.cvarela.models.entities.mongo.*;
import org.cvarela.util.ConexionBaseDatos;
import static com.mongodb.client.model.Filters.eq;

public class PedidoRepositoryMongoImpl implements CrudRepositoryInterface<Pedido> {

    private final String COLLECTION_NAME = "pedidos";
    private final String DATABASE_NAME = "pedidos_app";
    ConexionBaseDatos<Pedido> conn = new ConexionBaseDatos<>(DATABASE_NAME, COLLECTION_NAME, Pedido.class);
    MongoCollection<Pedido> collection = conn.getCollection();

    public PedidoRepositoryMongoImpl() {
    }

    public Pedido getById(ObjectId id) {
        Bson equalComp = eq("_id", id);
        return collection.find(equalComp).first();
    }

    @Override
    public Pedido get(int id) {
        return null;
    }

    @Override
    public List<Pedido> getAll() {
        List<Pedido> newPedidosLista = new ArrayList<>();
        List<Pedido> pedidosLista = collection.find().into(new ArrayList<>());

        for (Pedido p : pedidosLista) {

            BarRepositoryMongoImpl barRepositoryMongoImpl = new BarRepositoryMongoImpl();
            Bar aBar = barRepositoryMongoImpl.getById(p.getBarId());
            p.setBar(aBar);

            System.out.println("aBar = " + aBar);

            GrupoRepositoryMongoImpl grupoRepositoryMongoImpl = new GrupoRepositoryMongoImpl();
            Grupo aGrupo = grupoRepositoryMongoImpl.getById(p.getGrupoId());
            p.setGrupo(aGrupo);

            RepositoryMongoImpl repositoryMongoImpl = new RepositoryMongoImpl();
            Camarero aCamarero = repositoryMongoImpl.getById(p.getCamareroId());
            p.setCamareroResponsable(aCamarero);

            List<Consumicion> consumicionesPedidoLista = new ArrayList<>();
            if (p.getListaConsumiciones() != null && !p.getListaConsumiciones().isEmpty()) {
                List<Consumicion> consumicionesPedido = p.getListaConsumiciones();

                for (Consumicion c : consumicionesPedido) {
                    ObjectId alumnoId = c.getAlumnoId();
                    AlumnoRepositoryMongoImpl alumnoRepositoryMongoImpl = new AlumnoRepositoryMongoImpl();
                    Alumno aAlumno = alumnoRepositoryMongoImpl.getById(alumnoId);
                    c.setAlumno(aAlumno);

                    ObjectId productoId = c.getProductoId();
                    ProductoRepositoryMongoImpl productoRepositoryMongoImpl = new ProductoRepositoryMongoImpl();
                    Producto aProducto = productoRepositoryMongoImpl.getById(productoId);
                    c.setProducto(aProducto);
                    consumicionesPedidoLista.add(c);
                }

                p.setListaConsumiciones(consumicionesPedidoLista);
                newPedidosLista.add(p);
            }


        }
        return newPedidosLista;
    }

    @Override
    public void save(Pedido pedido) {
        collection.insertOne(pedido);
    }



    @Override
    public void delete(int id) {

    }
}
