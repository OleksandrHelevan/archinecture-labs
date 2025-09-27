package adapter.impl;

import adapter.BoardingPassGenerator;
import adapter.PdfBoardingPassSystem;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PdfPassAdapter implements BoardingPassGenerator {
    private final PdfBoardingPassSystem pdfApi;


    @Override
    public void generate(String passengerName, String flightNumber) {
        pdfApi.createPdfPass(passengerName, flightNumber);
    }
}