package com.isilVentasSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ClienteEmpresa")
public class ClienteEmpresa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name="ruc")
	private String ruc;
	
	@Column(name="razonSocial")
	private String razonSocial;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="nombreComercial")
	private String nombreComercial;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="correo")
	private String correo;
	
	@Column(name="foto")
	private String foto;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
}
