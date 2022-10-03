package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlunoDao;
import model.Aluno;

@WebServlet("/AAluno")
public class AtualizarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AtualizarAluno() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int alunoid = Integer.parseInt(request.getParameter("alunoid"));
		Aluno aluno = AlunoDao.findByPk(alunoid);

		request.setAttribute("aluno", aluno);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("update_aluno.jsp");
		requestDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Aluno aluno = new Aluno();

		aluno.setId(Integer.parseInt(request.getParameter("id")));
		aluno.setNome(request.getParameter("nome"));
		aluno.setTelefone(request.getParameter("telefone"));
		aluno.setIdade(request.getParameter("idade"));
		aluno.setEndereco(request.getParameter("endereco"));
		aluno.setCpf(request.getParameter("cpf"));

		AlunoDao.update(aluno);

		CreateAndFindAluno createAndFindAluno = new CreateAndFindAluno();
		createAndFindAluno.doGet(request, response);
	}

}
