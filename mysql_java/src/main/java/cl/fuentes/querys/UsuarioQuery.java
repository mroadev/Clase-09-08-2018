package cl.fuentes.querys;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.org.apache.xpath.internal.axes.OneStepIterator;

import cl.fuentes.db.Mysqlconn;
import cl.fuentes.modelo.Usuario;

public class UsuarioQuery implements Crud<Usuario>{

	private Mysqlconn conn;
	
	public UsuarioQuery(Mysqlconn con){
		this.conn = con;
	}
	
	@Override
	public void create(Usuario objeto) {
		// insert into usuario values ('admin','1234','Administrador');
		try {
			conn.ejecutarUpdate("insert into usuario"
					+ " (usuario, clave, nombre,"
					+ " tipousuario, estado)"
					+ " values ('" 
					+ objeto.getUsuario() 
					+ "','" + objeto.getClave()
					+"','"+objeto.getNombre() + "','"
					+ objeto.getTipousuario()+"','V');");
			//con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Usuario read(String valor) {
		// select * from usuario where usuario = 'pamela';
		Usuario usuario = new Usuario();
		try {
			ResultSet rs = conn.ejecutarQuery("select * from usuario"
					+ " where usuario = '"
					+ valor +"'");
			while (rs.next()) {
				usuario.setIdusuario(rs.getInt(1));
				usuario.setUsuario(rs.getString(2));
				usuario.setClave(rs.getString(3));
				usuario.setNombre(rs.getString(4));
				usuario.setTipousuario(rs.getString(5));
				usuario.setEstado(rs.getString(6));
				
	        }
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
			return usuario;
	}

	@Override
	public void update(Usuario objeto) {
		// update usuario set clave = '1234' where usuario = 'pamela';
		// update usuario set clave = '1234', tipousuario = 'Operador' where usuario = 'vendedor';
		String txtsql = "update usuario set clave = '" 
				+ objeto.getClave() 
				+ "', nombre = '"
				+ objeto.getNombre()  
				+ "', tipousuario = '" 
				+ objeto.getTipousuario() 
				+ "' where usuario = '" 
				+ objeto.getUsuario() + "'"; 
				
		
		try {
			conn.ejecutarUpdate(txtsql);
			//System.out.println("tipo : " + objeto.getTipousuario());
			System.out.println(txtsql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void delete(String valor) {
		// 
		try {
			//con.ejecutarUpdate("delete from usuario where usuario = '"+ valor +"'");
			String txt = "update usuario set estado = 'N' where usuario ='" + valor + "'";
			conn.ejecutarUpdate(txt);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
