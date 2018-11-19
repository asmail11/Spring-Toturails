package org.imdrmas.entities;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConntactRepository extends JpaRepository<Conntact, Long> {
	@Query("select c from Contact c where c.nom like :x")
    public Page<Conntact> search(@Param("x")String mc,Pageable pageable);
}
