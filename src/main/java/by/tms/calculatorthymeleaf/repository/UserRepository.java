package by.tms.calculatorthymeleaf.repository;

import by.tms.calculatorthymeleaf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
