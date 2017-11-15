package br.com.pcs3643.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pcs3643.dao.PedidoDAO;
import br.com.pcs3643.models.Pedido;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/pedido")
public class ControllerPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PedidoDAO pedidoDAO = new PedidoDAO();
			
//			Pedido pedido = new Pedido();
//			
//			pedido.setDesconto(23.5);
//			pedido.setPreco(1220.0);
//			pedido.setTimestamp(new Timestamp(new Long(1212122)));
//			
//			pedidoDAO.create(pedido);
			
			List<Pedido> listaDePedidos = pedidoDAO.getAll();

			if(request.getParameter("id") == null){
				request.setAttribute("lista", listaDePedidos);
				RequestDispatcher requestDispatcher = 
				   getServletContext().getRequestDispatcher("/lista.jsp");
				requestDispatcher.forward(request, response);
			}
			else{
				Pedido p = listaDePedidos.get(Integer.parseInt(request.getParameter("id")) - 1);
				request.setAttribute("pedido", p);
			
				RequestDispatcher requestDispatcher = 
				   getServletContext().getRequestDispatcher("/detalhe.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			RequestDispatcher requestDispatcher = 
					   getServletContext().getRequestDispatcher("/lista.jsp");
					requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
