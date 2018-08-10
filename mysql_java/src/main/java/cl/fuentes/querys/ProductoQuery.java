package cl.fuentes.querys;

import java.sql.ResultSet;
import java.sql.SQLException;

import cl.fuentes.db.Mysqlconn;
import cl.fuentes.modelo.Producto;

public class ProductoQuery implements Crud<Producto>{

    private Mysqlconn con;
	
	public ProductoQuery(Mysqlconn con){
		this.con = con;
	}
	
	@Override
	public void create(Producto objeto) {
		String txtsql = "insert into producto"
				+ " (producto, precio, stock) values"
				+ " ('"+objeto.getProducto()+"',"+objeto.getPrecio()+","+objeto.getStock()+")";
		try {
			con.ejecutarUpdate(txtsql);
			//con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Producto read(String valor) {
		Producto producto = new Producto();
		String txtsql ="select codproducto, producto, precio, stock from producto where producto = '" + valor + "'";
		try {
			ResultSet rs = con.ejecutarQuery(txtsql);
			while (rs.next()) {
				producto.setCodproducto(rs.getInt(1));
				producto.setProducto(rs.getString(2));
				producto.setPrecio(rs.getInt(3));
				producto.setStock(rs.getInt(4));
	        }
		} catch (SQLException e) {
			System.out.println("No es posible traer producto");
			
		}
	   return producto;
	}

	@Override
	public void update(Producto objeto) {
		String txtsql = "update producto set precio = "
				+ objeto.getPrecio() 
				+ ", stock = "
				+ objeto.getStock()
				+ " where producto ='" 
				+ objeto.getProducto() + "'";
		try {
			con.ejecutarUpdate(txtsql);
		} catch (SQLException e) {
			System.out.println("No se puede actualizar producto");
		}
	}

	@Override
	public void delete(String valor) {
		// TODO Auto-generated method stub
		
	}

}
