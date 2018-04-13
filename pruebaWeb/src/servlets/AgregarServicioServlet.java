package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.interfaces.BeanTestRemote;

/**
 * Servlet implementation class AgregarServicioServlet
 */
@WebServlet("/AgregarServicioServlet")
public class AgregarServicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB private BeanTestRemote bean; 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarServicioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombreOrganizacion = request.getParameter("nombreOrganizacion");
		String idServicio = request.getParameter("idServicio");
		String descripcionServicio = request.getParameter("descripcion");
		String wsdlServicio = request.getParameter("wsdl");
		String disponibilidadServicio = request.getParameter("disponibilidad");
		if(bean.agregarServicio(nombreOrganizacion, idServicio, descripcionServicio, wsdlServicio, disponibilidadServicio)) {
			request.setAttribute("mensaje", "El servicio ha sido de alta satisfactoriamente");
		}else {
			request.setAttribute("mensaje", "ERROR: El servicio no se pudo agregar");
		}
		request.getRequestDispatcher("redirect.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
