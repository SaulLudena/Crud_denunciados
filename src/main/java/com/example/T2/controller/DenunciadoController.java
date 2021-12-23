package com.example.T2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.T2.models.DAO.IDenunciadoDAO;
import com.example.T2.models.entity.Denunciado;

@Controller
@RequestMapping("/denunciado")
public class DenunciadoController {

	@Autowired
	private IDenunciadoDAO denunciadoDAO;
	
	@RequestMapping("/listar")
	public String lista(Model model) {
		model.addAttribute("listaDenunciado",denunciadoDAO.getDenunciados());
		return "denunciados/listar";
	}
	
	@RequestMapping("/formulario")
	public String crear(Model model){
		Denunciado denunciado = new Denunciado();
		model.addAttribute("denunciado",denunciado);
		return "denunciados/formulario";
	}
	
	@RequestMapping(value =  "/formulario", method=RequestMethod.POST)
	public String guardar(Denunciado denunciado){
		denunciadoDAO.guardar(denunciado);
		return "redirect:/denunciado/listar";
	}
	
	@RequestMapping("/form/{cod_denun}")
	public String editar(@PathVariable(value="cod_denun") Long cod_denun, Model model) {
		Denunciado denunciado = denunciadoDAO.buscarDenunciado(cod_denun);
		model.addAttribute("denunciado",denunciado);
		return "denunciados/formulario";
	}
	
	@RequestMapping("/eliminar/{cod_denun}")
	public String eliminar(@PathVariable(value="cod_denun") Long cod_denun) {
		denunciadoDAO.eliminar(cod_denun);
		return "redirect:/denunciado/listar";
	}
}
