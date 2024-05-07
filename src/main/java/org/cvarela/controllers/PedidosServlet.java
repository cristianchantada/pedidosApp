package org.cvarela.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.cvarela.models.Estado;
import org.cvarela.models.entities.sql.Camarero;
import org.cvarela.models.entities.sql.Pedido;
import org.cvarela.services.ServiceInterface;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/pedidos")
public class PedidosServlet extends HttpServlet {

    @Inject
    private ServiceInterface<> service;

    @Inject
    private ServiceInterface<> camareroService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Pedido> pedidos = service.getAll();
        List<Camarero> camareros = camareroService.getAll();

        req.setAttribute("camareros", camareros);
        req.setAttribute("pedidos", pedidos);
        getServletContext().getRequestDispatcher("/pedidos.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer pedidoId;
        try {
            pedidoId = Integer.valueOf(req.getParameter("pedidoId"));
        } catch (NumberFormatException e) {
            pedidoId = 0;
        }

        Integer camareroId;
        try {
            camareroId = Integer.valueOf(req.getParameter("camarero"));
        } catch (NumberFormatException e) {
            camareroId = 0;
        }

        Pedido pedido = new Pedido();
        if (pedidoId > 0) {
            Optional<Pedido> o = service.get(pedidoId);
            if (o.isPresent()) {
                pedido = o.get();
            }
        }

        Camarero camarero = new Camarero();
        if (camareroId > 0) {
            Optional<Camarero> o = camareroService.get(camareroId);
            if (o.isPresent()) {
                camarero = o.get();
                pedido.setCamareroResponsable(camarero);
                pedido.setEstado(Estado.EN_PROCESO);
                service.save(pedido);
            }
        }


        pedido.setCamareroResponsable(camarero);

        resp.sendRedirect(req.getContextPath() + "/gestionar-pedido?id=" + pedido.getId());


    }
}
