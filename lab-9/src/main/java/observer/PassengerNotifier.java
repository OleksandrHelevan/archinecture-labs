package observer;

public class PassengerNotifier implements Observer {
    private final String name;

    public PassengerNotifier(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("[Email для пасажира " + name + "]: " + message);
    }
}
