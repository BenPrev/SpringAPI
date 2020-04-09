package com.cesi.group2.Madera;

import org.springframework.data.repository.CrudRepository;
import com.cesi.group2.Madera.Projet;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ProjetRepository extends CrudRepository<Projet, Integer> {

	void deleteByRefProjet(String refProjet);

	Projet findByRefClient(String refClient);

	Iterable<Projet> findAllByRefClient(String refClient);

}
