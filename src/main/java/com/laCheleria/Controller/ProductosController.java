package com.laCheleria.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laCheleria.model.Producto;
import com.laCheleria.service.IntProductosService;

import jakarta.validation.Valid;

	@RequestMapping("/Productos")
	@Controller 
	public class ProductosController {
		
		@Autowired
		private IntProductosService productosServices;

		@GetMapping("/index")
		public String mostrarIndex(Model model) {
			List<Producto> productos = productosServices.listar();
			for (Producto p: productos) {
				System.out.println(p);
			}
			model.addAttribute("producto", productos);
			return "Productos/perfil";
		}
		@GetMapping("/editar/{id}")
		public String editar(@PathVariable("id") int id, Model model) {

			Producto producto = productosServices.buscar(id);

			if (producto != null) {
				model.addAttribute("producto", producto);
			} else {
				throw new IllegalArgumentException("La categoria con ID " + id + " no existe");
			}

			return "Productos/actualizar";
		}

	
		@GetMapping("/formulario")
		public String agregar(Model model) {
		    model.addAttribute("productos", new Producto());
		    return "Productos/formulario";
		}
		@PostMapping("/index")
		public String guardar(@Valid Producto producto, BindingResult result, Model model) {
		    if (result.hasErrors()) {
		        return "Productos/formulario";
		    }
		    productosServices.guardar(producto);
		    return "redirect:/Productos/index";
		}
		@PostMapping("/actualizar/{id}")
		public String actualizar(@PathVariable("id") int id, @ModelAttribute @Valid Producto producto,
				  BindingResult result, Model model) {

			if (result.hasErrors()) {
				producto.setId(id);
				return "Productos/actualizar/" + id;
			}

			productosServices.actualizar(producto);
			model.addAttribute("resultado", "Producto actualizado correctamente");
			return "redirect:/Productos/index";
		}
		@GetMapping("/eliminar/{id}")
		public String Eliminar(Model model, @PathVariable int id) {
			 productosServices.eliminar(id);
			return "redirect:/Productos/index";
			
		}
	}


