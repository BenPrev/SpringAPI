package com.cesi.group2.Madera;

import org.springframework.data.repository.CrudRepository;
import com.cesi.group2.Madera.Commercial;

public interface CommercialRepository extends CrudRepository<Commercial, Integer> {

	void deleteByRefCommercial(String refCommercial);
	
}
