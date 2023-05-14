package pl.piomin.samples.spring.bluegreen.person.controller;

import org.springframework.web.bind.annotation.*;
import pl.piomin.samples.spring.bluegreen.person.model.Person;
import pl.piomin.samples.spring.bluegreen.person.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Person add(@RequestBody Person person) {
        return repository.save(person);
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") Long id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping
    public Iterable<Person> findAll() {
        return repository.findAll();
    }
}
