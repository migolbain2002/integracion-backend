package com.gerencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerencia.model.Empleado;
import com.gerencia.model.Usuario;
import com.gerencia.service.EmpleadoService;
import com.gerencia.service.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

	@Autowired
	EmpleadoService empleadoService;
	
	@Autowired
	UsuarioService usuarioService;

	@GetMapping("/consultarEmpleados")
	public ResponseEntity<?> consultarEmpleados() {
		return ResponseEntity.ok(empleadoService.consultarEmpleados());
	}

	@GetMapping("/consultarEmpleadoPorId/{id}")
	public ResponseEntity<?> consultarEmpleadoPorId(@PathVariable Long id) {
		return ResponseEntity.ok(empleadoService.consultarEmpleadoPorId(id));
	}

	
	@PostMapping("/registrarEmpleadoYUsuario")
	public ResponseEntity<Empleado> registrarEmpleadoyUsuario(@RequestBody Empleado empleado) {
		Usuario usuarioR = usuarioService.registrarUsuario(empleado.getIdUsuario());
		empleado.getIdUsuario().setIdUsuario(usuarioR.getIdUsuario());
		Empleado empleadoR = empleadoService.registrarEmpleado(empleado);

		return ResponseEntity.status(HttpStatus.CREATED).body(empleadoR);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<Empleado> registrarEmpleado(@RequestBody Empleado empleado) {
		return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.registrarEmpleado(empleado));
	}

	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizarEmpleado(@RequestBody Empleado empleado) {
		return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.actualizarEmpleado(empleado));
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarEmpleado(@PathVariable Long id) {
		empleadoService.eliminarEmpleado(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
