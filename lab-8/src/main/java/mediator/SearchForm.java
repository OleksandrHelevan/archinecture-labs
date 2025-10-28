package mediator;

import lombok.Getter;

@Getter
public class SearchForm implements Component {
    private Mediator mediator;
    private String from;
    private String to;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void setRoute(String from, String to) {
        this.from = from;
        this.to = to;
        mediator.notify(this, Event.SEARCH);
    }

}
