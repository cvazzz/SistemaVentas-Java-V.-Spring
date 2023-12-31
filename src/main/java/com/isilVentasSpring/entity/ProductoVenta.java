package com.isilVentasSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ProductoVenta")
public class ProductoVenta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name="tipoProducto")
	private String tipoProducto;
	
	@Column(name="precio")
	private double precio;
	
	@Column(name="stock")
	private int stock;
	
	@Column(name="nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="codigoCategoria")
	private CategoriaProducto categoria;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getTipoProducto() {
		return tipoProducto;
	}
	
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public CategoriaProducto getCategoria() {
		return categoria;
	}
	
	public void setCategoria(CategoriaProducto categoria) {
		this.categoria = categoria;
	}
}
