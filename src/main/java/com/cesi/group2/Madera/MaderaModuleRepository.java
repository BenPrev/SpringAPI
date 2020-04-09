package com.cesi.group2.Madera;

import org.springframework.data.repository.CrudRepository;

import com.cesi.group2.Madera.MaderaModule;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MaderaModuleRepository extends CrudRepository<MaderaModule, Integer> {

}