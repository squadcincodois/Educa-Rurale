package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProfessorDao;
import model.Professor;

@WebServlet("/AtuProfessor")
public class AtualizarProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AtualizarProfessor() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int professorid_pro = Integer.parseInt(request.getParameter("professorid_pro"));
		Professor professor = ProfessorDao.findByPk(professorid_pro);

		request.setAttribute("professor", professor);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("update_professor.jsp");
		requestDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Professor professor = new Professor();

		professor.setId_pro(Integer.parseInt(request.getParameter("id_pro")));
		professor.setNome(request.getParameter("nome"));
		professor.setTelefone(request.getParameter("telefone"));
		professor.setEmail(request.getParameter("email"));
		professor.setFormacao(request.getParameter("formacao"));
		professor.setCpf(request.getParameter("cpf"));

		ProfessorDao.update(professor);

		CreateAndFindProfessor createAndFindProfessor = new CreateAndFindProfessor();
		createAndFindProfessor.doGet(request, response);
	}

}
