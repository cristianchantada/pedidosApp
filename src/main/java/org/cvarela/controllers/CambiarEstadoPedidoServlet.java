package org.cvarela.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.cvarela.models.Estado;
import org.cvarela.models.entities.sql.Pedido;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/despachar")
public class CambiarEstadoPedidoServlet extends HttpServlet {

    @Inject
    private PedidoService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer pedidoId;
        try {
            pedidoId = Integer.valueOf(req.getParameter("id"));
        } catch (NumberFormatException e) {
            pedidoId = 0;
        }

        Pedido pedido;
        if (pedidoId > 0) {
            Optional<Pedido> o = service.get(pedidoId);
            if (o.isPresent()) {
                pedido = o.get();
                pedido.setEstado(Estado.DESPACHADO);
                service.save(pedido);
            }
        }
        resp.sendRedirect(req.getContextPath() + "/gestionar-pedido?id=" + pedidoId);
    }
}
