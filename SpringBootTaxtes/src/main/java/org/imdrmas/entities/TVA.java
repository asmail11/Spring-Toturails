package org.imdrmas.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("TVA")
public class TVA extends Taxe {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TVA() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TVA(String titre, Date dateTaxe, double montant, Entreprise entreprise) {
		super(titre, dateTaxe, montant, entreprise);
		// TODO Auto-generated constructor stub
	}


}
