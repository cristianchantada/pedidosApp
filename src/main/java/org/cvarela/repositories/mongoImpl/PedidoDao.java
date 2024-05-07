package org.cvarela.repositories.mongoImpl;

import com.mongodb.client.MongoCollection;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.cvarela.repositories.CrudRepositoryInterface;
import org.cvarela.utils.ConexionBaseDatos;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class PedidoDao implements CrudRepositoryInterface<Pedido> {

    private final String COLLECTION_NAME = "pedidos";
    private final String DATABASE_NAME = "pedidos_app";
    ConexionBaseDatos<Pedido> conn = new ConexionBaseDatos<>(DATABASE_NAME, COLLECTION_NAME, Pedido.class);
    MongoCollection<Pedido> collection = conn.getCollection();

    public PedidoDao() {
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

            BarDao barDao = new BarDao();
            Bar aBar = barDao.getById(p.getBarId());
            p.setBar(aBar);

            System.out.println("aBar = " + aBar);

            GrupoDao grupoDao = new GrupoDao();
            Grupo aGrupo = grupoDao.getById(p.getGrupoId());
            p.setGrupo(aGrupo);

            CamareroDao camareroDao = new CamareroDao();
            Camarero aCamarero = camareroDao.getById(p.getCamareroId());
            p.setCamareroResponsable(aCamarero);

            List<Consumicion> consumicionesPedidoLista = new ArrayList<>();
            if (p.getListaConsumiciones() != null && !p.getListaConsumiciones().isEmpty()) {
                List<Consumicion> consumicionesPedido = p.getListaConsumiciones();

                for (Consumicion c : consumicionesPedido) {
                    ObjectId alumnoId = c.getAlumnoId();
                    AlumnoDao alumnoDao = new AlumnoDao();
                    Alumno aAlumno = alumnoDao.getById(alumnoId);
                    c.setAlumno(aAlumno);

                    ObjectId productoId = c.getProductoId();
                    ProductoDao productoDao = new ProductoDao();
                    Producto aProducto = productoDao.getById(productoId);
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
