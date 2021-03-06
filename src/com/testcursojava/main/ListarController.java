package com.testcursojava.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.cursos.Curso;

/**
 * Servlet implementation class ListarController
 */
@WebServlet("/ListarController")
public class ListarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Curso c = (Curso) request.getSession().getAttribute("curso");
		String tosearch = request.getParameter("valuesearchin");
		if(tosearch==null)
			tosearch = "";
		else
			request.getSession().setAttribute("valuesearch", tosearch);
		request.setAttribute("alumnos", c.filtrar(tosearch));
		request.setAttribute("valuesearch", tosearch);
		request.getRequestDispatcher("Listar.jsp").forward(request, response);
	}

}
