package org.tcl.dataacces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.tcl.dataacces.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@CrossOrigin
public interface UserRepository extends CrudRepository<User, Integer> {

}
