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
import com.laCheleria.model.detalle_pedido;
import com.laCheleria.service.IntClientesService;
import com.laCheleria.service.IntDetalles_pedidoService;
import com.laCheleria.service.IntProductosService;
import jakarta.validation.Valid;



@RequestMapping("/detalles_pedido")
@Controller
public class detalles_pedidoController {

	@Autowired
	private IntDetalles_pedidoService serviceDetalles;

	@Autowired
	private IntProductosService serviceProd;

	@Autowired
	private IntClientesService serviceCli;


	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<detalle_pedido> detalles = serviceDetalles.listar();

		detalles.forEach(detallePedido ->  {
			detallePedido.setProducto(serviceProd.buscar(detallePedido.getProductos()));
			detallePedido.setCliente(serviceCli.buscar(detallePedido.getClientes()));
		});

		model.addAttribute("detalle_pedido", detalles);
		return "detalles_pedido/perfilDetalles";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") int id, Model model) {

		detalle_pedido detalle = serviceDetalles.buscar(id);

		if (detalle != null) {
			model.addAttribute("detalle_pedido", detalle);
			model.addAttribute("producto", serviceProd.listar());
			model.addAttribute("cliente", serviceCli.listar());
		} else {
			throw new IllegalArgumentException("La categoria con ID " + id + " no existe");
		}

		return "detalles_pedido/actualizarD";
	}

	@GetMapping("/formularioDetalles")
	public String agregar(Model model) {
	    model.addAttribute("detalle_pedido", new detalle_pedido());
	    model.addAttribute("producto", serviceProd.listar());
	    model.addAttribute("cliente", serviceCli.listar());
	    return "detalles_pedido/formularioDetalles";
	}
	@PostMapping("/index")
	public String guardar(@Valid detalle_pedido detalle, BindingResult result, Model model) {

		if (result.hasErrors()) {
	        return "detalles_pedido/formularioDetalles";
	    }
		serviceDetalles.guardar(detalle);
	    model.addAttribute("productos", serviceProd.listar());
	    model.addAttribute("clientes", serviceCli.listar());
	    return "redirect:/detalles_pedido/index";
	}

	@PostMapping("/actualizarD/{id}")
	public String actualizar(@PathVariable("id") int id, @ModelAttribute @Valid detalle_pedido detalle,
			  BindingResult result, Model model) {

		if (result.hasErrors()) {
			detalle.setIdDetalle(id);
			return "detalles_pedido/actualizarD/" + id;
		}

		detalle.setIdDetalle(id);
		serviceDetalles.actualizar(detalle);
		model.addAttribute("resultado", "Producto actualizado correctamente");
		return "redirect:/detalles_pedido/index";
	}
	@GetMapping("/eliminar/{id}")
	public String Eliminar(Model model, @PathVariable int id) {
		 serviceDetalles.eliminar(id);
		return "redirect:/detalles_pedido/index";

	}
}
