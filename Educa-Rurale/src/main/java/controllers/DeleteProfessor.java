package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProfessorDao;

@WebServlet("/DProfessor")
public class DeleteProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteProfessor() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int professorid_pro = Integer.parseInt(request.getParameter("professorid_pro"));
		ProfessorDao.delete(professorid_pro);

		CreateAndFindProfessor createAndFindProfessor = new CreateAndFindProfessor();
		createAndFindProfessor.doGet(request, response);

	}

}
