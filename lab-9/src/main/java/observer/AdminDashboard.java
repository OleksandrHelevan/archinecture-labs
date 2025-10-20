package observer;

public class AdminDashboard implements Observer {
    @Override
    public void update(String message) {
        System.out.println("[Адмін-панель]: " + message);
    }
}
