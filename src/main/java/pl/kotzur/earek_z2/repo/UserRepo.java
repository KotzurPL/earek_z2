package pl.kotzur.earek_z2.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kotzur.earek_z2.model.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
}
