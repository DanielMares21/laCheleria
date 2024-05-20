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
import com.laCheleria.model.NoCompras;
import com.laCheleria.service.IntDetalle_compraService;
import com.laCheleria.service.IntNoCompraService;
import com.laCheleria.service.IntProveedorService;

import jakarta.validation.Valid;

@RequestMapping("/No_compra")
@Controller
public class NoCompraController {
	
	@Autowired
	private IntNoCompraService NoService;
	
	@Autowired
	private IntProveedorService provservice;
	
	@Autowired
	private IntDetalle_compraService compraService;

	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<NoCompras> num = NoService.listar();

		num.forEach(NoCompras ->  {
			NoCompras.setProveedor(provservice.buscar(NoCompras.getProveedores()));
			NoCompras.setDetalle_compra(compraService.buscar(NoCompras.getDetalle_compras()));
		});

		model.addAttribute("NoCompra", num);
		return "No_compra/perfilNo";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") int id, Model model) {

		NoCompras num = NoService.buscar(id);

		if (num != null) {
			model.addAttribute("NoCompra", num);
			model.addAttribute("proveedor", provservice.listar());
			model.addAttribute("detalle_compra", compraService.listar());
		} else {
			throw new IllegalArgumentException("La categoria con ID " + id + " no existe");
		}

		return "No_compra/actualizarNo";
	}

	@GetMapping("/formularioNo")
	public String agregar(Model model) {
	    model.addAttribute("NoCompra", new NoCompras());
		model.addAttribute("proveedor", provservice.listar());
		model.addAttribute("detalle_compra", compraService.listar());
	    return "No_compra/formularioNo";
	}
	@PostMapping("/index")
	public String guardar(@Valid NoCompras num, BindingResult result, Model model) {

		if (result.hasErrors()) {
	        return "No_compra/formularioNo";
	    }
		NoService.guardar(num);
		model.addAttribute("proveedor", provservice.listar());
		model.addAttribute("detalle_compra", compraService.listar());
	    return "redirect:/No_compra/index";
	}

	@PostMapping("/actualizarNo/{id}")
	public String actualizar(@PathVariable("id") int id, @ModelAttribute @Valid NoCompras num,
			  BindingResult result, Model model) {

		if (result.hasErrors()) {
			num.setIdnum(id);
			return "No_compra/actualizarNo/" + id;
		}

		num.setIdnum(id);
		NoService.actualizar(num);
		model.addAttribute("resultado", "NoCompras actualizado correctamente");
		return "redirect:/No_compra/index";
	}
	@GetMapping("/eliminar/{id}")
	public String Eliminar(Model model, @PathVariable int id) {
		NoService.eliminar(id);
		return "redirect:/No_compra/index";

	}
}
