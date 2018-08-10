package cl.fuentes.modelo;

public class Producto {
	private int codproducto;
	private String producto;
	private int precio;
	private int stock;
	
	public Producto() {
		
	}
	
	public Producto(int codproducto, String producto, int precio, int stock) {
		super();
		this.codproducto = codproducto;
		this.producto = producto;
		this.precio = precio;
		this.stock = stock;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
	
}
