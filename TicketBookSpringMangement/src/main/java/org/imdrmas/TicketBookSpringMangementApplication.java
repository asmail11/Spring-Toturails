package org.imdrmas;

import java.util.Date;

import javax.sql.DataSource;

import org.imdrmas.entities.Ticket;
import org.imdrmas.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketBookSpringMangementApplication implements CommandLineRunner {
	
	@Autowired
	private TicketBookingService ticketBookingService;
	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
	SpringApplication.run(TicketBookSpringMangementApplication.class, args);
 
	}

	@Override
	public void run(String... args) throws Exception {
	    Ticket ticket = new Ticket();
	    ticket.setBookingDate(new Date());
	    ticket.setDeststation("Paris");
	    ticket.setSourceStation("London");
	    ticket.setPassengerName("Drmas");
	    ticket.setEmail("idrmas@gmail.com");
	    
	    ticketBookingService.createTicket(ticket);
	    System.out.println("DataSource::"+dataSource);
		
	}
}
