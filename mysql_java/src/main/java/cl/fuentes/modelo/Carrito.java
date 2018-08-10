package cl.fuentes.modelo;

public class Carrito {

	private int codproducto;
	private String producto;
	private int cantidad;
	private int precio;
	
	public Carrito() {

	}
	public Carrito(int codproducto, String producto, int cantidad, int precio) {
		super();
		this.codproducto = codproducto;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	public int getCodproducto() {
		return codproducto;
	}
	public void setCodproducto(int codproducto) {
		this.codproducto = codproducto;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
