package com.gerencia.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.Conflict;

import com.gerencia.exception.ConflictException;
import com.gerencia.model.Usuario;
import com.gerencia.repository.UsuarioRepository;
import com.gerencia.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;


	@Override
	public Usuario login(String username, String password) {
		return usuarioRepository.login(username, password);
	}
	@Override
	public Usuario registrarUsuario(Usuario usuario) {
		Usuario userexistente = usuarioRepository.consultarUsuarioByUser(usuario.getUsername());

		if (userexistente != null)
			throw new ConflictException("El usuario ya existe en la base de datos");

		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		Usuario userexistente = usuarioRepository.consultarUsuarioByUser(usuario.getUsername());

		if (userexistente == null)
			throw new ConflictException("El usuario no existe en la base de datos");

		return usuarioRepository.save(usuario);
	}

	@Override
	public void eliminarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}
}
