package com.cesi.group2.Madera;

import org.springframework.data.repository.CrudRepository;

import com.cesi.group2.Madera.Client;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ClientRepository extends CrudRepository<Client, Integer> {

	void deleteByRefClient(String refClient);

}
