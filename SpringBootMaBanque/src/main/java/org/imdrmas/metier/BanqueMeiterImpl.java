package org.imdrmas.metier;

import java.util.Date;

import org.imdrmas.dao.CompteRepository;
import org.imdrmas.dao.OperationRepository;
import org.imdrmas.entities.Compte;
import org.imdrmas.entities.CompteCourant;
import org.imdrmas.entities.Operation;
import org.imdrmas.entities.Retrait;
import org.imdrmas.entities.Versment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class BanqueMeiterImpl implements IBanqueMetier {
    @Autowired
	private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;
	
	@Override
	public Compte consulterCompte(String codeCpte) {
		Compte compte = compteRepository.findOne(codeCpte);
		if (compte==null)
			throw new RuntimeException("Compte introuvable");
		return compte;
	}

	@Override
	public void verser(String codeCpte, double montent) {
		Compte compte = consulterCompte(codeCpte);
		Versment versment = new Versment(new Date(), montent, compte);
		operationRepository.save(versment);
		compte.setSolde(compte.getSolde()+montent);
		compteRepository.save(compte);
	}

	@Override
	public void retirer(String codeCpte, double montent) {
		Compte compte = consulterCompte(codeCpte);
		double facilitesCaisse=0;
		if (compte instanceof CompteCourant)
			facilitesCaisse=((CompteCourant) compte).getDecouvert();
		
		if (compte.getSolde()+facilitesCaisse<montent) 
			throw new RuntimeException("Solde insuffisant");
		
		Retrait retrait = new Retrait(new Date(), montent, compte);
		operationRepository.save(retrait);
		compte.setSolde(compte.getSolde()-montent);
		compteRepository.save(compte);
		
	}

	@Override
	public Page<Operation> listOperation(String codeCpte, int page, int size) {	
		return operationRepository.listOperation(
				        codeCpte, new PageRequest(page, size));
	}

	@Override
	public void virement(String codeCpte1, String codeCpte2, double montent) {
		if (codeCpte1.equals(codeCpte2)) 
			throw new RuntimeException("Impossible le virement sue le même compte");
		
		retirer(codeCpte1, montent);
		verser(codeCpte2, montent);
		
	}

}
