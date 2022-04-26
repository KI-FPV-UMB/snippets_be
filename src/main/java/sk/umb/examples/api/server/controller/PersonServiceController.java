package sk.umb.examples.api.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sk.umb.examples.api.api.PersonDto;
import sk.umb.examples.api.api.PersonService;

@RestController
public class PersonServiceController {
    private final PersonService personService;

    public PersonServiceController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/api/persons/{id}")
    public PersonDto increment(@PathVariable("id") int personId) {
        System.out.println("Rest API called.");

        return personService.getPerson(personId);
    }
}
