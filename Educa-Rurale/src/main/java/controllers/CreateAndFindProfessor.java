package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProfessorDao;
import model.Professor;

@WebServlet("/CreateProfessor")
public class CreateAndFindProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateAndFindProfessor() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pesquisa = request.getParameter("pesquisa");

		if (pesquisa == null) {
			pesquisa = "";
		}

		List<Professor> professores = ProfessorDao.find(pesquisa);

		request.setAttribute("professores", professores);
		RequestDispatcher requesDispatcher = request.getRequestDispatcher("lista_professor.jsp");
		requesDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Professor professor = new Professor();

		professor.setNome(request.getParameter("nome"));
		professor.setTelefone(request.getParameter("telefone"));
		professor.setEmail(request.getParameter("email"));
		professor.setFormacao(request.getParameter("formacao"));
		professor.setCpf(request.getParameter("cpf"));

		;

		ProfessorDao.create(professor);

		doGet(request, response);
	}

}
