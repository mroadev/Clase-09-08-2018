package cl.fuentes.querys;

import java.sql.ResultSet;
import java.sql.SQLException;

import cl.fuentes.db.Mysqlconn;
import cl.fuentes.modelo.Venta;

public class VentaQuery implements Crud<Venta> {

	Mysqlconn conn;
	
	public VentaQuery(Mysqlconn con) {
		conn = con;
	}
	
	
	@Override
	public void create(Venta objeto) {
		String txtsql ="INSERT INTO venta (fechadocumento,"
				+ "cantidad,codproducto,codcliente,totalventa) VALUES ("
				+ "'"+objeto.getFechadocumento()
				+"',"+objeto.getCantidad()
				+","+objeto.getCodProducto()
				+","+objeto.getCodCliente()
				+","+objeto.getTotalVenta()+")";
		
		
		try {
			conn.ejecutarUpdate(txtsql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo registrar la venta|");
		}
		
	}
	
	public int rebajaInventario(int codProducto, int cantidad) {
		int actual = 0;
		String txtsql1 = "update producto set stock= (stock - " + cantidad + ") where codproducto = " + codProducto;
		String txtsql2 = "select stock from producto where codproducto = " + codProducto;
		ResultSet rs;
		
		try {
			conn.ejecutarUpdate(txtsql1);
			
			rs = conn.ejecutarQuery(txtsql2);
			while(rs.next()) {
				actual = rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public Venta read(String valor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Venta objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String valor) {
		// TODO Auto-generated method stub
		
	}

	
	
}
