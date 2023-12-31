package com.isilVentasSpring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.isilVentasSpring.entity.ClienteEmpresa;
import com.isilVentasSpring.entity.Usuario;
import com.isilVentasSpring.repository.ClienteEmpresaRepository;

@Controller
@RequestMapping("/clienteEmpresa") /*Asi se le coloca un nombre a un controlador*/
public class ClienteEmpresaController {

	@Autowired
	ClienteEmpresaRepository clienteEmpresaRepository;
	
	@PostMapping(value="/registrar")
	public String registrar(HttpServletRequest request, @ModelAttribute("objClienteEmpresa") ClienteEmpresa objClienteEmpresa, Model model) {
		HttpSession sesion = request.getSession();
		Usuario objUsuario = (Usuario)sesion.getAttribute("usuario");
		if (objUsuario!=null) {
			clienteEmpresaRepository.save(objClienteEmpresa);
			List<ClienteEmpresa> listaClientesEmpresa = clienteEmpresaRepository.findAll();
			model.addAttribute("listaClientesEmpresa", listaClientesEmpresa);
			return "gestionClientesJuridicos";
		}
		else {
			return "redirect:/home/login";
		}
	}
	
	@PostMapping(value="/actualizar")
	public String actualizar(HttpServletRequest request, @ModelAttribute("objClienteEmpresa") ClienteEmpresa objClienteEmpresa, Model model) {
		HttpSession sesion = request.getSession();
		Usuario objUsuario = (Usuario)sesion.getAttribute("usuario");
		if (objUsuario!=null) {
			clienteEmpresaRepository.save(objClienteEmpresa);
			List<ClienteEmpresa> listaClientesEmpresa = clienteEmpresaRepository.findAll();
			model.addAttribute("listaClientesEmpresa", listaClientesEmpresa);
			return "gestionClientesJuridicos";
		}
		else {
			return "redirect:/home/login";
		}
		
	}
	
	@PostMapping(value="/mostrarNuevoCliente")
	public String mostrarNuevoCliente(HttpServletRequest request, Model model) {
		ClienteEmpresa objClienteEmpresa = new ClienteEmpresa();
		model.addAttribute("objClienteEmpresa", objClienteEmpresa);
		return "nuevoClienteJuridico";
	}
	
	@GetMapping("/eliminarCliente/{codigo}")
	public String eliminarCliente(HttpServletRequest request, @PathVariable int codigo, Model model) {
		clienteEmpresaRepository.deleteById(codigo);
		List<ClienteEmpresa> listaClientesEmpresa = clienteEmpresaRepository.findAll();
		model.addAttribute("listaClientesEmpresa", listaClientesEmpresa);
		return "gestionClientesJuridicos";
	}
	
	@GetMapping("/editarCliente/{codigo}")
	public String editarCliente(HttpServletRequest request, @PathVariable int codigo, Model model) {
		ClienteEmpresa objClienteEmpresa = clienteEmpresaRepository.findById(codigo);
		model.addAttribute("objClienteEmpresa", objClienteEmpresa);
		return "editarClienteJuridico";
	}
	
	@RequestMapping(value="/buscarRucCorreo", method=RequestMethod.GET)
	public String buscarRucCorreo(HttpServletRequest request, @RequestParam("ruc") String ruc, @RequestParam("correo") String correo, Model model) {
		List<ClienteEmpresa> listaClientesEmpresa = clienteEmpresaRepository.findByRucContainsAndCorreoContains(ruc, correo);
		model.addAttribute("listaClientesEmpresa", listaClientesEmpresa);
		return "gestionClientesJuridicos";
	}
	
	
}
