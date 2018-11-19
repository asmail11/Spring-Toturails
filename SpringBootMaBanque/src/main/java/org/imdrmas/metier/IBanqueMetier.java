package org.imdrmas.metier;

import org.imdrmas.entities.Compte;
import org.imdrmas.entities.Operation;
import org.springframework.data.domain.Page;

public interface IBanqueMetier {
  public Compte consulterCompte(String codeCpte);
  public void verser(String codeCpte,double montent);
  public void retirer(String codeCpte,double montent);
  public void virement(String codeCpte1,String codeCpte2,double montent);
  public Page<Operation> listOperation(String codeCpte, int page, int size);
}
