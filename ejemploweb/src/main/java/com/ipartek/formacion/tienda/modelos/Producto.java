package com.ipartek.formacion.tienda.modelos;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Producto {
	private Long id;
	private String nombre;
	private BigDecimal precio;
	
	private Map<String, String> errores = new HashMap<>();

	public Producto(String id, String nombre, String precio) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
	}
	
	public Producto(Long id, String nombre, BigDecimal precio) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
	}

	public Long getId() {
		return id;
	}

	private void setId(String sId) {
		setId(sId.isBlank() ? null : Long.parseLong(sId));
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null || nombre.isBlank()) {
			errores.put("nombre", "El nombre es obligatorio");
		}

		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	private void setPrecio(String sPrecio) {
		try {
			setPrecio(new BigDecimal(sPrecio));
		} catch (NumberFormatException e) {
			errores.put("precio", "El precio no tiene el formato adecuado");
		}
	}

	public void setPrecio(BigDecimal precio) {
		if(precio == null || precio.compareTo(BigDecimal.ZERO) < 0) {
			errores.put("precio", "El precio es obligatorio y debe ser positivo");
		}
		
		this.precio = precio;
	}

	public Map<String, String> getErrores() {
		return errores;
	}

	public boolean isCorrecto() {
		return errores.size() == 0;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

}
