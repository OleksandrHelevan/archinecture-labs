package mediator;

// FlightMediator.java
import java.util.Arrays;
import java.util.List;

public class FlightMediator implements Mediator {
    private SearchForm searchForm;
    private ResultList resultList;
    private PaymentButton paymentButton;

    public void registerComponents(SearchForm form, ResultList list, PaymentButton button) {
        this.searchForm = form;
        this.resultList = list;
        this.paymentButton = button;

        form.setMediator(this);
        list.setMediator(this);
        button.setMediator(this);
    }

    @Override
    public void notify(Component sender, Event event) {
        switch (event) {
            case SEARCH: {
                System.out.println("Пошук рейсів з " + searchForm.getFrom() + " до " + searchForm.getTo());
                List<String> results = Arrays.asList(
                        "PS101 " + searchForm.getFrom() + " → " + searchForm.getTo() + " | 5400₴",
                        "PS202 " + searchForm.getFrom() + " → " + searchForm.getTo() + " | 6200₴"
                );
                resultList.showResults(results);
                paymentButton.setEnabled(false);
            }
            case SELECT: {
                System.out.println("Рейс вибрано.");
                paymentButton.setEnabled(true);
            }
            case PAY: System.out.println("Оплата квитка... Успішно!");
        }
    }
}
