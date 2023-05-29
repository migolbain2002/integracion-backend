package com.gerencia.service;

import java.util.List;

import com.gerencia.model.Empleado;

public interface EmpleadoService {
	
	Empleado registrarEmpleado(Empleado empleado);

	List<Empleado> consultarEmpleados();

	Empleado actualizarEmpleado(Empleado empleado);

	void eliminarEmpleado(Long id);

	Empleado consultarEmpleadoPorId(Long id);
}
