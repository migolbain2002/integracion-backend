package com.gerencia.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
