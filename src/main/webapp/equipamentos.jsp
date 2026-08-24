<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Equipamentos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light p-4">
    <div class="container bg-white p-4 rounded shadow">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2>Equipamentos Cadastrados</h2>
            <a href="novoEquipamento" class="btn btn-primary">+ Novo Equipamento</a>
        </div>

        <table class="table table-striped table-hover">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Nº de Série</th>
                    <th>Tipo</th>
                    <th>Laboratório Alocado</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${equipamentos}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.numeroSerie}</td>
                        <td>${item.tipo}</td>
                        <td>
                            <c:choose>
                                <c:when test="${not empty item.laboratorio}">
                                    ${item.laboratorio.nome} (Bloco ${item.laboratorio.bloco})
                                </c:when>
                                <c:otherwise>
                                    <span class="badge bg-secondary">Não alocado</span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>