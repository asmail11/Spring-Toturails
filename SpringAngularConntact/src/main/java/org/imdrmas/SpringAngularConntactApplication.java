package org.imdrmas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.imdrmas.entities.Conntact;
import org.imdrmas.entities.ConntactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAngularConntactApplication implements CommandLineRunner{
	@Autowired
	private ConntactRepository conntactRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringAngularConntactApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat dFormat=new SimpleDateFormat("dd/MM/yyyy");
		conntactRepository.save(new Conntact("issam", "drmas", 
				dFormat.parse("12/04/1990"), "imdrmas@gmaail", 0123456111, "drmas.jpg" ));
		conntactRepository.findAll().forEach(c->{
			System.out.println(c.getNom());
		});
		
	}
}
