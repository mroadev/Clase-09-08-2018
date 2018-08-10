package cl.fuentes.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cl.fuentes.db.Mysqlconn;
import cl.fuentes.querys.ClienteQuery;
import cl.fuentes.querys.ProductoQuery;
import cl.fuentes.querys.VentaQuery;
import cl.fuentes.modelo.Carrito;
import cl.fuentes.modelo.Cliente;
import cl.fuentes.modelo.Producto;
import cl.fuentes.modelo.Venta;

public class Ventagui extends JFrame{

	private Mysqlconn conn;
	private VentaQuery vq;
	private ClienteQuery cq;
	private ProductoQuery pq;
	
	JTable table;
	JScrollPane scrollPane;
	ResultSet rsGrilla;
	String txtsql = "select * from venta";
	DefaultTableModel tableModel;
	List<Carrito> carroCompra;
	
	JLabel lbCodCliente;
	JTextField txtCodCliente;
	JLabel lbCliente;
	JTextField txtCliente;
	JLabel lbTipoCliente;
	JTextField txtTipoCliente;
	JButton btnLeerCliente;
	JLabel lbCodProducto;
	JTextField txtCodProducto;
	JLabel lbCantidad;
	JTextField txtCantidad;
	JButton btnAgregarCompra;
	JLabel lbTotal;
	JTextField txtTotal;
	JButton btnGuardarVenta;
	JLabel lbTotalDescuento;
	JTextField txtTotalDescuento;
	JButton btnTotalDescuento;
	
	public Ventagui(Mysqlconn con) {
		conn = con;
		vq = new VentaQuery(conn);
		cq = new ClienteQuery(conn);
		pq = new ProductoQuery(conn);
		iniciarComponentes();
	}

	public void iniciarComponentes() {
		this.setTitle("Venta");
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setSize(550, 450);
		
		this.setResizable(false);
		
		lbCodCliente = new JLabel("Cod Cliente");
		lbCodCliente.setLocation(20, 20);
		lbCodCliente.setSize(100,20);
		
		txtCodCliente = new JTextField();
		txtCodCliente.setLocation(120, 20);
		txtCodCliente.setSize(100,20);
		
		lbCliente = new JLabel("Cliente");
		lbCliente.setLocation(20, 60);
		lbCliente.setSize(100,20);
		
		txtCliente = new JTextField();
		txtCliente.setLocation(120, 60);
		txtCliente.setSize(100,20);		
		
		lbTipoCliente = new JLabel("Tipo");
		lbTipoCliente.setLocation(20, 100);
		lbTipoCliente.setSize(100,20);
		
		txtTipoCliente = new JTextField();
		txtTipoCliente.setLocation(120, 100);
		txtTipoCliente.setSize(100,20);		
		
		btnLeerCliente = new JButton("Leer");
		btnLeerCliente.setLocation(240, 20);
		btnLeerCliente.setSize(100,20);
		btnLeerCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				leerCliente();
			}
		});
		
		lbCodProducto = new JLabel("Producto");
		lbCodProducto.setLocation(20, 130);
		lbCodProducto.setSize(100,20);
		
		txtCodProducto = new JTextField();
		txtCodProducto.setLocation(120, 130);
		txtCodProducto.setSize(100,20);		
		
		lbCantidad = new JLabel("Cantidad");
		lbCantidad.setLocation(240, 130);
		lbCantidad.setSize(100,20);
		
		txtCantidad = new JTextField();
		txtCantidad.setLocation(300, 130);
		txtCantidad.setSize(50,20);
		
		btnAgregarCompra = new JButton("Agregar Carrito");
		btnAgregarCompra.setLocation(370, 130);
		btnAgregarCompra.setSize(150,20);
		btnAgregarCompra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarCarrito();
			}
		});
		
		carroCompra = new ArrayList<Carrito>();

		//carroCompra.add(new Carrito(1, "PC", 3 ,350000));
		//carroCompra.clear();
		
		/*
		Object columnas[] = {"COD PROD","PRODUCO","CANTIDAD","PRECIO"};
		tableModel = new DefaultTableModel(columnas,0);
		for(int i=0 ; i < carroCompra.size() ; i++){
			tableModel.addRow(new Object[] {carroCompra.get(i).getCodproducto(), carroCompra.get(i).getProducto(), carroCompra.get(i).getCantidad(),carroCompra.get(i).getPrecio()});
		}
		*/

		//table = new JTable(TablemodelGrilla(carroCompra));
		table = new JTable();
		table.setModel(TablemodelGrilla(carroCompra));
		table.setSize(400, 150);
		table.setRowHeight(20);

		scrollPane = new JScrollPane();
		scrollPane.setLocation(20, 180);
		scrollPane.setSize(400, 150);
		scrollPane.setViewportView(table);
		
		lbTotal = new JLabel("Total");
		lbTotal.setLocation(100, 350);
		lbTotal.setSize(80,20);
		
		txtTotal = new JTextField();
		txtTotal.setLocation(220, 350);
		txtTotal.setSize(90,20);
		
		lbTotalDescuento = new JLabel("Total Desc");
		lbTotalDescuento.setLocation(100, 380);
		lbTotalDescuento.setSize(80,20);
		
		txtTotalDescuento= new JTextField();
		txtTotalDescuento.setLocation(220, 380);
		txtTotalDescuento.setSize(90,20);
		
		btnGuardarVenta = new JButton("Guardar");
		btnGuardarVenta.setLocation(340, 350);
		btnGuardarVenta.setSize(80,20);
		btnGuardarVenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				guardarVenta();
			}
		});
		
		
		this.add(lbCodCliente);
		this.add(lbCliente);
		this.add(lbTipoCliente);
		this.add(txtCodCliente);
		this.add(txtCliente);
		this.add(txtTipoCliente);
		this.add(btnLeerCliente);
		this.add(lbCodProducto);
		this.add(txtCodProducto);
		this.add(lbCantidad);
		this.add(txtCantidad);
		this.add(btnAgregarCompra);
		this.add(scrollPane);
		this.add(lbTotal);
		this.add(txtTotal);
		this.add(lbTotalDescuento);
		this.add(txtTotalDescuento);
		this.add(btnGuardarVenta);
	}
	
	public DefaultTableModel TablemodelGrilla(List<Carrito> cc) {
		Object columnas[] = {"COD PROD","PRODUCO","CANTIDAD","PRECIO"};
		DefaultTableModel tm = new DefaultTableModel(columnas,0);
		for(int i=0 ; i < cc.size() ; i++){
			tm.addRow(new Object[] {cc.get(i).getCodproducto(), cc.get(i).getProducto(), cc.get(i).getCantidad(), cc.get(i).getPrecio()});
		}
		return tm;
	}
	
	public void agregarCarrito() {
		//carroCompra.add(new Carrito(1, "PC", 3, 350000));
		Producto producto = pq.read(txtCodProducto.getText());
		
		Carrito carrito = new Carrito();
		carrito.setCodproducto(producto.getCodproducto());
		carrito.setProducto(producto.getProducto());
		carrito.setPrecio(producto.getPrecio());
		carrito.setCantidad(Integer.parseInt(txtCantidad.getText()));
		//carroCompra.clear();
		if(carroCompra.size()>=1) {
			JOptionPane.showMessageDialog(this,"Se permite solo una compra.","Información",JOptionPane.INFORMATION_MESSAGE);
		}else {
			int cantidad;
			int precio;
			int total;
			int totaldesc;
			
			cantidad=carrito.getCantidad();
			precio=carrito.getPrecio();
			total=cantidad*precio;
			totaldesc= 0;
			
			if (txtTipoCliente.getText().equals("vip")) {
				totaldesc= (int) (total*0.2);
				total = total - totaldesc;
			}
			txtTotal.setText(String.valueOf(total));
			txtTotalDescuento.setText(String.valueOf(totaldesc));
			
			carroCompra.add(carrito);
			table.setModel(TablemodelGrilla(carroCompra));
		}
	}
	
	public void leerCliente() {
		Cliente cliente = cq.read(txtCodCliente.getText());
		txtCliente.setText(cliente.getNombreCliente());
		txtTipoCliente.setText(cliente.getTipoCliente());
	
	}
	
	public void guardarVenta() {
		Venta venta = new Venta();
		Carrito carrito = carroCompra.get(0);
		
		venta.setFechadocumento(java.sql.Date.valueOf(LocalDate.now()));
		venta.setCantidad(carrito.getCantidad());
		venta.setCodProducto(carrito.getCodproducto());
		venta.setCodCliente(Integer.parseInt(txtCodCliente.getText()));
		venta.setTotalVenta(Integer.parseInt(txtTotal.getText()));
		int actual = vq.rebajaInventario(carrito.getCodproducto(), carrito.getCantidad());
		vq.create(venta);
		
		JOptionPane.showMessageDialog(this,"Venta Guardada","Información",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(this,"Stock Actual " + actual,"Información",JOptionPane.INFORMATION_MESSAGE);
	}
	
}
