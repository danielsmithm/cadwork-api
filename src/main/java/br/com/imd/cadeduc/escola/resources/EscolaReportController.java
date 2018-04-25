package br.com.imd.cadeduc.escola.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.imd.cadeduc.core.service.exception.GenericServiceException;
import br.com.imd.cadeduc.escola.service.EscolaService;

@Controller
@RequestMapping("/reports")
public class EscolaReportController {
	
	@Autowired
	EscolaService escolaService;
	
	public EscolaReportController(EscolaService escolaService) {
		this.escolaService = escolaService;
	}
	
	
	@GetMapping("/html")
	public String html(@RequestParam(required = false, value = "escola") Long id, Model model) throws GenericServiceException {
		
		model.addAttribute("escolas", this.escolaService.listar());
		
		if (id == null) {
			return "report/index";
		}
		
		model.addAttribute("atribute", this.escolaService.buscar(id).get().getSeries());
		
		return "report/index";
		
	}
	
}
