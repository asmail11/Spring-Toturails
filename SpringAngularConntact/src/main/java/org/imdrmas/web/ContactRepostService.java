package org.imdrmas.web;

import java.util.List;
import java.util.Optional;

import org.imdrmas.entities.Conntact;
import org.imdrmas.entities.ConntactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ContactRepostService {
	@Autowired
	private ConntactRepository conntactRepository;
	@RequestMapping(value="/contacts",method=RequestMethod.GET)
	public List<Conntact> getContacts(){
		return conntactRepository.findAll();
	}
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.GET)
	public Optional<Conntact> getContact(@PathVariable Long id){
		return conntactRepository.findById(id);
	}
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/chercherContacts",method=RequestMethod.GET)
	public Page<Conntact> search(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="mc",defaultValue="5")int size
			){
		return conntactRepository.search("%"+mc+"%", new PageRequest(page, size));
	}
	@RequestMapping(value="/contact",method=RequestMethod.POST)
	public Conntact save(@RequestBody Conntact c){
		return conntactRepository.save(c);
	}
	@RequestMapping(value="/contact",method=RequestMethod.DELETE)
	public Boolean delete(@PathVariable Long id){
		conntactRepository.deleteById(id);
		return true;
	}
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.PUT)
	public Conntact update(@PathVariable Long id,@RequestBody Conntact c){
		c.setId(id);
		return conntactRepository.save(c);
	}

}
