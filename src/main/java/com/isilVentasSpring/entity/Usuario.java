package com.isilVentasSpring.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name="correo")
	private String correo;
	
	@Column(name="password")
	private String password;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="perfil")
	private String perfil;
	
	@ManyToMany
	@JoinTable(
			  name = "UsuarioxPerfil", 
			  joinColumns = @JoinColumn(name = "codigoUsuario"), 
			  inverseJoinColumns = @JoinColumn(name = "codigoPerfil"))
	private List<Perfil> perfiles;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public List<Perfil> getPerfiles() {
		return perfiles;
	}
	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}
	
	
}
