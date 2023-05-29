package com.gerencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gerencia.model.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

	@Query("select e from Empleado e where e.numIdent = :ident")
	public Empleado consultarEmpleadoByIdent(@Param("ident") Long ident);

}
