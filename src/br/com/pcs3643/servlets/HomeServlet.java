package br.com.pcs3643.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pcs3643.dao.ClienteDAO;
import br.com.pcs3643.dao.ProdutoDAO;
import br.com.pcs3643.dao.VendedorDAO;
import br.com.pcs3643.models.Cliente;
import br.com.pcs3643.models.Produto;
import br.com.pcs3643.models.Vendedor;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet(urlPatterns = { "/" }, initParams = {@WebInitParam(name = "primeiraServlet", value = "")
		})
public class HomeServlet extends HttpServlet {
	
	private String index = "/app/views/index.jsp";
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		VendedorDAO vendedorDAO = new VendedorDAO();
		
//		Vendedor vendedor = new Vendedor();
//		vendedor.setId(2);
		
		
		try {
			vendedorDAO.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(index);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
