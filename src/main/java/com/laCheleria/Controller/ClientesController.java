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

import com.laCheleria.model.Clientes;
import com.laCheleria.service.IntClientesService;

import jakarta.validation.Valid;

@RequestMapping("/clientes")
@Controller
public class ClientesController {
	
	@Autowired
	private IntClientesService clienteServ;
	
	
@GetMapping("/index")
public String mostrar(Model model) {
    List<Clientes> cliente = clienteServ.listar();
    for (Clientes c : cliente) {
        System.out.println(c);
    }
    model.addAttribute("clientes", cliente);
    return "clientes/PerfilClientes";
}
@GetMapping("/editar/{id}")
public String editar(@PathVariable("id") int id, Model model) {

	Clientes cliente = clienteServ.buscar(id);

	if (cliente != null) {
		model.addAttribute("cliente", cliente);
	} else {
		throw new IllegalArgumentException("La categoria con ID " + id + " no existe");
	}

	return "clientes/actualizar2";
}



@GetMapping("/formularioClientes")
public String agregar(Model model) {
    model.addAttribute("clientes", new Clientes());
    return "clientes/formularioClientes"; 
}

@PostMapping("/index")
public String guardar(@Valid Clientes cliente, BindingResult result, Model model) {
    if (result.hasErrors()) {
        return "clientes/formularioClientes"; 
    }
    clienteServ.guardar(cliente);
    return "redirect:/clientes/index";
}
@PostMapping("/actualizar2/{id}")
public String actualizar(@PathVariable("id") int id, @ModelAttribute @Valid Clientes cliente,
		  BindingResult result, Model model) {

	if (result.hasErrors()) {
		cliente.setIdcliente(id);
		return "clientes/actualizar2/" + id;
	}
	cliente.setIdcliente(id);
	clienteServ.actualizar(cliente);
	model.addAttribute("resultado", "Cliente actualizado correctamente");
	return "redirect:/clientes/index";
}

@GetMapping("/eliminar/{id}")
public String Eliminar(Model model, @PathVariable int id) {
    clienteServ.eliminar(id);
    return "redirect:/clientes/index"; 
}
}


