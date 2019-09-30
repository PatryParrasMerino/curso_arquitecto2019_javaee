package beans;

public class Producto {
	private String nombre;
	private double precio;
	private int unidades;
	public Producto(String nombre, double precio, int unidades) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.unidades = unidades;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

}
