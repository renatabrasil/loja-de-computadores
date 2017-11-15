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

import br.com.pcs3643.dao.CpuDAO;
import br.com.pcs3643.models.Cpu;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ProductServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      CpuDAO cpuDAO = new CpuDAO();
      
      Cpu cpu = new Cpu();
      
      cpu.setName("opii");
      cpu.setPrice(new Float(21.3));
      cpu.setSocket("oii");
      
      cpuDAO.create(cpu);
      
      
      List<Cpu> cpus = cpuDAO.getAll();
      request.setAttribute("cpus", cpus);
      RequestDispatcher requestDispacher =
          getServletContext().getRequestDispatcher("/app/views/products/index.jsp");
      requestDispacher.forward(request, response);
    } catch (ServletException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
