package model.repositories;


import model.enities.Client;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ClientRepository extends CrudRepository<Client, Integer> {

}