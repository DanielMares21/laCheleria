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

import com.laCheleria.model.proveedor;
import com.laCheleria.service.IntProveedorService;

import jakarta.validation.Valid;

@RequestMapping("/proveedor")
@Controller
public class ProvedorController {
	
	@Autowired
	private IntProveedorService ServiceProv;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<proveedor> proveedor = ServiceProv.listar();
		for (proveedor p: proveedor) {
			System.out.println(p);
		}
		model.addAttribute("proveedor", proveedor);
		return "proveedor/perfil";
	}
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") int id, Model model) {

		proveedor proveedor = ServiceProv.buscar(id);

		if (proveedor != null) {
			model.addAttribute("proveedor", proveedor);
		} else {
			throw new IllegalArgumentException("el Proveedor con ID " + id + " no existe");
		}

		return "proveedor/actualizarProve";
	}


	@GetMapping("/formProve")
	public String agregar(Model model) {
	    model.addAttribute("proveedor", new proveedor());
	    return "proveedor/formProve";
	}
	@PostMapping("/index")
	public String guardar(@Valid proveedor proveedor, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        return "proveedor/formProve";
	    }
	    ServiceProv.guardar(proveedor);
	    return "redirect:/proveedor/index";
	}
	@PostMapping("/actualizarProve/{id}")
	public String actualizar(@PathVariable("id") int id, @ModelAttribute @Valid proveedor proveedor,
			  BindingResult result, Model model) {

		if (result.hasErrors()) {
			proveedor.setIdproveedor(id);
			return "proveedor/actualizarProve/" + id;
		}
		proveedor.setIdproveedor(id);
		ServiceProv.actualizar(proveedor);
		model.addAttribute("resultado", "Proveedor actualizado correctamente");
		return "redirect:/proveedor/index";
	}
	@GetMapping("/eliminar/{id}")
	public String Eliminar(Model model, @PathVariable int id) {
		 ServiceProv.eliminar(id);
		return "redirect:/proveedor/index";
		
	}

}
