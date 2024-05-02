<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="layout/header.jsp" />
<h3>Listado de pedidos</h3>
<c:if test="${username.present}">
   <div class="alert alert-info">Hola grupo de Macacos del Web, bienvenidos!</div>
   <a class="btn btn-primary my-2" href="${pageContext.request.contextPath}/pedidos/form">crear [+]</a>
</c:if>
<table class="table table-hover table-striped">
    <tr>
        <th>Fecha y hora entrada</th>
        <th>Estado</th>
        <th>Grupo</th>
        <th>Camarero</th>
        <th>Importe pendiente</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${pedidos}" var="p">
    <tr>
        <td>${p.fechaHoraPedido}</td>
        <td>${p.estado}</td>
        <td>${p.grupo.nombre}</td>
        <td>${p.camarero.nombre}</td>
        <td><a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/gestionar-pedido?id=${p.id}">gestionar</a></td>
    </tr>
    </c:forEach>
</table>
<jsp:include page="layout/footer.jsp" />
