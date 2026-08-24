package br.com.inventory.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import br.com.inventory.dao.EquipamentoDAO;
import br.com.inventory.dao.LaboratorioDAO;
import br.com.inventory.modelo.Equipamento;
import br.com.inventory.modelo.Laboratorio;

@WebServlet("/novoEquipamento")
public class NovoEquipamentoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        LaboratorioDAO labDao = new LaboratorioDAO();
        List<Laboratorio> laboratorios = labDao.listarTodos();

        // Se o banco H2 estiver limpo, cria laboratórios padrão automaticamente
        if (laboratorios.isEmpty()) {
            Laboratorio l1 = new Laboratorio();
            l1.setNome("Lab de Informática 01");
            l1.setBloco("A");
            labDao.salvar(l1);

            Laboratorio l2 = new Laboratorio();
            l2.setNome("Lab de Redes");
            l2.setBloco("B");
            labDao.salvar(l2);

            // Atualiza a lista com os recém-criados
            laboratorios = labDao.listarTodos();
        }

        // Passa a lista de laboratórios para a JSP
        request.setAttribute("laboratorios", laboratorios);

        // Encaminha para a tela
        request.getRequestDispatcher("/novo-equipamento.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String numeroSerie = request.getParameter("numeroSerie");
        String tipo = request.getParameter("tipo");
        String laboratorioIdStr = request.getParameter("laboratorio_id");

        Equipamento equipamento = new Equipamento();
        equipamento.setNumeroSerie(numeroSerie);
        equipamento.setTipo(tipo);

        if (laboratorioIdStr != null && !laboratorioIdStr.isEmpty()) {
            Long labId = Long.parseLong(laboratorioIdStr);
            Laboratorio lab = new Laboratorio();
            lab.setId(labId);
            equipamento.setLaboratorio(lab);
        }

        EquipamentoDAO dao = new EquipamentoDAO();
        dao.salvar(equipamento);

        // Redireciona para a tela de listagem de equipamentos
        response.sendRedirect("equipamentos");
    }
}