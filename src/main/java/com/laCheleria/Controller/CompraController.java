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
import com.laCheleria.model.detalle_compra;
import com.laCheleria.service.IntDetalle_compraService;
import com.laCheleria.service.IntProductosService;

import jakarta.validation.Valid;

@RequestMapping("/detalle_compra")
@Controller
public class CompraController {

	@Autowired
	private IntDetalle_compraService compraservice;
	
	@Autowired
	private IntProductosService serviceProd;
	
	@GetMapping("/index")
	public String mostrar(Model model) {
	    List<detalle_compra> compra= compraservice.listar();
	    compra.forEach(detallecompra ->  {
			detallecompra.setProducto(serviceProd.buscar(detallecompra.getProductos()));
		});
	    model.addAttribute("detalle_compra", compra);
	    return "detalle_compra/PerfilCompra";
	}
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") int id, Model model) {

		detalle_compra compra = compraservice.buscar(id);

		if (compra != null) {
			model.addAttribute("producto", serviceProd.listar());
			model.addAttribute("detalle_compra", compra);
		} else {
			throw new IllegalArgumentException("La categoria con ID " + id + " no existe");
		}

		return "detalle_compra/actualizarCompra";
	}



	@GetMapping("/formularioCompra")
	public String agregar(Model model) {
	    model.addAttribute("detalle_compra", new detalle_compra());
	    model.addAttribute("producto", serviceProd.listar());
	    return "detalle_compra/formularioCompra"; 
	}

	@PostMapping("/index")
	public String guardar(@Valid detalle_compra compra, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        return "detalle_compra/formularioCompra"; 
	    }
	    compraservice.guardar(compra);
	    model.addAttribute("productos", serviceProd.listar());
	    return "redirect:/detalle_compra/index";
	}
	@PostMapping("/actualizarCompra/{id}")
	public String actualizar(@PathVariable("id") int id, @ModelAttribute @Valid detalle_compra compra,
			  BindingResult result, Model model) {

		if (result.hasErrors()) {
			compra.setIdcompra(id);
			return "detalle_compra/actualizarcompra/" + id;
		}
		compra.setIdcompra(id);
		compraservice.actualizar(compra);
		model.addAttribute("resultado", "Detalle_Compra actualizada correctamente");
		return "redirect:/detalle_compra/index";
	}

	@GetMapping("/eliminar/{id}")
	public String Eliminar(Model model, @PathVariable int id) {
	    compraservice.eliminar(id);
	    return "redirect:/detalle_compra/index"; 
	}
}
