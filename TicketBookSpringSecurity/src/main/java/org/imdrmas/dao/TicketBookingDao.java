package org.imdrmas.dao;

import org.imdrmas.entities.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketBookingDao extends CrudRepository<Ticket, Integer> {
}
