package br.com.pcs3643.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pcs3643.config.Parameters;
import br.com.pcs3643.dao.ClienteDAO;
import br.com.pcs3643.dao.VendedorDAO;
import br.com.pcs3643.models.Cliente;
import br.com.pcs3643.models.Cliente2;
import br.com.pcs3643.models.Vendedor;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/clients")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String index = "/app/views/clients/index.jsp";
	private final String form = "/app/views/clients/form.jsp";
	private final String list = "/app/views/clients/list.jsp";
	private final String show = "/app/views/clients/show.jsp";
	
	private int id;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	super.service(request, response);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") == null ? "" : ((String) request.getParameter("action"));
		action = action.isEmpty() && request.getAttribute("action") != null ? (String) request.getAttribute("action") : action;
		String page = "/app/views/index.jsp";
		
		id = request.getParameter("id") == null ? 0 : Integer.parseInt(request.getParameter("id")); 
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Cliente cliente2 = new Cliente();
		
		cliente2.setAniversario(new Date());
		cliente2.setCelular("99999");
		cliente2.setCpf(2323.3);
		cliente2.setEmail("sdads@gmail.com");
		cliente2.setEndereco("avvv");
		cliente2.setNome("renata");
		
		clienteDAO.insertCliente(cliente2);
		
		switch (action) {
		case Parameters.CRUD_OPERATIONS.CREATE:
			Cliente cliente = new Cliente();
			
			
			request.setAttribute("cliente", cliente);
			
			page = form;
			break;
		case Parameters.CRUD_OPERATIONS.ALL:
			List<Cliente> clientes;
			
			
//				clienteDAO.findByCPF(212);
			
				
			
			page = list;
			
			break;
		case Parameters.CRUD_OPERATIONS.READ:
			VendedorDAO dao = new VendedorDAO();
//				cliente = clienteDAO.read(id);
//				request.setAttribute("cliente", cliente);
			
			page = show;
			
			break;
			
		default:
			break;
		}
		
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(page);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String telefone = request.getParameter("telefone");
		
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
//		cliente.setCPF(cpf);
//		cliente.setEmail(email);
		cliente.setEndereco(endereco);
//		cliente.setTelefone(telefone);
		
//		Map<String, String> messages = validate(cliente);
		
//		request.setAttribute("mensagens", messages);
		request.setAttribute("client", cliente);
		ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.insertCliente(cliente);
			
//				messages.put(HttpServletResponse.SC_OK+"", Parameters.VALIDATION_MESSAGES.SUCCESS);
			
			request.setAttribute("action", Parameters.CRUD_OPERATIONS.ALL);
			doGet(request, response);
		
		
	}
	
	protected Map<String, String> validate(Cliente2 cliente)
	{
		Map<String, String> messages = new HashMap<String, String>();
		
		if (cliente.getCPF().trim().isEmpty())
			messages.put("CPF", Parameters.VALIDATION_MESSAGES.BLANK_FIELD);
		if (cliente.getEmail().trim().isEmpty())
			messages.put("E-mail", Parameters.VALIDATION_MESSAGES.BLANK_FIELD);
		if (cliente.getEndereco().trim().isEmpty())
			messages.put("Endere�o", Parameters.VALIDATION_MESSAGES.BLANK_FIELD);
		if (cliente.getNome().trim().isEmpty())
			messages.put("Nome", Parameters.VALIDATION_MESSAGES.BLANK_FIELD);
		if (cliente.getTelefone().trim().isEmpty())
			messages.put("Telefone", Parameters.VALIDATION_MESSAGES.BLANK_FIELD);
		
		return messages;
	}

}
