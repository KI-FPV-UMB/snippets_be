package sk.umb.examples.api.server.service;

import org.springframework.stereotype.Service;
import sk.umb.examples.api.api.CounterService;

@Service
public class CounterServiceImpl implements CounterService {
    @Override
    public int increment(int number) {
        return number + 1;
    }
}
