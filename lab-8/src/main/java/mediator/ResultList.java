package mediator;

import java.util.ArrayList;
import java.util.List;

public class ResultList implements Component {
    private Mediator mediator;
    private List<String> results = new ArrayList<>();

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void showResults(List<String> flights) {
        results = flights;
        System.out.println("Знайдені рейси:");
        flights.forEach(System.out::println);
    }

    public void selectFirst() {
        if (!results.isEmpty()) {
            mediator.notify(this, Event.SELECT);
        }
    }
}
