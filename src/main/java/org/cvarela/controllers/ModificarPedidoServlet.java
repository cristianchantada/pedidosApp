package org.cvarela.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.cvarela.models.Estado;
import org.cvarela.models.entities.sql.Pedido;
import org.cvarela.services.jpaImpls.PedidoServiceJpaImpl;
import org.cvarela.services.mongoImpls.PedidoServiceMongoImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/modificar")
public class ModificarPedidoServlet extends HttpServlet {

    @Inject
    private PedidoServiceJpaImpl service;

    //@Inject
    //private PedidoServiceMongoImpl service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Pedido> pedidos = service.getAll();

        pedidos = pedidos.stream().filter(p -> p.getEstado() != null && p.getEstado().equals(Estado.EN_COLA)).toList();

        req.setAttribute("pedidos", pedidos);
        getServletContext().getRequestDispatcher("/modificacion.jsp").forward(req, resp);

    }


}
