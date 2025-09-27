import adapter.*;
import adapter.impl.PdfPassAdapter;
import adapter.impl.TxtPassAdapter;
import bridge.DomesticFlight;
import bridge.Flight;
import bridge.InternationalFlight;
import bridge.AirbusImplementation;
import bridge.BoeingImplementation;

public class Main {
    public static void main(String[] args) {
        BoardingPassGenerator pdfAdapter = new PdfPassAdapter(new PdfBoardingPassSystem());
        OnlineTicketOffice office1 = new OnlineTicketOffice(pdfAdapter);
        office1.issueBoardingPass("Олександр", "PS101");

        BoardingPassGenerator txtAdapter = new TxtPassAdapter(new TxtBoardingPassSystem());
        OnlineTicketOffice office2 = new OnlineTicketOffice(txtAdapter);
        office2.issueBoardingPass("Вася", "LH202");

        Flight flight1 = new DomesticFlight(new BoeingImplementation());
        flight1.schedule("PS101");

        Flight flight2 = new InternationalFlight(new AirbusImplementation());
        flight2.schedule("PS202");
    }
}
