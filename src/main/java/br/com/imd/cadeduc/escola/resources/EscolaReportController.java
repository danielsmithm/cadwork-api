package br.com.imd.cadeduc.escola.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.imd.cadeduc.core.service.exception.GenericServiceException;
import br.com.imd.cadeduc.escola.service.EscolaService;

@Controller
@RequestMapping("/reports")
public class EscolaReportResources {
	
	@Autowired
	EscolaService escolaService;
	
	public EscolaReportResources(EscolaService escolaService) {
		this.escolaService = escolaService;
	}
	
	
	@GetMapping("/html")
	public String html(Model model) {
		try {
			model.addAttribute("escolas", this.escolaService.listar());
		} catch (GenericServiceException e) {
			e.printStackTrace();
		}
		return "report/index";
	}
	
}
