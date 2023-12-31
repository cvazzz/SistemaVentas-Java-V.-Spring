package com.isilVentasSpring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.isilVentasSpring.entity.CategoriaProducto;
import com.isilVentasSpring.entity.ClienteEmpresa;
import com.isilVentasSpring.entity.Usuario;
import com.isilVentasSpring.repository.CategoriaProductoRepository;
import com.isilVentasSpring.repository.ClienteEmpresaRepository;
import com.isilVentasSpring.repository.UsuarioRepository;

@Controller
@RequestMapping("/home") /*Asi se le coloca un nombre a un controlador*/
public class HomeController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ClienteEmpresaRepository clienteEmpresaRepository;
	
	@Autowired
	CategoriaProductoRepository categoriaProductoRepository;
	
	@RequestMapping(value="/validarUsuario", method=RequestMethod.POST)
	public String validarUsuario(HttpServletRequest request, @RequestParam("correo") String correo, @RequestParam("password") String password, Model model) {
		String pagina;
		Usuario objUsuario = usuarioRepository.findByCorreoAndPassword(correo, password);
		if (objUsuario!=null) {
			pagina = "principal";
			/*Registro de la variable de sesión*/
			HttpSession sesion = request.getSession();
			sesion.setAttribute("usuario", objUsuario);
			model.addAttribute("usuario", objUsuario);
		}
		else {
			String mensaje = "El usuario y/o contraseña no son correctos";
			model.addAttribute("mensaje", mensaje);
			pagina = "index";
		}
		return pagina;
	}
	
	@GetMapping(value="/mostrarGestionClienteJuridico")
	public String mostrarGestionClienteJuridico(HttpServletRequest request, Model model) {
		HttpSession sesion = request.getSession();
		Usuario objUsuario = (Usuario)sesion.getAttribute("usuario");
		if (objUsuario!=null) {
			List<ClienteEmpresa> listaClientesEmpresa = clienteEmpresaRepository.findAll();
			model.addAttribute("listaClientesEmpresa", listaClientesEmpresa);
			return "gestionClientesJuridicos";
		}
		else {
			return "redirect:/home/login";
		}
	}
	
	@GetMapping(value="/login")
	public String login(HttpServletRequest request, Model model) {
		return "index";
	}
	
	@GetMapping(value="/mostrarGestionProductos")
	public String mostrarGestionProductos(HttpServletRequest request, Model model) {
		HttpSession sesion = request.getSession();
		Usuario objUsuario = (Usuario)sesion.getAttribute("usuario");
		if (objUsuario!=null) {
			List<CategoriaProducto> listaCategorias = categoriaProductoRepository.findAll();
			model.addAttribute("listaCategorias", listaCategorias);
			return "gestionProductos";
		}
		else {
			return "redirect:/home/login";
		}
	}
	
	@GetMapping(value="/cerrarSesion")
	public String cerrarSesion(HttpServletRequest request, Model model) {
		request.getSession(false).invalidate(); /*Con esto cerramos la sesión*/
		return "index";
	}
}
