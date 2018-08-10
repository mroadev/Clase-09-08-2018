package cl.fuentes.app;

import cl.fuentes.db.Mysqlconn;
import cl.fuentes.tool.Configfile;
import cl.fuentes.view.Login;


// Proyecto para la clase de Java Básico
// Por Alvaro Fuentes P.
// Email: alvarofue@gmail.com

public class App{
	
	private Mysqlconn con;
	
	public App() {
    	Configfile cf = new Configfile();
		con = new Mysqlconn(cf.leerConfig("server"), cf.leerConfig("basedatos"), cf.leerConfig("usuario"), cf.leerConfig("password"));
		//cf = null;
		try {
			con.open();
		} catch (Exception e) {
			System.out.println("No se ha establecido la conexión a la db");
		}
	}
	
    public void iniciar(){
    	/*
    	Configfile cf = new Configfile();
    	cf.guardarConfig("server", "localhost");
    	cf.guardarConfig("basedatos", "ventas");
    	cf.guardarConfig("usuario", "usuventas");
    	cf.guardarConfig("password", "passventas");
    	*/
    	Login login = new Login(con);
    	login.setVisible(true);
    }

    public static void main( String[] args ){
    	App app = new App();
    	app.iniciar();
    }

}
