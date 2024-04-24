package org.varelacasas.mongo.servlets;

import org.varelacasas.mongo.controllers.DaoInterface;
import org.varelacasas.mongo.controllers.PedidoDao;
import org.varelacasas.mongo.models.pedido;

import jakarta.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    PedidoDao pedidoDao = new PedidoDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<pedido> pedidosLista = pedidoDao.getAll();
        System.out.println("pedidosLista = " + pedidosLista);
        resp.getWriter().println(pedidosLista);

        req.setAttribute("pedidosLista", pedidosLista);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
