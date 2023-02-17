package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@GetMapping({ "/index", "/", "", "home" })
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framework con Model!");
		return "index";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Diego");
		usuario.setApellido("Tello");
		usuario.setEmail("Diego@gmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil de usuario:".concat(usuario.getNombre()));
		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Lista de usuarios");
		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuario() {
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("Andres", "Guzman", "Guzama@gmail.com"),
				new Usuario("Diego", "Tello", "Tello@gmail.com"), 
				new Usuario("Karol", "Camana", "Gonzales@gmail.com"),
				new Usuario("Alison", "Bellido", "Bellido@gmail.com"),
				new Usuario("Erick", "Gonzales", "Gonzales@gmail.com"),
				new Usuario("Leon", "Toralva", "Toralva@gmail.com"),
				new Usuario("Juan", "Vega", "Vega@gmail.com"),
				new Usuario("Nazli", "Tello", "Tello@gmail.com"));
				

		return usuarios;

	}
}
