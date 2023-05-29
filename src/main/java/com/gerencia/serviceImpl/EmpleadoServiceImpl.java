package com.gerencia.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.Conflict;

import com.gerencia.exception.ConflictException;
import com.gerencia.model.Empleado;
import com.gerencia.repository.EmpleadoRepository;
import com.gerencia.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	EmpleadoRepository empleadoRepository;

	@Override
	public List<Empleado> consultarEmpleados() {
		return empleadoRepository.findAll();
	}
	
	@Override
	public Empleado consultarEmpleadoPorId(Long id) {
		return empleadoRepository.findById(id).get();
	}

	@Override
	public Empleado registrarEmpleado(Empleado empleado) {
		Empleado emplexistente = empleadoRepository.consultarEmpleadoByIdent(empleado.getNumIdent());

		if (emplexistente != null)
			throw new ConflictException("El empleado ya existe en la base de datos");

		return empleadoRepository.save(empleado);
	}

	@Override
	public Empleado actualizarEmpleado(Empleado empleado) {
		Empleado emplexistente = empleadoRepository.consultarEmpleadoByIdent(empleado.getNumIdent());

		if (emplexistente == null)
			throw new ConflictException("El empleado no existe en la base de datos");

		return empleadoRepository.save(empleado);
	}

	@Override
	public void eliminarEmpleado(Long id) {
		empleadoRepository.deleteById(id);
	}
}
