package sk.umb.examples.api.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sk.umb.examples.api.api.CounterService;

@RestController
public class CounterServiceController {
    private final CounterService counterService;

    public CounterServiceController(CounterService counterService) {
        this.counterService = counterService;
    }

    @GetMapping("/api/{number}")
    public int increment(@PathVariable("number") int number) {
        System.out.println("Rest API called.");

        return counterService.increment(number);
    }
}
