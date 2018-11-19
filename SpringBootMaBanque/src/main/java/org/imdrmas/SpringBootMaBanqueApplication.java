package org.imdrmas;

import java.util.Date;

import org.imdrmas.dao.ClientRepository;
import org.imdrmas.dao.CompteRepository;
import org.imdrmas.dao.OperationRepository;
import org.imdrmas.entities.Client;
import org.imdrmas.entities.Compte;
import org.imdrmas.entities.CompteCourant;
import org.imdrmas.entities.CompteEpargne;
import org.imdrmas.entities.Retrait;
import org.imdrmas.entities.Versment;
import org.imdrmas.metier.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMaBanqueApplication implements CommandLineRunner {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanqueMetier banqueMetier;

	public static void main(String[] args) {
	 SpringApplication.run(SpringBootMaBanqueApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
	Client client1=clientRepository.save(new Client("drmas", "drmas@gmail.com"));
	Client client2=clientRepository.save(new Client("issam", "issam@gmail.com"));
	
	Compte compte1 = compteRepository.save(new CompteCourant("c1",new Date(), 1111, client1, 5555));
	Compte compte2 = compteRepository.save(new CompteEpargne("c2", new Date(), 2222, client2, 6.5));
	
	operationRepository.save(new Versment(new Date(), 4000, compte1));
	operationRepository.save(new Versment(new Date(), 5000, compte1));
	operationRepository.save(new Versment(new Date(), 4600, compte1));
	operationRepository.save(new Retrait(new Date(), 4000, compte1));
	
	operationRepository.save(new Versment(new Date(), 4000, compte2));
	operationRepository.save(new Versment(new Date(), 5000, compte2));
	operationRepository.save(new Versment(new Date(), 4600, compte2));
	operationRepository.save(new Retrait(new Date(), 4000, compte2));
	
	banqueMetier.verser("c1", 111);

		
	}
}
