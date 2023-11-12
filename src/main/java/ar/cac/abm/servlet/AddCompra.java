package ar.cac.abm.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.SQLException;
import ar.cac.abm.clases.Conexion;
import ar.cac.abm.clases.Compra;

/**
 * Servlet implementation class AddDest
 */

@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)

public class AddCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCompra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				
		String idJuego[] = request.getParameterValues("idJuego-txt");
		String cantidadJuego[] = request.getParameterValues("cantidadJuego-txt");
		String idCliente = request.getParameter("idCliente-txt");
		     
		
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Conexion con = new Conexion("prueba","12345","ventajuegos") ;
		
		int i = 0;
		while(i < idJuego.length) {
			
			try {
				if (0 != con.agregarCompra(new Compra( Integer.parseInt(idJuego[i]),Integer.parseInt(cantidadJuego[i]),Integer.parseInt(idCliente)))) {

					pw.println("Compra realizada");
			        
			      
				}
				else {pw.println("NO SE AGREGO");}
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
				i++;
			
		}
		
		
		pw.print("<meta http-equiv='refresh' content=5;URL='index.html'>");
	
	}

}
