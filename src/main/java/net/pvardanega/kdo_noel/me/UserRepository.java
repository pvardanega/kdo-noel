package net.pvardanega.kdo_noel.me;

import org.springframework.data.repository.CrudRepository;

interface UserRepository extends CrudRepository<User, Long> {
    User findByFirstName(String firstName);
}
