package com.isilVentasSpring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.isilVentasSpring.entity.CategoriaProducto;
import com.isilVentasSpring.entity.ProductoVenta;
import com.isilVentasSpring.repository.CategoriaProductoRepository;
import com.isilVentasSpring.repository.ProductoVentaRepository;

@Controller
@RequestMapping("/producto") /*Asi se le coloca un nombre a un controlador*/
public class ProductoController {

	@Autowired
	CategoriaProductoRepository categoriaProductoRepository;
	
	@Autowired
	ProductoVentaRepository productoVentaRepository;
	
	@RequestMapping(value="/buscarProductoxCategoria", method=RequestMethod.GET)
	public String buscarProductoxCategoria(HttpServletRequest request, @RequestParam("codigoCategoria") int codigoCategoria, Model model) {
		CategoriaProducto categoriaProducto = categoriaProductoRepository.findById(codigoCategoria);
		List<ProductoVenta> listaProductos = productoVentaRepository.findByCategoria(categoriaProducto);
		model.addAttribute("listaProductos", listaProductos);
		List<CategoriaProducto> listaCategorias = categoriaProductoRepository.findAll();
		model.addAttribute("listaCategorias", listaCategorias);
		return "gestionProductos";
	}
	
	@PostMapping(value="/mostrarNuevo")
	public String mostrarNuevo(HttpServletRequest request, Model model) {
		ProductoVenta producto = new ProductoVenta();
		model.addAttribute("producto", producto); /*Esto es para guardar ahi la informacion de la pagina*/
		List<CategoriaProducto> listaCategorias = categoriaProductoRepository.findAll();
		model.addAttribute("listaCategorias", listaCategorias); /*Esto es para mostrar nuestro combo box de categorias*/
		return "nuevoProducto";
	}
	
	@PostMapping(value="/registrar")
	public String registrar(HttpServletRequest request, @ModelAttribute("producto") ProductoVenta producto, Model model) {
		productoVentaRepository.save(producto);
		List<CategoriaProducto> listaCategorias = categoriaProductoRepository.findAll();
		model.addAttribute("listaCategorias", listaCategorias); /*Esto es para mostrar nuestro combo box de categorias*/		
		return "gestionProductos";
	}
	
	@GetMapping(value="/editar/{codigo}") /*Recuerde que cuando reciben un parametro por la URL, entonces este parametro es un PathVariable*/
	public String editar(HttpServletRequest request, @PathVariable int codigo, Model model) {
		ProductoVenta objProducto = productoVentaRepository.findByCodigo(codigo);
		model.addAttribute("producto", objProducto);
		List<CategoriaProducto> listaCategorias = categoriaProductoRepository.findAll();
		model.addAttribute("listaCategorias", listaCategorias); /*Esto es para mostrar nuestro combo box de categorias*/
		return "editarProducto";
	}
	
	@PostMapping(value="/actualizar")
	public String actualizar(HttpServletRequest request, @ModelAttribute("producto") ProductoVenta producto, Model model) {
		productoVentaRepository.save(producto);
		List<CategoriaProducto> listaCategorias = categoriaProductoRepository.findAll();
		model.addAttribute("listaCategorias", listaCategorias); /*Esto es para mostrar nuestro combo box de categorias*/		
		return "gestionProductos";		
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminar(HttpServletRequest request, @PathVariable int codigo, Model model) {
		productoVentaRepository.deleteByCodigo(codigo);
		List<CategoriaProducto> listaCategorias = categoriaProductoRepository.findAll();
		model.addAttribute("listaCategorias", listaCategorias); /*Esto es para mostrar nuestro combo box de categorias*/		
		return "gestionProductos";		
	}
}
