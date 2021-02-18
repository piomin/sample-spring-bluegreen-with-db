package pl.piomin.samples.spring.bluegreen.person.repository;

import org.springframework.data.repository.CrudRepository;
import pl.piomin.samples.spring.bluegreen.person.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
