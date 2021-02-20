package tech.becoming.clickandcollect.app.users;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends PagingAndSortingRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
