package by.rudenko.FirstSecurityApp.repositories;

import by.rudenko.FirstSecurityApp.models.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
Optional<Person> findByUsername(String username);
}
