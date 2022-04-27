package sk.umb.examples.api.client;

public class PersonServiceImpl {
    public PersonDto getPerson(int number) {
        PersonDto person = new PersonDto();

        if (number == 1) {
            person.setName("Mark");
        } else if (number == 2) {
            person.setName("John");
        } else if (number == 3) {
            person.setName("Clark");
        } else {
            person.setName("UNKNOWN");
        }

        return person;
    }
}
