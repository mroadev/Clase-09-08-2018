package cl.fuentes.app;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cl.fuentes.modelo.Usuario;

public class Mapa {
	
    public static void main( String[] args ){
    	List<Usuario> listausuario = new ArrayList<Usuario>();
    	
    	listausuario.add(new Usuario(1,"admin","1234","Administrador","Vip","V"));
    	
    	HashMap hm1 = new HashMap();
    	
    	hm1.put("3", "30");
    	hm1.put("2", "15");
    	hm1.put("5", "25");
    	hm1.put("7", "24");
    	hm1.put("1", "35");
    	System.out.println(hm1);
    	
    	HashMap<Integer,String> hm2 = new HashMap<Integer,String>();
    	hm2.put(4, "Carlos");
    	hm2.put(3, "Maria");
    	hm2.put(2, "Eduardo");
    	hm2.put(1, "Camila");
    	System.out.println(hm2);
    	
    	
    }
}
