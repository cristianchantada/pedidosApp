<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="layout/header.jsp" />
<h3>Listado de pedidos</h3>
<table class="table table-hover table-striped">
    <tr>
        <th>Fecha y hora entrada</th>
        <th>Estado</th>
        <th>Grupo</th>
        <th>Camarero</th>
        <th>Acción</th>
    </tr>
    <c:forEach items="${pedidos}" var="p">
    <tr>
        <td>${p.fechaHorasPedidos.fechaHoraPedido}</td>
        <td>${p.estado}</td>
        <td>${p.grupo.nombre}</td>

        <c:choose>
            <c:when test="${p.camareroResponsable == null}">
                <form action="${pageContext.request.contextPath}/pedidos" method="post">
                    <div class="row mb-2">
                        <td>
                            <select name="camarero" id="camarero" class="form-select">
                                <option value="">--- seleccionar ---</option>
                                <c:forEach items="${camareros}" var="c">
                                    <option value="${c.id}" ${g.id.equals(pedido.camarero.id)? "selected": ""}>${c.nombre}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </div>
            </c:when>
            <c:otherwise>
                <td>${p.camareroResponsable.nombre}</td>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${p.camareroResponsable == null}">
                <div class="row mb-2">
                  <div>
                    <td><input class="btn btn-sm btn-danger" type="submit" value="Gestionar"></td>
                  </div>
                </div>
                <input type="hidden" name="pedidoId" value="${p.id}">
            </form>
            </c:when>
            <c:when test="${p.estado == 'CERRADO'}">
                <td><button class="btn btn-sm btn-success" type="button" disabled>Cerrado</button></td>
            </c:when>
            <c:otherwise>
                <td><a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/gestionar-pedido?id=${p.id}">Ver pedido</a></td>
        </c:otherwise>
        </c:choose>
    </tr>
    </c:forEach>
</table>
<jsp:include page="layout/footer.jsp" />
