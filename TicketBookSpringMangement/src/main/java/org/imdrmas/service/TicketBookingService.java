package org.imdrmas.service;

import org.imdrmas.dao.TicketBookingDao;
import org.imdrmas.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketBookingService {
	@Autowired
	private TicketBookingDao ticketBookingDao;

	public Ticket createTicket(Ticket ticket) {
		return ticketBookingDao.save(ticket);
	}

	public Ticket getTicketById(Integer ticketId) {
		return ticketBookingDao.findOne(ticketId);
	}

	public Iterable<Ticket> getAllBookedTickts() {
		return ticketBookingDao.findAll();
	}

	public void deleteTicket(Integer ticketId) {
		ticketBookingDao.delete(ticketId);
	}

	public Ticket updateTicket(Integer ticketId, String newEmeil) {
		Ticket ticketFromDb = ticketBookingDao.findOne(ticketId);
		ticketFromDb.setEmail(newEmeil);
		Ticket updateTicket = ticketBookingDao.save(ticketFromDb);
		return updateTicket;
	}


	

}
