package org.cvarela.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.cvarela.models.Estado;
import org.cvarela.models.EstadoCobro;
import org.cvarela.models.EstadoCobroConsumicion;
import org.cvarela.models.entities.sql.Consumicion;
import org.cvarela.models.entities.sql.Pedido;
import org.cvarela.services.jpaImpls.ConsumicionServiceJpaImpl;
import org.cvarela.services.jpaImpls.PedidoServiceJpaImpl;
import org.cvarela.services.mongoImpls.ConsumicionServiceMongoImpl;
import org.cvarela.services.mongoImpls.PedidoServiceMongoImpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/cobrar-consumicion")
public class CobrarConsumicionServlet extends HttpServlet {

    @Inject
    private ConsumicionServiceJpaImpl consumicionService;

    //@Inject
    //private ConsumicionServiceMongoImpl consumicionService;

    @Inject
    private PedidoServiceJpaImpl pedidoService;

    //@Inject
    //private PedidoServiceMongoImpl pedidoService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer pedidoId;
        try {
            pedidoId = Integer.valueOf(req.getParameter("id"));
        } catch (NumberFormatException e){
            pedidoId = 0;
        }

        Integer consumicionId;
        try {
            consumicionId = Integer.valueOf(req.getParameter("consumicion-id"));
        } catch(NumberFormatException e){
            consumicionId = 0;
        }

        Consumicion consumicion;

        if (consumicionId > 0) {
            Optional<Consumicion> o = consumicionService.get(consumicionId);
            if (o.isPresent()) {
                consumicion = o.get();
                consumicion.setEstadoCobroConsumicion(EstadoCobroConsumicion.PAGADO);
                consumicionService.save(consumicion);
            }
        }

        boolean estaTodoPagado = true;
        Pedido pedido;
        if (pedidoId > 0) {
            Optional<Pedido> o = pedidoService.get(pedidoId);
            if (o.isPresent()) {
                pedido = o.get();

                if(!pedido.getEstadoCobro().equals(EstadoCobro.PARCIAL)){
                    pedido.setEstadoCobro(EstadoCobro.PARCIAL);
                }


                List<Consumicion> consumicionesDelPedido = pedido.getListaConsumiciones();
                for(Consumicion c : consumicionesDelPedido){
                    if (!c.getEstadoCobroConsumicion().equals(EstadoCobroConsumicion.PAGADO)) {
                        estaTodoPagado = false;
                        break;
                    }
                }

                if(estaTodoPagado){
                    pedido.setEstadoCobro(EstadoCobro.COMPLETO);
                    pedido.setEstado(Estado.CERRADO);
                }

            pedidoService.save(pedido);

            }
        }

        if (estaTodoPagado){
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        } else {
            resp.sendRedirect(req.getContextPath() + "/gestionar-pedido?id=" + pedidoId);
        }
    }
}
