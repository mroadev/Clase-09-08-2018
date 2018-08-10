package cl.fuentes.modelo;

public class Cliente {

	private int codcliente;
	private String nombreCliente;
	private String tipoCliente;
	
	public Cliente() {
		
	}
	
	public Cliente(int codcliente, String nombreCliente, String tipoCliente) {
		super();
		this.codcliente = codcliente;
		this.nombreCliente = nombreCliente;
		this.tipoCliente = tipoCliente;
	}

	public int getCodcliente() {
		return codcliente;
	}

	public void setCodcliente(int codcliente) {
		this.codcliente = codcliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
	
	
}
