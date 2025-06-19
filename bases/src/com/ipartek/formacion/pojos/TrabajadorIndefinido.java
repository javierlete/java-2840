package com.ipartek.formacion.pojos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class TrabajadorIndefinido extends Trabajador {
	private BigDecimal sueldoAnual;
	private Integer numeroPagas;
	
	public TrabajadorIndefinido(String nombre, String apellidos, LocalDate fechaNacimiento, String dni, String nss,
			BigDecimal sueldoAnual, Integer numeroPagas) {
		super(nombre, apellidos, fechaNacimiento, dni, nss);
		this.sueldoAnual = sueldoAnual;
		this.numeroPagas = numeroPagas;
	}

	@Override
	public BigDecimal getSueldoMensual() {
		return sueldoAnual.divide(new BigDecimal(numeroPagas), 2, RoundingMode.HALF_UP);
	}
	
	
}
