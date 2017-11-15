package br.com.pcs3643.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pcs3643.dao.SellerDAO;
import br.com.pcs3643.models.Seller;

/**
 * Servlet implementation class SellerServlet
 */
@WebServlet("/SellerServlet")
public class SellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SellerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		  SellerDAO sellerDAO = new SellerDAO();
		  
		  
//		  Seller seller = new Seller();
//		  seller.setAddress("uooo");
//		  seller.setCpf("3413423");
//		  seller.setEmail("renatabbss@gmail.com");
//		  seller.setId(1);
//		  seller.setName("Renata");
//		  seller.setPassword("wweq2r23");
//		  seller.setPhone("9999");
//	
//		  sellerDAO.create(seller);
		  
		  List<Seller> sellers = sellerDAO.getAll();
		  request.setAttribute("sellers", sellers);
		  RequestDispatcher requestDispatcher = 
		      getServletContext().getRequestDispatcher("");
		  requestDispatcher.forward(request, response);
		} catch (ServletException e) {
		  e.printStackTrace();
		} catch (SQLException e) {
		  e.printStackTrace();
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
