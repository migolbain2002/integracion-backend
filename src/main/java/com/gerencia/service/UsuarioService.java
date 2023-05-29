package com.gerencia.service;

import java.util.List;

import com.gerencia.model.Empleado;
import com.gerencia.model.Usuario;

public interface UsuarioService {
	
	void eliminarUsuario(Long id);

	Usuario actualizarUsuario(Usuario usuario);

	Usuario registrarUsuario(Usuario usuario);
	
	Usuario login(String username, String password);
}
