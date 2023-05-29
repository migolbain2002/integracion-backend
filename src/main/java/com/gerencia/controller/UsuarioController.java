package com.gerencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gerencia.model.Usuario;
import com.gerencia.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/login")
	public ResponseEntity<Boolean> login(@RequestParam(name = "username", required = true) String username, @RequestParam(name = "password", required = true) String password){	
		if(usuarioService.login(username, password) != null)
			return ResponseEntity.ok(true);
		else
			return ResponseEntity.ok(false);
			
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.registrarUsuario(usuario));
	}

	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizarEmpleado(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.actualizarUsuario(usuario));
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarEmpleado(@PathVariable Long id) {
		usuarioService.eliminarUsuario(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
