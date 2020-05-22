package com.uca.capas.domain;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(schema = "public", name = "contribuyente")
public class Contribuyente {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_contribuyente")
	private Integer CodigoContribuyente;
	
	@Column(name = "c_importancia")
	@NotNull(message = "Debe seleccionar un tipo de importancia")
	private Integer cImportancia;
	
	@Column(name = "s_nombre")
	@Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
	private String Nombre;
	
	@Column(name = "s_apellido")
	@Size(min = 1, max = 50, message = "El apellido debe tener entre 1 y 50 caracteres")
	private String Apellido;
	
	@Column(name = "s_nit")
	@Size(min = 10, max = 10, message = "El NIT debe tener 10 caracteres")
	private String Nit;
	
	@Column(name = "f_fecha_ingreso")
	private Date FechaIngreso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_importancia", unique = true, insertable = false, updatable = false)
	private Importancia CodigoImportancia;
	
	
	
	public Contribuyente() {
		
	}
	
	
	public Integer getCodigoContribuyente() {
		return CodigoContribuyente;
	}
	public void setCodigoContribuyente(Integer codigoContribuyente) {
		CodigoContribuyente = codigoContribuyente;
	}
	
	public Integer getcImportancia() {
		return cImportancia;
	}


	public void setcImportancia(Integer cImportancia) {
		this.cImportancia = cImportancia;
	}
	
		public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getNit() {
		return Nit;
	}
	public void setNit(String nit) {
		Nit = nit;
	}
	public Date getFechaIngreso() {
		return FechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		FechaIngreso = fechaIngreso;
	}
	

	public Importancia getCodigoImportancia() {
		return CodigoImportancia;
	}


	public void setCodigoImportancia(Importancia codigoImportancia) {
		CodigoImportancia = codigoImportancia;
	}

	
}
