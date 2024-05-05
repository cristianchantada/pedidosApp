<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="layout/header.jsp" />
<h3>Modificar pedido</h3>
<table class="table table-hover table-striped">
    <tr>
        <th>Fecha y hora entrada</th>
        <th>Bar</th>
        <th>Estado</th>
        <th>Grupo</th>
        <th>Selecciona</th>
    </tr>
    <c:forEach items="${pedidos}" var="p">
        <tr>
            <td>${p.fechaHorasPedidos.fechaHoraPedido}</td>
            <td>${p.bar.nombre}</td>
            <td>${p.estado}</td>
            <td>${p.grupo.nombre}</td>
            <td><a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/form?id=${p.id}">Modificar</a></td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="layout/footer.jsp" />
