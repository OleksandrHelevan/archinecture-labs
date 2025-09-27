package adapter.impl;

import adapter.BoardingPassGenerator;
import adapter.TxtBoardingPassSystem;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TxtPassAdapter implements BoardingPassGenerator {
    private final TxtBoardingPassSystem txtSystem;


    @Override
    public void generate(String passengerName, String flightNumber) {
        txtSystem.makeTxtPass(passengerName, flightNumber);
    }
}