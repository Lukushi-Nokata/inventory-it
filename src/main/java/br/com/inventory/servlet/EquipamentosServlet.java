package br.com.inventory.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import br.com.inventory.dao.EquipamentoDAO;
import br.com.inventory.modelo.Equipamento;

@WebServlet("/equipamentos")
public class EquipamentosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        EquipamentoDAO dao = new EquipamentoDAO();
        List<Equipamento> lista = dao.listarTodos();
        
        request.setAttribute("equipamentos", lista);
        request.getRequestDispatcher("/equipamentos.jsp").forward(request, response);
    }
}