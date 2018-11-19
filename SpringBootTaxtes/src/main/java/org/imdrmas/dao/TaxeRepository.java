package org.imdrmas.dao;

import java.util.List;

import org.imdrmas.entities.Entreprise;
import org.imdrmas.entities.Taxe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxeRepository extends JpaRepository<Taxe, Long> {
   public List<Taxe> findByEntreprise(Entreprise entreprise);
}
