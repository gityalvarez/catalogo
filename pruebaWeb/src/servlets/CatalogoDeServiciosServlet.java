package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.interfaces.BeanTestRemote;

/**
 * Servlet implementation class CatalogoDeServiciosServlet
 */
@WebServlet("/CatalogoDeServiciosServlet")
public class CatalogoDeServiciosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB private BeanTestRemote bean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogoDeServiciosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("lstServicios", this.bean.obtenerServicios());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
