package cl.fuentes.tool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Configfile {
	
	Properties prop = new Properties();
	OutputStream output = null;
	InputStream input = null;
	
	public void guardarConfig(String parNombre, String parValor) {
		
		try {
			output = new FileOutputStream("config.properties");
			prop.setProperty(parNombre, parValor);
			prop.store(output, null);
			
		} catch (FileNotFoundException e) {
			System.out.println("No se puede guardar config");
		} catch (IOException e) {
			System.out.println("No se puede guardar config");
		}finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String leerConfig(String parNombre) {
		String valor="";
		try {
			input = new FileInputStream("config.properties");
			prop.load(input);
			valor = prop.getProperty(parNombre);
		} catch (FileNotFoundException e) {
			System.out.println("No se puede cargar config");
			
		} catch (IOException e) {
			System.out.println("No se puede cargar config");
		}finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return valor;
	}
}
