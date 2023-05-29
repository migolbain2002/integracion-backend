package com.gerencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gerencia.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query("select u from Usuario u where u.username = :user")
	public Usuario consultarUsuarioByUser(@Param("user") String user);
	
	@Query(value = "select * from usuario u where u.username = :username and u.password = :password", nativeQuery = true)
	public Usuario login(@Param("username") String username, @Param("password") String password);

}
