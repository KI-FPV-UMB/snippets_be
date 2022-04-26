package sk.umb.examples.api.fatclient;

import org.springframework.web.client.RestTemplate;
import sk.umb.examples.api.api.PersonDto;
import sk.umb.examples.api.api.PersonService;

public class PersonServiceClient implements PersonService {
    private RestTemplate restTemplate = new RestTemplate();

    public PersonDto getPerson(int personId) {
        return restTemplate.getForObject("http://localhost:8080/api/persons/" + personId,
                                         PersonDto.class);
    }
}
