<%@page contentType="text/html" pageEncoding="UTF-8" import="java.time.format.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="layout/header.jsp" />

<h3>${pedido.id!=null && pedido.id>0? "Editar pedido": "Realizar pedido"}</h3>

<form action="${pageContext.request.contextPath}/pedidos/form" method="post">
    <div class="row mb-2">
        <label for="grupo" class="col-form-label col-sm-2">Grupo</label>
        <div class="col-sm-4">
            <select name="grupo" id="grupo" class="form-select">
                <option value="">--- seleccionar ---</option>
                <c:forEach items="${grupos}" var="g">
                    <option value="${g.id}" ${g.id.equals(pedido.grupo.id)? "selected": ""}>${g.nombre}</option>
                </c:forEach>
            </select>
        </div>
        <c:if test="${errores != null && not empty errores.grupo}">
              <div style="color:red;">${errores.grupo}</div>
        </c:if>
    </div>

    <div class="row mb-2">
        <label for="alumno" class="col-form-label col-sm-2">Alumno</label>
        <div class="col-sm-4">
            <select name="alumno" id="alumno" class="form-select">
                <option value="">--- seleccionar ---</option>
                <c:forEach items="${alumnos}" var="a">
                    <option value="${a.id}" ${a.id.equals(pedido.alumno.id)? "selected": ""}>${a.nombre}</option>
                </c:forEach>
            </select>
        </div>
        <c:if test="${errores != null && not empty errores.alumno}">
              <div style="color:red;">${errores.alumno}</div>
        </c:if>
    </div>

    <div class="row mb-2">
        <label for="bar" class="col-form-label col-sm-2">Bar</label>
        <div class="col-sm-4">
            <select name="bar" id="bar" class="form-select">
                <option value="">--- seleccionar ---</option>
                <c:forEach items="${bares}" var="b">
                    <option value="${b.id}" ${b.id.equals(pedido.bar.id)? "selected": ""}>${b.nombre}</option>
                </c:forEach>
            </select>
        </div>
        <c:if test="${errores != null && not empty errores.bar}">
              <div style="color:red;">${errores.bar}</div>
        </c:if>
    </div>

    <div class="row mb-2">
        <label for="producto" class="col-form-label col-sm-2">Producto</label>
        <div class="col-sm-4">
            <select name="producto" id="producto" class="form-select">
                <option value="">--- seleccionar ---</option>
                <c:forEach items="${producto}" var="p">
                    <option value="${p.id}" ${p.id.equals(pedido.listaConsumiciones.producto.id)? "selected": ""}>${p.nombre}</option>
                </c:forEach>
            </select>
        </div>
        <c:if test="${errores != null && not empty errores.producto}">
              <div style="color:red;">${errores.producto}</div>
        </c:if>
    </div>

    <div class="row mb-2">
      <div>
         <input class="btn btn-primary" type="submit" value="${pedido.id!=null && pedido.id>0? "Editar": "Realizar pedido"}">
      </div>
    </div>
    <input type="hidden" name="id" value="${pedido.id}">
</form>

<jsp:include page="layout/footer.jsp" />
