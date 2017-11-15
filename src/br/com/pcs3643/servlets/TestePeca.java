package br.com.pcs3643.servlets;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pcs3643.dao.PecaDAO;
import br.com.pcs3643.models.Peca;

public class TestePeca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PecaDAO pecaDAO = new PecaDAO();
		List<Peca> pecas = new ArrayList<>();
		pecas.add(new Peca(0,"I7", "processador", "", 700.00));
		pecas.add(new Peca(0,"Balistic 8GB", "memoria", "", 400.00));
		pecas.add(new Peca(0,"GTX 780", "placa video", "", 500.00));
		pecas.add(new Peca(0,"HD Seagate 1 TB", "HD", "", 200.00));
//		for (Peca peca : pecas ) {
//			try {
//				pecaDAO.createPeca(peca);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		try {
			pecaDAO.getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
