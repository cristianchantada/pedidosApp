<%@page contentType="text/html" pageEncoding="UTF-8" import="java.time.format.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="layout/header.jsp" />

<h3>${title}</h3>
<h4>Pedidos del bar ${pedido.bar.nombre}</h4>
<table class="table table-hover table-striped">
    <thead>
        <tr>
            <th colspan="2">Pedido nº ${pedido.id}</th
        </tr>
        <tr>
            <th>Fecha y hora:</th>
            <td>${pedido.fechaHorasPedidos.fechaHoraPedido}</td>
        </tr>
        <tr>
            <th>Estado</th>
            <td>${pedido.estado}</td>
        </tr>
        <tr>
            <th>Camarero</th>
            <td>${pedido.camareroResponsable.nombre}</td>
        </tr>
        <tr>
            <th>Grupo</th>
            <td>${pedido.grupo.nombre}</td>
        </tr>
        <tr>
            <th>Estado de cobro</th>
            <td>${pedido.estadoCobro}</td>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${pedido.listaConsumiciones}" var="c">
            <tr rowspan="2">
                <th colspan="2">Consumición Id: ${c.id}</th>
            </tr>
            <tr>
                <th>Alumno</th>
                <td>${c.alumno.nombre} ${c.alumno.apellido}</td>
            </tr>
            <tr>
                <th>Producto</th>
                <td>${c.producto.nombreProducto}</td>
            </tr>
            <tr>
                <th>Precio</th>
                <td>${c.producto.precio} €</td>
            </tr>
            <tr>
                <th>Estado de cobro</th>
                <td>${c.estadoCobroConsumicion}</td>
            </tr>
            <tr>
                <td colspan="2" ><a class="btn btn-sm btn-success" href="${pageContext.request.contextPath}/cobrar-consumicion?id=${pedido.id}&consumicion-id=${c.id}">Cobrar consunición</a></td>
            </tr>
        </c:forEach>
    </tbody>
    <tfooter>
        <tr>
            <th colspan="2">Cambiar estado</th>
        </tr>
        <tr>
            <td><a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/despachar?id=${pedido.id}">Despachado</a></td>
        </tr>
    </tfooter>
</table>

<jsp:include page="layout/footer.jsp" />