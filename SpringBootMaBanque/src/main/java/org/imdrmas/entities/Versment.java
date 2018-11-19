package org.imdrmas.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("V")
public class Versment extends Operation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Versment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versment(Date dateOperation, double montant, Compte compte) {
		super(dateOperation, montant, compte);
		// TODO Auto-generated constructor stub
	}
	

}
