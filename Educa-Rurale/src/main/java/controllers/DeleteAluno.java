package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlunoDao;

@WebServlet("/DAluno")
public class DeleteAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteAluno() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int alunoid = Integer.parseInt(request.getParameter("alunoid"));
		AlunoDao.delete(alunoid);

		CreateAndFindAluno createAndFindAluno = new CreateAndFindAluno();
		createAndFindAluno.doGet(request, response);

	}

}
