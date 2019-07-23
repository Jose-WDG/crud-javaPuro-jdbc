package br.com.ecommerce.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class listaProdutosServelet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2610505477639995129L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			PrintWriter out = resp.getWriter();
			
		
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Bem vindo ao ser servidorzinho</h1>");	
			out.println("</body>");
			out.println("</html>");
	}

}
