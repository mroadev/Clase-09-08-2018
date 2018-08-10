package cl.fuentes.querys;

import java.sql.ResultSet;
import java.sql.SQLException;

import cl.fuentes.db.Mysqlconn;
import cl.fuentes.modelo.Cliente;
import cl.fuentes.modelo.Producto;
import cl.fuentes.modelo.Venta;

public class ClienteQuery implements Crud<Cliente>{
	
	Mysqlconn conn;
	
	public ClienteQuery(Mysqlconn con) {
		conn = con;
	}
	
	@Override
	public void create(Cliente objeto) {

	}

	@Override
	public Cliente read(String valor) {
		Cliente cliente = new Cliente();
		String txtsql ="select codCliente, nombreCliente, tipoCliente from cliente where codCliente = " + valor + "";
		try {
			ResultSet rs = conn.ejecutarQuery(txtsql);
			while (rs.next()) {
				cliente.setCodcliente(rs.getInt(1));
				cliente.setNombreCliente(rs.getString(2));
				cliente.setTipoCliente(rs.getString(3));
	        }
		} catch (SQLException e) {
			System.out.println("No es posible traer cliente");
			
		}
	   return cliente;
	}

	@Override
	public void update(Cliente objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String valor) {
		// TODO Auto-generated method stub
		
	}

}
