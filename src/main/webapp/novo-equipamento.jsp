<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Novo Equipamento</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light p-5">
    <div class="container bg-white p-4 rounded shadow">
        <h2>Cadastrar Equipamento</h2>
        <hr>
        <form action="novoEquipamento" method="post" class="mb-4">
            <div class="mb-3">
                <label class="form-label">Número de Série</label>
                <input type="text" name="numeroSerie" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Tipo (Ex: PC, Projetor)</label>
                <input type="text" name="tipo" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Laboratório Alocado</label>
                <select name="laboratorio_id" class="form-select" required>
                    <option value="">Selecione...</option>
                    <c:forEach items="${laboratorios}" var="lab">
                        <option value="${lab.id}">${lab.nome} - Bloco ${lab.bloco}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-success">Salvar Equipamento</button>
            <a href="index.jsp" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
</body>
</html>