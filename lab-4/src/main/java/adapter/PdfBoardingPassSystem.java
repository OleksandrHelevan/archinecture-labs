package adapter;

public class PdfBoardingPassSystem {
    public void createPdfPass(String name, String flight) {
        System.out.println("PDF талон згенеровано:");
        System.out.println("Пасажир: " + name + " | Рейс: " + flight);
    }
}