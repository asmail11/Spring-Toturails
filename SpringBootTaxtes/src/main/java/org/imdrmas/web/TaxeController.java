package org.imdrmas.web;

import java.util.ArrayList;

import javax.validation.Valid;

import org.imdrmas.dao.EntrepriseRepository;
import org.imdrmas.dao.TaxeRepository;
import org.imdrmas.entities.Entreprise;
import org.imdrmas.entities.Taxe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaxeController {
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private TaxeRepository taxeRepository;
	@RequestMapping(value="/entreprises",method=RequestMethod.GET)
	public String index(Model model,
			@RequestParam(name="motCle", defaultValue="") String motCle,
			@RequestParam(name="page", defaultValue="0") int page, 
			@RequestParam(name="size", defaultValue="4")int size) {
		Page<Entreprise> entreprises = entrepriseRepository.chercher("%"+motCle+"%", new PageRequest(page, size));
		model.addAttribute("listEntreprises",  entreprises);
		int[] pagees=new int[entreprises.getTotalPages()];
		model.addAttribute("pages",pagees);
		model.addAttribute("pageCourant",page);
		model.addAttribute("motCle", motCle);
		return "entreprises";
	}
	@RequestMapping(value="/formEntreprise")
	public String formEntreprise(Model model) {
		model.addAttribute("entreprise", new Entreprise());
		return "formEntreprises";
	}
	@RequestMapping(value="/saveEntreprise")
	public String saveEntreprise(Model model, 
			@Valid Entreprise entreprise, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "formEntreprises";
		entrepriseRepository.save(entreprise);
		return "redirect:/entreprises";
	}
	@RequestMapping(value="/taxes")
	public String taxes(Model model,
			@RequestParam(name="code",defaultValue="-1")Long code) {
		    model.addAttribute("entreprises",entrepriseRepository.findAll());
		if (code==-1) {
			model.addAttribute("taxes",new ArrayList<Taxe>());
		}
		else {
			Entreprise entreprise=new Entreprise();
			entreprise.setCode(code);
			model.addAttribute("taxes", taxeRepository.findByEntreprise(entreprise));
		}
	
		return "taxes";
	}
/*	@RequestMapping(value="/chercher")
	public String chercher(Model model, String motCle, 
			@RequestParam(name="page", defaultValue="0")int page, 
			@RequestParam(name="size", defaultValue="4")int size) {
		Page<Entreprise> pageEntreprise=entrepriseRepository.chercher("%"+motCle+"%", new PageRequest(page, size));
		model.addAttribute("pageEntrprise", pageEntreprise);
		return "entreprises";
	}*/

}
