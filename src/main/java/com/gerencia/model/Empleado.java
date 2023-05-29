package com.gerencia.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "empleado")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Empleado")
	private long idEmpleado;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "Num_ident")
	private long numIdent;
	
	@Column(name = "Tipo_ident")
	private String tipoIdent;
	
	@Column(name = "Correo")
	private String correo;
	
	@Column(name = "Direccion")
	private String direccion;
	
	@Column(name = "Edad")
	private long edad;
	
	@Column(name = "Salario")
	private double salario;
	
	
	@JoinColumn(name = "ID_Usuario", referencedColumnName = "ID_Usuario")
	@ManyToOne(optional = false, cascade=CascadeType.ALL)
	private Usuario idUsuario;
	
}
