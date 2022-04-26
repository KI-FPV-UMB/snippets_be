package sk.umb.examples.api.server.service;

import org.springframework.stereotype.Service;
import sk.umb.examples.api.api.PersonDto;
import sk.umb.examples.api.api.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
    public PersonDto getPerson(int personId) {
        PersonDto person = new PersonDto();

        if (personId == 1) {
            person.setName("Mark");
        } else if (personId == 2) {
            person.setName("John");
        } else if (personId == 3) {
            person.setName("Clark");
        } else {
            person.setName("UNKNOWN");
        }

        return person;
    }
}
