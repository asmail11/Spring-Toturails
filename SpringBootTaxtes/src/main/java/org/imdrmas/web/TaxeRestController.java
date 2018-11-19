package org.imdrmas.web;

import org.imdrmas.dao.EntrepriseRepository;
import org.imdrmas.entities.Entreprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxeRestController {
	@Autowired
    private EntrepriseRepository entrepriseRepository;
	@RequestMapping("/listEntreprises")
	public Page<Entreprise> listEntreprisse(
			@RequestParam(name="motCle",defaultValue="")String motCle,
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size){
		return entrepriseRepository.chercher("%"+motCle+"%", new PageRequest(page, size));
	}
}
