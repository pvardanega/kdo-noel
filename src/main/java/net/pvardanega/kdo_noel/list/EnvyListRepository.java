package net.pvardanega.kdo_noel.list;

import net.pvardanega.kdo_noel.me.User;
import org.springframework.data.repository.CrudRepository;

public interface EnvyListRepository extends CrudRepository<EnvyList, Long> {

    EnvyList findByOwner(User user);
}
