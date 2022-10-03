package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlunoDao;
import model.Aluno;

@WebServlet("/CreateAluno")
public class CreateAndFindAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateAndFindAluno() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pesquisa = request.getParameter("pesquisa");

		if (pesquisa == null) {
			pesquisa = "";
		}

		List<Aluno> alunos = AlunoDao.find(pesquisa);

		request.setAttribute("alunos", alunos);
		RequestDispatcher requesDispatcher = request.getRequestDispatcher("lista_aluno.jsp");
		requesDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Aluno aluno = new Aluno();

		aluno.setNome(request.getParameter("nome"));
		aluno.setTelefone(request.getParameter("telefone"));
		aluno.setIdade(request.getParameter("idade"));
		aluno.setEndereco(request.getParameter("endereco"));
		aluno.setCpf(request.getParameter("cpf"));

		;

		AlunoDao.create(aluno);

		doGet(request, response);
	}

}
