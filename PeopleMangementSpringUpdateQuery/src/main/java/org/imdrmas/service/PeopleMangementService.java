package org.imdrmas.service;



import org.imdrmas.dao.PeopleMangementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PeopleMangementService {
	
	@Autowired
	private PeopleMangementDao peopleMangementDao;

	public void uodatePersonEmailById(int id, String newEmail) {
		peopleMangementDao.uodatePersonEmailById(id, newEmail);
		
	}




}
