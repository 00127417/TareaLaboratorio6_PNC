package com.uca.capas.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import com.uca.capas.service.ContribuyenteService;
import com.uca.capas.service.ImportanciaService;

@Controller
public class MainController {

	@Autowired
	ContribuyenteService contibuyenteService;
	
	@Autowired
	ImportanciaService importanciaService;

	
	@RequestMapping("/inicio")
	public ModelAndView init(){
		ModelAndView mav = new ModelAndView();
		List<Importancia> listImp = importanciaService.findAll();
		mav.addObject("importancias", listImp);
		mav.addObject("contribuyente", new Contribuyente());
		mav.setViewName("index");
		return mav;
		
	}
	
	@RequestMapping("/save")
	public ModelAndView formContribuyente(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		List<Importancia> listImp = importanciaService.findAll();
		mav.addObject("importancias", listImp);
		if(result.hasErrors()) {
			mav.setViewName("index");
			
		}
		
		else {
			long mil =  System.currentTimeMillis();
			Date date = new Date(mil);
			contribuyente.setFechaIngreso(date);
			contibuyenteService.save(contribuyente);
			mav.addObject("contribuyente", new Contribuyente());
			mav.setViewName("index");
		}
		return mav;
		
	}
	
	@RequestMapping("/contribuyentes")
	public ModelAndView tableContri() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> listado = contibuyenteService.findAll();
		mav.addObject("contribuyentes", listado);
		mav.setViewName("listado");
		return mav;
	}
	
}
