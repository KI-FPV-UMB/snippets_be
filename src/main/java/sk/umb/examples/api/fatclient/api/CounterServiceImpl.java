package sk.umb.examples.api.fatclient.api;

public class CounterServiceImpl implements CounterService {
    @Override
    public int increment(int number) {
        return number + 1;
    }
}
