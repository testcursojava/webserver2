package com.testcursojava.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.cursos.Curso;

/**
 * Servlet implementation class RemoveController
 */
@WebServlet("/RemoveController")
public class RemoveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Curso c = (Curso) request.getSession().getAttribute("curso");
		c.borrarAlumno(request.getParameter("nif"));
		response.sendRedirect("ListarController");
	}

}
