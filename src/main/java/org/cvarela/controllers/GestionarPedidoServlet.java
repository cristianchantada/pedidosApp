package org.cvarela.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.cvarela.models.entities.sql.Camarero;
import org.cvarela.models.entities.sql.Pedido;
import org.cvarela.services.jpaImpls.CamareroServiceJpaImpl;
import org.cvarela.services.jpaImpls.PedidoServiceJpaImpl;
import org.cvarela.services.mongoImpls.CamareroServiceMongoImpl;
import org.cvarela.services.mongoImpls.PedidoServiceMongoImpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/gestionar-pedido")
public class GestionarPedidoServlet extends HttpServlet {

    @Inject
    private PedidoServiceJpaImpl service;

    //@Inject
    //private PedidoServiceMongoImpl service

    @Inject
    private CamareroServiceJpaImpl camareroService;

    //@Inject
    //private CamareroServiceMongoImpl camareroService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id;
        try {
            id = Integer.valueOf(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = Integer.valueOf((String) req.getAttribute("id"));
        }

        Pedido pedido = new Pedido();
        if (id > 0) {
            Optional<Pedido> o = service.get(id);
            if (o.isPresent()) {
                pedido = o.get();
            }
        }

        if(pedido.getCamareroResponsable() == null) {
            List<Camarero> camareros = camareroService.getAll();
            req.setAttribute("camareros", camareros);
        }

        req.setAttribute("pedido", pedido);
        getServletContext().getRequestDispatcher("/gestion.jsp").forward(req, resp);

    }
}
