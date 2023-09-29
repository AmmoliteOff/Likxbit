package org.ammolite.likxbit.repo;

import org.ammolite.likxbit.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
}
