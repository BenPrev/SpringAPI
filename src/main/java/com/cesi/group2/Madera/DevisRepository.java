package com.cesi.group2.Madera;

import org.springframework.data.repository.CrudRepository;

import com.cesi.group2.Madera.Devis;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DevisRepository extends CrudRepository<Devis, Integer> {

	Devis findByRefDevis(String refDevis);

	void deleteByRefDevis(String refDevis);

	void deleteByRefProjet(String refProjet);

	Iterable<Devis> findAllByRefProjet(String refProjet);

}
