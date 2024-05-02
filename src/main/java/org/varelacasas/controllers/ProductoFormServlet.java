package org.varelacasas.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.varelacasas.models.entities.*;
import org.varelacasas.services.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@WebServlet("/pedidos/form")
public class ProductoFormServlet extends HttpServlet {

    @Inject
    private PedidoService pedidoService;
    @Inject
    private AlumnoService alumnoService;
    @Inject
    private BarService barService;
    @Inject
    private GrupoService grupoService;
    @Inject
    private ProductoService productoService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e){
            id = 0;
        }

        Pedido pedido = new Pedido();
        if (id > 0) {
            Optional<Pedido> o = pedidoService.get(id);
            if (o.isPresent()) {
                pedido = o.get();
            }
        }

        List<Alumno> alumnos = alumnoService.getAll();
        List<Bar> bares = barService.getAll();
        List<Grupo> grupos = grupoService.getAll();
        List<Producto> productos = productoService.getAll();

        req.setAttribute("pedido", pedido);
        req.setAttribute("grupos", grupos);
        req.setAttribute("alumnos", alumnos);
        req.setAttribute("bares", bares);
        req.setAttribute("productos", productos);

        getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer grupoId;
        try {
            grupoId = Integer.valueOf(req.getParameter("grupo"));
        } catch (NumberFormatException e){
            grupoId = 0;
        }

        Integer alumnoId;
        try {
            alumnoId = Integer.valueOf(req.getParameter("alumno"));
        } catch (NumberFormatException e){
            alumnoId = 0;
        }

        Integer barId;
        try {
            barId = Integer.valueOf(req.getParameter("bar"));
        } catch (NumberFormatException e){
            barId = 0;
        }

        Integer productoId;
        try {
            productoId = Integer.valueOf(req.getParameter("producto"));
        } catch (NumberFormatException e){
            productoId = 0;
        }

        Map<String, String> errores = new HashMap<>();

        if (grupoId.equals(0)){
            errores.put("grupo", "el grupo es requerido!");
        }

        if (alumnoId.equals(0)){
            errores.put("alumno", "el alumno es requerido!");
        }

        if (barId.equals(0)){
            errores.put("bar", "el bar es requerido!");
        }

        if (productoId.equals(0)){
            errores.put("grupo", "el producto es requerido!");
        }

        Integer id;
        try {
            id = Integer.valueOf(req.getParameter("id"));
        } catch (NumberFormatException e){
            id = null;
        }

        Pedido pedido = new Pedido();
        pedido.setId(id);

        Grupo grupo = new Grupo();
        grupo.setId(grupoId);
        pedido.setGrupo(grupo);

        Bar bar = new Bar();
        bar.setId(barId);
        pedido.setBar(bar);

        Consumicion consumicion = new Consumicion();

        Alumno alumno = new Alumno();
        alumno.setId(alumnoId);
        consumicion.setAlumno(alumno);

        Producto producto = new Producto();
        producto.setId(productoId);
        consumicion.setProducto(producto);

        pedido.setListaConsumiciones();


        if (errores.isEmpty()) {
            pedidoService.save(pedido);
            resp.sendRedirect(req.getContextPath() + "/pedidos");
        } else {
            req.setAttribute("errores", errores);
            req.setAttribute("grupos", grupoService.getAll());
            req.setAttribute("alumnos", grupoService.getAll());
            req.setAttribute("bares", grupoService.getAll());
            req.setAttribute("productos", grupoService.getAll());
            req.setAttribute("pedido", pedido);
            getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
        }
    }
}
