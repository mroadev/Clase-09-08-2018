package cl.fuentes.modelo;

import java.util.Date;

public class Venta {
	
	private int numDocumento;
	private Date fechadocumento;
	private int cantidad;
	private int codProducto;
	private int codCliente;
	private int totalVenta;

	public Venta() {
		
	}
	
	public Venta(int numDocumento, Date fechadocumento, int cantidad, int codProducto, int codCliente, int totalVenta) {
		super();
		this.numDocumento = numDocumento;
		this.fechadocumento = fechadocumento;
		this.cantidad = cantidad;
		this.codProducto = codProducto;
		this.codCliente = codCliente;
		this.totalVenta = totalVenta;
	}

	public int getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(int numDocumento) {
		this.numDocumento = numDocumento;
	}

	public Date getFechadocumento() {
		return fechadocumento;
	}

	public void setFechadocumento(Date fechadocumento) {
		this.fechadocumento = fechadocumento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public int getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(int totalVenta) {
		this.totalVenta = totalVenta;
	}
	
	
	
	

}
