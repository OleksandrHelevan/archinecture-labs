package adapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OnlineTicketOffice {
    private final BoardingPassGenerator passGenerator;


    public void issueBoardingPass(String passenger, String flight) {
        System.out.println("Видача посадкового талону...");
        passGenerator.generate(passenger, flight);
        System.out.println("Пасажиру видано талон!");
    }
}