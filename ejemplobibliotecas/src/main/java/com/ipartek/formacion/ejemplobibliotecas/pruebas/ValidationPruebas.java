package com.ipartek.formacion.ejemplobibliotecas.pruebas;

import java.util.Set;

import com.ipartek.formacion.ejemplobibliotecas.entidades.Usuario;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ValidationPruebas {

	public static void main(String[] args) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		
		Usuario usuario = Usuario.builder().nombre("asdf").email("asd@f").password("1234").build();
		
		Set<ConstraintViolation<Usuario>> validaciones = validator.validate(usuario);
		
		for(ConstraintViolation<Usuario> validacion: validaciones) {
			System.out.println(validacion.getPropertyPath() + ": " + validacion.getMessage());
		}
	}

}
